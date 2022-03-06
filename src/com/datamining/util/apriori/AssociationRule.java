package com.datamining.util.apriori;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AssociationRule<I> {

	private final Set<I> antecedent = new HashSet<>();
	private final Set<I> consequent = new HashSet<>();
	private double confidence;

	public AssociationRule(Set<I> antecedent, 
			Set<I> consequent, 
			double confidence) {
		Objects.requireNonNull(antecedent, "The rule antecedent is null.");
		Objects.requireNonNull(consequent, "The rule consequent is null.");
		this.antecedent.addAll(antecedent);
		this.consequent.addAll(consequent);
		this.confidence = confidence;
	}
	
	public AssociationRule(Set<I> antecedent, Set<I> consequent) {
        this(antecedent, consequent, Double.NaN);
    }

    public Set<I> getAntecedent() {
        return Collections.<I>unmodifiableSet(antecedent);
    }

    public Set<I> getConsequent() {
        return Collections.<I>unmodifiableSet(consequent);
    }

    public double getConfidence() {
        return confidence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(Arrays.toString(antecedent.toArray()));
        sb.append(" -> ");
        sb.append(Arrays.toString(consequent.toArray()));
        //sb.append(": ");
        //sb.append(confidence);

        return sb.toString();
    }

    @Override
    public int hashCode() {
        return antecedent.hashCode() ^ consequent.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        AssociationRule<I> other = (AssociationRule<I>) obj;

        return antecedent.equals(other.antecedent) &&
               consequent.equals(other.consequent);
    }

}
