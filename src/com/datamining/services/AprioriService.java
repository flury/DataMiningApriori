package com.datamining.services;

import java.util.List;

public interface AprioriService {

	/**
	 * Method : Association Rule Generator
	 * @param userName
	 * @param binominalUid
	 * @param candidate
	 * @param atecedentConsequentProb
	 */
	public void AssociationRuleGenerator(String userName, String binominalUid, String candidate, Double atecedentConsequentProb);

	public void FrequentItemsetSupportGenerator(String binominalUid, double minSupport, double minConfidence, 
			int totalRecords, List<String> binominalInput, String userName);

}
