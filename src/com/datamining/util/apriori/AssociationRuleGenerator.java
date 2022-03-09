package com.datamining.util.apriori;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AssociationRuleGenerator<I> {

	public List<AssociationRule<I>> mineAssociationRules(FrequentItemsetData<I> data,
			double minimumConfidence) {
		Objects.requireNonNull(data, "The frequent itemset data is null.");
		checkMinimumConfidence(minimumConfidence);

		Set<AssociationRule<I>> resultSet = new HashSet<>();

		// get itemsetSize
		System.out.println("itemset " + data.getTransactionNumber());
		
		
		for (Set<I> itemset : data.getFrequentItemsetList()) {
			if (itemset.size() < 2) {
				// Any association rule requires at least one item in the 
				// antecedent, and at least one item in the consequent. An
				// itemset containing less than two items cannot satisfy this
				// requirement; skip it.
				continue;
			}

			// Generate the basic association rules out of current itemset.
			// An association rule is basic iff its consequent contains only one
			// item.
			Set<AssociationRule<I>> basicAssociationRuleSet = generateAllBasicAssociationRules(itemset, data);

			generateAssociationRules(itemset, basicAssociationRuleSet, data, minimumConfidence, resultSet, 
					data.getMaximumNumberOfItemset());
		}

		List<AssociationRule<I>> ret = new ArrayList<>(resultSet);
		
		return ret;

//		Collections.sort(ret, (a1, a2) -> { 
//			return Double.compare(a2.getConfidence(), a1.getConfidence()); 
//		});
//
//		return ret.stream()
//				.sorted((a1, a2) -> Double.compare(a2.getConfidence(), a1.getConfidence()))
//		        .collect(Collectors.toList());
		
	}

	private void generateAssociationRules(Set<I> itemset, final Set<AssociationRule<I>> ruleSet,
			final FrequentItemsetData<I> data, double minimumConfidence, Set<AssociationRule<I>> collector,
			final int itemsetSize) {
		
		if (ruleSet.isEmpty()) {
			return;
		}

		// The size of the itemset.
		int k = itemset.size(); 
		// The size of the consequent of the input rules.
		int m = ruleSet.iterator().next().getConsequent().size();

		// Test whether we can pull one more item from the antecedent to 
		// consequent.
		if (k > m + 1) {
			Set<AssociationRule<I>> nextRules =
					moveOneItemToConsequents(itemset, ruleSet, data, itemsetSize);

			Iterator<AssociationRule<I>> iterator = nextRules.iterator();

			while (iterator.hasNext()) {
				AssociationRule<I> rule = iterator.next();

//				if (rule.getConfidence() >= minimumConfidence) {
					collector.add(rule);
//				} else {
//					iterator.remove();
//				}
			}

			generateAssociationRules(itemset,
					nextRules,
					data,
					minimumConfidence,
					collector, itemsetSize);
		}
	}

	private Set<AssociationRule<I>> moveOneItemToConsequents(Set<I> itemset, Set<AssociationRule<I>> ruleSet, 
			FrequentItemsetData<I> data, int itemsetSize) {
		
		Set<AssociationRule<I>> output = new HashSet<>();
		Set<I> antecedent = new HashSet<>();
		Set<I> consequent = new HashSet<>();
		//double itemsetSupportCount = data.getSupportCountMap().get(itemset);

		// For each rule ...
		for (AssociationRule<I> rule : ruleSet) {
			
			// 4 must be setting as itemset parameter
			if ((rule.getAntecedent().size() + rule.getConsequent().size()) == itemsetSize) {
				
				antecedent.clear();
				consequent.clear();
				antecedent.addAll(rule.getAntecedent());
				consequent.addAll(rule.getConsequent());
	
				// ... move one item from its antecedent to its consequnt.
				for (I item : rule.getAntecedent()) {
					
					antecedent.remove(item);
					consequent.add(item);
					
					if (antecedent.size() > 0 && consequent.size() < 99) {
						
						AssociationRule<I> newRule = 
								new AssociationRule<>(antecedent, consequent);
						output.add(newRule);
						
						AssociationRule<I> newRule2 = 
								new AssociationRule<>(consequent, antecedent);
						output.add(newRule2);
					}
					
					antecedent.add(item);
					consequent.remove(item);
				}
			
			} // end-of-checking
		}

		return output;
	}

	/**
	 * Given a frequent itemset of size {@code n}, generates and returns all 
	 * {@code n} possible association rules with consequent of size one.
	 * 
	 * @param itemset the itemset.
	 * @return a set of association rules with consequents of size one.
	 */
	private Set<AssociationRule<I>> generateAllBasicAssociationRules(Set<I> itemset, FrequentItemsetData<I> data) {
		
		Set<AssociationRule<I>> basicAssociationRuleSet =
				new HashSet<>(itemset.size());

		Set<I> antecedent = new HashSet<>(itemset);
		Set<I> consequent = new HashSet<>(1);

		for (I item : itemset) {
			antecedent.remove(item);
			consequent.add(item);

			int itemsetSupportCount = data.getSupportCountMap().get(itemset);
			int antecedentSupportCount = data.getSupportCountMap()
					.get(antecedent);

			double confidence = 1.0 * itemsetSupportCount 
					/ antecedentSupportCount;

			basicAssociationRuleSet.add(new AssociationRule(antecedent, consequent, confidence));
			antecedent.add(item);
			consequent.remove(item);
		}

		return basicAssociationRuleSet;
	}

	private void checkMinimumConfidence(double minimumConfidence) {
		if (Double.isNaN(minimumConfidence)) {
			throw new IllegalArgumentException(
					"The input minimum confidence is NaN.");
		}

		if (minimumConfidence < 0.0) {
			throw new IllegalArgumentException(
					"The input minimum confidence is negative: " + 
							minimumConfidence + ". " +
					"Must be at least zero.");
		}

		if (minimumConfidence > 1.0) {
			throw new IllegalArgumentException(
					"The input minimum confidence is too large: " +
							minimumConfidence + ". " +
					"Must be at most 1.");
		}
	}

}
