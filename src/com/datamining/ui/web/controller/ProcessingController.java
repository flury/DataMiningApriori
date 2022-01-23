package com.datamining.ui.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.datamining.entity.TblBinominalDataset;
import com.datamining.entity.TblDataset;
import com.datamining.entity.TblFrequentDataSupport;
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
			
			/**
			 * Step 02
			 * Get Data Binominal
			 */
			List<String> binominalInput = new ArrayList<String>();
			List<?> listDataBinominal = genericDao.runHQL("FROM TblBinominalDataset ORDER BY id ASC ", params, totalRecords);
			if (listDataBinominal.size() > 0) {
				for (int i = 0; i < listDataBinominal.size(); i++) {
					TblBinominalDataset dataBino = (TblBinominalDataset) listDataBinominal.get(i);
					
					StringBuilder strBino = new StringBuilder();
					strBino.append(dataBino.getAngkatan13() + " ");
					strBino.append(dataBino.getAngkatan14() + " ");
					strBino.append(dataBino.getAngkatan15() + " ");
					strBino.append(dataBino.getAngkatan16() + " ");
					strBino.append(dataBino.getPria() + " ");
					strBino.append(dataBino.getWanita() + " ");
					strBino.append(dataBino.getBeasiswa() + " ");
					strBino.append(dataBino.getNilaiRaporDown7() + " ");
					strBino.append(dataBino.getNilaiRaporUp7() + " ");
					strBino.append(dataBino.getSma() + " ");
					strBino.append(dataBino.getSmk() + " ");
					strBino.append(dataBino.getJakarta() + " ");
					strBino.append(dataBino.getTangerang() + " ");
					strBino.append(dataBino.getLuarKota() + " ");
					strBino.append(dataBino.getTeknikInformatika() + " ");
					strBino.append(dataBino.getNonTeknikInformatika() + " ");
					strBino.append(dataBino.getIpkCumlaude() + " ");
					strBino.append(dataBino.getIpkMemuaskan() + " ");
					strBino.append(dataBino.getLamaStudiCepat() + " ");
					strBino.append(dataBino.getLamaStudiStandar() + " ");
					strBino.append(dataBino.getProdiTi() + " ");
					strBino.append(dataBino.getProdiSi() + " ");
					
					binominalInput.add(strBino.toString());
					
					System.out.println("[info] :: " + strBino.toString());
				}
			}
			
			/**
			 * Step 03
			 * Apriori
			 */
			Vector<String> candidates = new Vector<String>(); //the current candidates
			int numItems; //number of items per transaction
		    int numTransactions; //number of transactions
		    double minSup; //minimum support for a frequent itemset
		    String oneVal[]; //array of value per column that will be treated as a '1'
		    String itemSep = " "; //the separator value for items in the database
		    int itemsetNumber=0; //the current itemset being looked at
		    String frequentDataId = binominalUid ;
		    
		    // initial settings
		    numItems = 22;
		    minSup = minSupport;
		    //number of transactions
            numTransactions = totalRecords;
            
		    
		    //while not complete
		    do {
		    	//increase the itemset that is being looked at
	            itemsetNumber++;
	            
	            //generate the candidates
	            candidates = generateCandidates(itemsetNumber, numItems, candidates);
	            
	            //determine and display frequent itemsets
	            candidates = calculateFrequentItemsets(itemsetNumber, numItems, candidates, numTransactions, binominalInput, minSup, minConfidence, 
	            		frequentDataId, userName);
	            
	            if (candidates.size() != 0) {
	            	System.out.println("Frequent " + itemsetNumber + "-itemsets :: " + candidates);
	            }
		    } while(candidates.size() > 1);
			
		}
		
		return "redirect:/datamining-processing";
	}
	
	/**
	 * 
	 * @param n
	 */
	private Vector<String> calculateFrequentItemsets(int n, int numItems, Vector<String> candidates, int numTransactions, 
			List<String> binominalInput, double minSup, double minConfidence, String frequentDataId, String userName) {
		
		Vector<String> frequentCandidates = new Vector<String>(); //the frequent candidates for the current itemset
        //FileInputStream file_in; //file input stream
        //BufferedReader data_in; //data input stream
        //FileWriter fw;
        //BufferedWriter file_out;

        StringTokenizer st, stFile; //tokenizer for candidate and transaction
        boolean match; //whether the transaction has all the items in an itemset
        boolean trans[] = new boolean[numItems]; //array to hold a transaction so that can be checked
        int count[] = new int[candidates.size()]; //the number of successful matches

        String itemSep = " "; //the separator value for items in the database
        String oneVal[]; //array of value per column that will be treated as a '1'
		oneVal = new String[numItems];
		for (int i=0; i<oneVal.length; i++) {
			oneVal[i] = "1";
		}
		System.out.println(Arrays.toString(oneVal));
			
        try
        {
                //output file
                //fw= new FileWriter(outputFile, true);
                //file_out = new BufferedWriter(fw);
                
                //load the transaction file
                //file_in = new FileInputStream(transaFile);
                //data_in = new BufferedReader(new InputStreamReader(file_in));

                //for each transaction
                for (int i = 0; i < binominalInput.size(); i++) {
                	String stDb = binominalInput.get(i);
                	
                	stFile = new StringTokenizer(stDb, itemSep); //read a line from the file to the tokenizer
                	
                	//put the contents of that line into the transaction array
                    for(int j=0; j<numItems; j++)
                    {
                        trans[j]=(stFile.nextToken().compareToIgnoreCase(oneVal[j])==0); //if it is not a 0, assign the value to true
                    }

                    //check each candidate
                    for(int c=0; c<candidates.size(); c++)
                    {
                        match = false; //reset match to false
                        //tokenize the candidate so that we know what items need to be present for a match
                        st = new StringTokenizer(candidates.get(c));
                        //check each item in the itemset to see if it is present in the transaction
                        while(st.hasMoreTokens())
                        {
                            match = (trans[Integer.valueOf(st.nextToken())-1]);
                            if(!match) //if it is not present in the transaction stop checking
                                break;
                        }
                        if(match) //if at this point it is a match, increase the count
                            count[c]++;
                    }
				}
                
                
                for(int i=0; i<candidates.size(); i++)
                {
                    //  System.out.println("Candidate: " + candidates.get(c) + " with count: " + count + " % is: " + (count/(double)numItems));
                    //if the count% is larger than the minSup%, add to the candidate to the frequent candidates
                    if ((count[i]/(double)numTransactions) >= minSup)
                    {
                        frequentCandidates.add(candidates.get(i));
                        //put the frequent itemset into the output file
                        //file_out.write(candidates.get(i) + "," + count[i]/(double)numTransactions + "\n");
                        System.out.println("[output] :> " + candidates.get(i) + "," + count[i]/(double)numTransactions + " itemset-" + n);
                        
                        // TODO Set Table FrequentDataSupport
                        TblFrequentDataSupport dataSup = new TblFrequentDataSupport();
                        dataSup.setItemsetNumber(n);
                        dataSup.setCandidate(candidates.get(i));
                        dataSup.setSupport(count[i]/(double)numTransactions);
                        dataSup.setExecuteDate(new Date());
                        dataSup.setExecuteUser(userName);
                        dataSup.setId(UUID.randomUUID().toString());
                        dataSup.setFrequentDataId(frequentDataId);
                        dataSup.setParamMinConfidence(minConfidence);
                        dataSup.setParamMinSupport(minSup);
                        dataSup.setParamTotalRecord(numTransactions);
                        databaseService.save(dataSup);
                    }
                }
                
                //file_out.write("-\n");
                //file_out.close();
        }
        //if error at all in this process, catch it and print the error messate
        catch(Exception e) {
        	e.printStackTrace();
            System.out.println(e);
        }
        //clear old candidates
        candidates.clear();
        //new candidates are the old frequent candidates
        candidates = new Vector<String>(frequentCandidates);
        frequentCandidates.clear();
        
        return candidates;
	}
	
	/**
	 * Method Name  : generateCandidates
     * Purpose      : Generate all possible candidates for the n-th itemsets
     *              : these candidates are stored in the candidates class vector
     * Parameters   : n - integer value representing the current itemsets to be created
     * Return       : None
	 * @param itemsetNumber
	 */
	private Vector<String> generateCandidates(int n, int numItems, Vector<String> candidates) {
		Vector<String> tempCandidates = new Vector<String>(); //temporary candidate string vector
        String str1, str2; //strings that will be used for comparisons
        StringTokenizer st1, st2; //string tokenizers for the two itemsets being compared
        
        //if its the first set, candidates are just the numbers
        if (n==1) {
            for(int i=1; i<=numItems; i++) {
                tempCandidates.add(Integer.toString(i));
            }
        } else if(n==2) //second itemset is just all combinations of itemset 1
        {
            //add each itemset from the previous frequent itemsets together
            for(int i=0; i<candidates.size(); i++)
            {
                st1 = new StringTokenizer(candidates.get(i));
                str1 = st1.nextToken();
                for(int j=i+1; j<candidates.size(); j++)
                {
                    st2 = new StringTokenizer(candidates.elementAt(j));
                    str2 = st2.nextToken();
                    tempCandidates.add(str1 + " " + str2);
                }
            }
        }
        else
        {
            //for each itemset
            for(int i=0; i<candidates.size(); i++)
            {
                //compare to the next itemset
                for(int j=i+1; j<candidates.size(); j++)
                {
                    //create the strigns
                    str1 = new String();
                    str2 = new String();
                    //create the tokenizers
                    st1 = new StringTokenizer(candidates.get(i));
                    st2 = new StringTokenizer(candidates.get(j));

                    //make a string of the first n-2 tokens of the strings
                    for(int s=0; s<n-2; s++)
                    {
                        str1 = str1 + " " + st1.nextToken();
                        str2 = str2 + " " + st2.nextToken();
                    }

                    //if they have the same n-2 tokens, add them together
                    if(str2.compareToIgnoreCase(str1)==0)
                        tempCandidates.add((str1 + " " + st1.nextToken() + " " + st2.nextToken()).trim());
                }
            }
        }
        //clear the old candidates
        candidates.clear();
        //set the new ones
        candidates = new Vector<String>(tempCandidates);
        tempCandidates.clear();
        
        return candidates;
	}
	
}
