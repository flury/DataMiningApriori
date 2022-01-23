package com.datamining.ui.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.joda.time.IllegalFieldValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.datamining.entity.TblDataset;
import com.datamining.services.DatabaseService;
import com.datamining.services.GenericDaoService;
import com.datamining.util.Constant;
import com.opencsv.CSVReader;

@Controller
public class UploadDatasetController {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired
	private DatabaseService databaseService;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired 
	private HttpSession session;
	
	@RequestMapping("/uploaddataset")
	public String index(ModelMap modelMap, @RequestParam(required=false) String messagesSuccess,
			@RequestParam(required=false) String messagesError) {
		
		String userName = (String) session.getAttribute(Constant.SESS_USER_NAME);
		if(userName == null){
			return "redirect:/login";
		}
		
		if (messagesSuccess != null) {
			modelMap.put("messagesSuccess", messagesSuccess);
		}
		
		if (messagesError != null) {
			modelMap.put("messagesError", messagesError);
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<?> listDataset = genericDao.runHQL("FROM TblDataset ORDER BY id ASC ", params);
		modelMap.put("listDataset", listDataset);
		modelMap.put("totalData", listDataset.size());

		return "/uploaddataset";
	}
	
	@RequestMapping("/save-commit-dataset-file.pl")
	public String saveCommitDatasetFile(ModelMap modelMap, MultipartHttpServletRequest request) {
		
		String userName = (String) session.getAttribute(Constant.SESS_USER_NAME);
		if(userName == null){
			return "redirect:/login";
		}
		
		//1. build an iterator
		Iterator<String> itr =  request.getFileNames();
		MultipartFile mpf = null;
		
		while(itr.hasNext()) {
			mpf = request.getFile(itr.next());

			//copy file to local resources
			String webappRoot = servletContext.getRealPath("/");
			String relativeFolder = "storage" + File.separator;
			String filename = webappRoot + relativeFolder + mpf.getOriginalFilename();
			
			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(filename));
			} catch (Exception e) {
				modelMap.addAttribute("messagesError", "Error Messages : File not found, Please browse file upload.");
				return "redirect:/uploaddataset";
			}
			
			if (!mpf.getContentType().equals("text/csv") && !mpf.getContentType().equals("application/vnd.ms-excel")
					&& !mpf.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				modelMap.addAttribute("messagesError", "Error Messages : Invalid file extension, The valid file type is *.csv");
				return "redirect:/uploaddataset";
			}
			
			// Validate size
			if ((mpf.getSize()/1024) > Constant.MAX_UPLOAD_SIZE) {
          	  	modelMap.addAttribute("messagesError", "Error Messages : Maximum file size 1024Mb.");
          	  	return "redirect:/uploaddataset";
			}
			
			File file = new File(filename);
			CSVReader reader = null;
			long start = 0;
			
			/**
			 *  - split csv with ";"
			 *  - skip first row
			 */
			try {
				reader = new CSVReader(new FileReader(file), ';','"', 1);
	            String[] line;
	            start = System.currentTimeMillis();
	            
	            int j = 0;
	            while ((line = reader.readNext()) != null) {
	            	j++;
	            	
	            	String angkatan = "";
					String jenisKelamin = "";
					String prosesMasuk = "";
					String namaSekolah = "";
					String kotaSekolah = "";
					String jurusanSekolah = "";
					String prodi = "";
					String lamaStudi = "";
					String ipk = "";
					
	            	try {
	            		angkatan = line[0];
	            		jenisKelamin = line[1];
	            		prosesMasuk = line[2];
	            		namaSekolah = line[3];
	            		kotaSekolah = line[4];
	            		jurusanSekolah = line[5];
	            		prodi = line[6];
	            		lamaStudi = line[7].replace(",", ".");
	            		ipk = line[8].replace(",", ".");
					} catch (Exception e) {
						modelMap.addAttribute("messagesError", "Error format at row number " + j);
						return "redirect:/uploaddataset";
					}
	                
					// New TblDataset
	            	TblDataset dataset = new TblDataset();
					
	            	dataset.setAngkatan(angkatan);
	            	dataset.setJenisKelamin(jenisKelamin);
	            	dataset.setProsesMasuk(prosesMasuk);
	            	dataset.setNamaSekolah(namaSekolah);
	            	dataset.setKotaSekolah(kotaSekolah);
	            	dataset.setJurusanSekolah(jurusanSekolah);
	            	dataset.setProdi(prodi);
	            	dataset.setLamaStudi(new BigDecimal(lamaStudi));
	            	dataset.setIpk(new BigDecimal(ipk));
	            	dataset.setCreateDate(new Date());
	            	dataset.setCreateUser(userName);
	            	
					try {
						databaseService.saveOrUpdate(dataset);
					} catch (Exception e) {
						modelMap.addAttribute("messagesError", "Insert Error Messages : " + e.getMessage());
						return "redirect:/uploaddataset";
					}
					
	            }
				
				System.out.println("[saveCommitUploadFile] Time Taken First = " +(System.currentTimeMillis()-start));
			} catch (FileNotFoundException e) {
				modelMap.addAttribute("messagesError", "FileNotFoundException Error Messages : " + e.getMessage());
				return "redirect:/uploaddataset";
			} catch (IOException e) {
				modelMap.addAttribute("messagesError", "IOException Error Messages : " + e.getMessage());
				return "redirect:/uploaddataset";
			} catch (IllegalFieldValueException e) {
				modelMap.addAttribute("messagesError", "IllegalFieldValueException Error Messages : Invalid Value extension, " + e.getMessage());
				return "redirect:/uploaddataset";
			} catch (IllegalArgumentException e) {
				modelMap.addAttribute("messagesError", "IllegalArgumentException Error Messages : " + e.getMessage());
				return "redirect:/uploaddataset";
			} finally {
				if (reader != null) {
	                try {
	                	reader.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
			}
			
		  modelMap.addAttribute("messagesSuccess", "Upload file success, with " + (System.currentTimeMillis()-start) + " miliseconds.");
		}
		
		return "redirect:/uploaddataset";
	}
}
