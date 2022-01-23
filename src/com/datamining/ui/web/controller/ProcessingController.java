package com.datamining.ui.web.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.entity.TblBinominalDataset;
import com.datamining.entity.TblDataset;
import com.datamining.services.DatabaseService;
import com.datamining.services.GenericDaoService;
import com.datamining.util.Constant;

@Controller
public class ProcessingController {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired
	private DatabaseService databaseService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/datamining-processing")
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
		
		return "/datamining-processing";
	}
	
	@RequestMapping("/execute-datamining-apriori.pl")
	public String executeDataMiningApriori(ModelMap modelMap,
			@RequestParam(required=false) double minSupport,
			@RequestParam(required=false) double minConfidence,
			@RequestParam(required=false) Integer totalRecords) {
		
		String userName = (String) session.getAttribute(Constant.SESS_USER_NAME);
		if(userName == null){
			return "redirect:/login";
		}
		
		Map<String, Object> params = new HashMap<String, Object>();
		List<?> listDataset = genericDao.runHQL("FROM TblDataset ORDER BY id ASC ", params, totalRecords);
		if (listDataset.size() > 0) {
			System.out.println("[info] Total Records Selected: " + listDataset.size());
			
			
			/**
			 * Step 01
			 * Convert data to Binomial
			 */
			String binominalUid = UUID.randomUUID().toString();
			for (int i = 0; i < listDataset.size(); i++) {
				TblDataset dataset = (TblDataset) listDataset.get(i);
				
				// New Table Binominal Dataset
				TblBinominalDataset binominalData = new TblBinominalDataset();
				binominalData.setBinominalId(binominalUid);
				binominalData.setExecuteDate(new Date());
				binominalData.setExecuteUser(userName);
				
				// set default value 0
				binominalData.setAngkatan13("0");
				binominalData.setAngkatan14("0");
				binominalData.setAngkatan15("0");
				binominalData.setAngkatan16("0");
				binominalData.setPria("0");
				binominalData.setWanita("0");
				binominalData.setBeasiswa("0");
				binominalData.setNilaiRaporDown7("0");
				binominalData.setNilaiRaporUp7("0");
				binominalData.setSma("0");
				binominalData.setSmk("0");
				binominalData.setJakarta("0");
				binominalData.setTangerang("0");
				binominalData.setLuarKota("0");
				binominalData.setTeknikInformatika("0");
				binominalData.setNonTeknikInformatika("0");
				binominalData.setIpkMemuaskan("0");
				binominalData.setIpkCumlaude("0");
				binominalData.setLamaStudiCepat("0");
				binominalData.setLamaStudiStandar("0");
				binominalData.setProdiTi("0");
				binominalData.setProdiSi("0");
				
				// Angkatan
				if (dataset.getAngkatan().equals(Constant.ANGKATAN_13)) {
					binominalData.setAngkatan13("1");
				} else if (dataset.getAngkatan().equals(Constant.ANGKATAN_14)) {
					binominalData.setAngkatan14("1");
				} else if (dataset.getAngkatan().equals(Constant.ANGKATAN_15)) {
					binominalData.setAngkatan15("1");
				} else if (dataset.getAngkatan().equals(Constant.ANGKATAN_16)) {
					binominalData.setAngkatan16("1");
				}
				
				// Jenis Kelamin
				if (dataset.getJenisKelamin().equals(Constant.JK_PRIA)) {
					binominalData.setPria("1");
				} else if (dataset.getJenisKelamin().equals(Constant.JK_WANITA)) {
					binominalData.setWanita("1");
				}
				
				// Proses Masuk
				if (dataset.getProsesMasuk().equals(Constant.PM_BEASISWA)) {
					binominalData.setBeasiswa("1");
				} else if (dataset.getProsesMasuk().equals(Constant.PM_NILAIRAPOR_DOWN_7)) {
					binominalData.setNilaiRaporDown7("1");
				} else if (dataset.getProsesMasuk().equals(Constant.PM_NILAIRAPOR_UP_7)) {
					binominalData.setNilaiRaporUp7("1");
				}
				
				//Nama Sekolah
				if (dataset.getNamaSekolah().equals(Constant.NS_SMA)) {
					binominalData.setSma("1");
				} else if (dataset.getNamaSekolah().equals(Constant.NS_SMK)) {
					binominalData.setSmk("1");
				}
				
				//Kota Sekolah
				if (dataset.getKotaSekolah().equals(Constant.KOTA_SEKOLAH_JAKARTA)) {
					binominalData.setJakarta("1");
				} else if (dataset.getKotaSekolah().equals(Constant.KOTA_SEKOLAH_TANGERANG)) {
					binominalData.setTangerang("1");
				} else if (dataset.getKotaSekolah().equals(Constant.KOTA_SEKOLAH_LUAR_KOTA)) {
					binominalData.setLuarKota("1");
				}
				
				//Jurusan Sekolah
				if (dataset.getJurusanSekolah().equals(Constant.JURUSAN_TEKNIK_INFORMATIKA)) {
					binominalData.setTeknikInformatika("1");
				} else if (dataset.getJurusanSekolah().equals(Constant.JURUSAN_NON_TEKNIK_INFORMATIKA)) {
					binominalData.setNonTeknikInformatika("1");
				}
				
				//IPK
				if (dataset.getIpk().compareTo(Constant.IPK) == 0 || 
						dataset.getIpk().compareTo(Constant.IPK) == -1) {
					binominalData.setIpkMemuaskan("1");
				} else if (dataset.getIpk().compareTo(Constant.IPK) == 1) {
					binominalData.setIpkCumlaude("1");
				}
				
				//Lama Studi
				if (dataset.getLamaStudi().compareTo(Constant.LAMA_STUDI) == 0 || 
						dataset.getLamaStudi().compareTo(Constant.LAMA_STUDI) == -1) {
					binominalData.setLamaStudiCepat("1");
				} else if (dataset.getLamaStudi().compareTo(Constant.LAMA_STUDI) == 1) {
					binominalData.setLamaStudiStandar("1");
				}
				
				//Prodi
				if (dataset.getProdi().equals(Constant.PRODI_TEKNIK_INFORMATIKA)) {
					binominalData.setProdiTi("1");
				} else if (dataset.getProdi().equals(Constant.PRODI_SISTEM_INFORMASI)) {
					binominalData.setProdiSi("1");
				}
				
				try {
					databaseService.save(binominalData);
				} catch (Exception e) {
					modelMap.addAttribute("messagesError", "Insert Error Messages : " + e.getMessage());
					return "redirect:/datamining-processing";
				}
			}
			
		}
		
		return "redirect:/datamining-processing";
	}
	
}
