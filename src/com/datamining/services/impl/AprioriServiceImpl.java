package com.datamining.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.datamining.entity.TblFrequentDataConfidence;
import com.datamining.entity.TblFrequentDataSupport;
import com.datamining.entity.TblMasterItemset;
import com.datamining.services.AprioriService;
import com.datamining.services.DatabaseService;
import com.datamining.services.GenericDaoService;
import com.datamining.util.apriori.AprioriFrequentItemsetGenerator;
import com.datamining.util.apriori.AssociationRule;
import com.datamining.util.apriori.AssociationRuleGenerator;
import com.datamining.util.apriori.FrequentItemsetData;

/**
 * AprioriServiceImpl.java
 * Apriori service implementation
 * 
 * Version     : 0.01 
 * Create date : 26/Feb/2022
 * Create by   : Abdul Wahid Kamarullah
 *
 */
@Transactional
@Service("aprioriService")
public class AprioriServiceImpl implements AprioriService {

	@Autowired
	private GenericDaoService genericDao;
	
	@Autowired
	private DatabaseService databaseService;
	
	@Override
	public void AssociationRuleGenerator(String userName, String binominalUid, 
			String candidate, Double atecedentConsequentProb) {
		
		AprioriFrequentItemsetGenerator<String> generator =
                new AprioriFrequentItemsetGenerator<>();
		
		// String candidate = "5 9 18";
		String[] arrayCandidate = candidate.split(" ");
		
		Set<String> setCandidate = new HashSet<String>();
		if (arrayCandidate.length > 0) {
			for (String item : arrayCandidate) {
				setCandidate.add(item);
			}
		}
		
		List<Set<String>> itemsetList = new ArrayList<>();
        itemsetList.add(setCandidate);
        
        //List<Set<String>> itemsetList = new ArrayList<>();
        //itemsetList.add(new HashSet<>(Arrays.asList("1", "5", "9", "11", "18", "22")));
        
        FrequentItemsetData<String> data = generator.generate(itemsetList, 0.02);

        long startTime = System.nanoTime();
        List<AssociationRule<String>> associationRuleList = new AssociationRuleGenerator<String>()
                        .mineAssociationRules(data, 0.4);
        long endTime = System.nanoTime();

        int i = 1;
        System.out.println();
        System.out.println("--- Association rules ---");
        for (AssociationRule<String> rule : associationRuleList) {
            System.out.printf("%2d: %s\n", i++, rule);
            
            TblFrequentDataConfidence dateRule = new TblFrequentDataConfidence();
            dateRule.setId(UUID.randomUUID().toString());
            dateRule.setFrequentDataId(binominalUid);
            dateRule.setExecuteUser(userName);
			dateRule.setExecuteDate(new Date());
			
			dateRule.setCandidate(candidate);
			dateRule.setAntecedentCandidate(rule.getAntecedent().toString());
            dateRule.setConsequentCandidate(rule.getConsequent().toString());
			
            // TODO calculate confidence
            Double antecedentSupport = getSupportValue(binominalUid, rule.getAntecedent().toString());
            Double confidence = atecedentConsequentProb / antecedentSupport;
            
            dateRule.setAntecedentSupport(atecedentConsequentProb);
            dateRule.setConsequentSupport(antecedentSupport);
            dateRule.setConfidence(confidence);
            
            // TODO update description
            String antecedentCandidateLabel = getAssociationRuleDescription(rule.getAntecedent().toString());
    		String consequentCandidateLabel = getAssociationRuleDescription(rule.getConsequent().toString());
            
            dateRule.setDescriptionAntecedent(antecedentCandidateLabel);
            dateRule.setDescriptionConsequent(consequentCandidateLabel);
            
			databaseService.save(dateRule);
        }

        System.out.printf("Mined association rules in %d milliseconds.\n",
                          (endTime - startTime) / 1_000_000);
	}
	
	private String getAssociationRuleDescription(String candidate) {
		
		StringBuffer string = new StringBuffer();
		
		String candidateFormater = candidate.replace("[", "").replace("]", "").replace(",", "");
		String[] arrayCandidate = candidateFormater.split(" ");
		
		for (String item : arrayCandidate) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("id", new Long(item));
			
			List<?> listMaster = genericDao.runHQL("FROM TblMasterItemset "
					+ "WHERE id=:id ", params);
			
			if (listMaster.size() > 0) {
				TblMasterItemset itemset = (TblMasterItemset) listMaster.get(0);
				string.append(", " + itemset.getLabel());
			}
		}
		
		return string.substring(2).toString();
	}
	
	private Double getSupportValue(String binominalUid, String candidate) {
		
		Double support = new Double(0);
		String candidateFormater = candidate.replace("[", "").replace("]", "").replace(",", "");
		String[] arrayCandidate = candidateFormater.split(" ");
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		for (String item : arrayCandidate) {
			tree.add(new Integer(item.trim()));
		}
		
		String treeRemoveBraket = tree.toString();
		String treeRes = treeRemoveBraket.replace("]", "").replace("[", "").replace(",", "");
		
		System.out.println("treeRes :: " + treeRes);
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("frequentDataId", binominalUid);
		params.put("candidate", treeRes);
		
		List<?> listDataSupport = genericDao.runHQL("FROM TblFrequentDataSupport "
				+ "WHERE frequentDataId=:frequentDataId "
				+ "AND candidate=:candidate ", params);
		if (listDataSupport.size() > 0) {
			TblFrequentDataSupport sup = (TblFrequentDataSupport) listDataSupport.get(0);
			support = sup.getSupport();
		}
		
		return support;
	}

	@Override
	public void FrequentItemsetSupportGenerator(String binominalUid, double minSupport, double minConfidence, 
			int totalRecords, List<String> binominalInput, String userName) {
		
		Vector<String> candidates = new Vector<String>(); //the current candidates
		int numItems; 								//number of items per transaction
	    int numTransactions; 						//number of transactions
	    double minSup; 								//minimum support for a frequent itemset
	    String oneVal[]; 							//array of value per column that will be treated as a '1'
	    String itemSep = " "; 						//the separator value for items in the database
	    int itemsetNumber = 0; 						//the current itemset being looked at
	    String frequentDataId = binominalUid ;
	    
	    // initial settings
	    numItems = 22;
	    minSup = minSupport;
        numTransactions = totalRecords; //number of transactions
        
	    
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
