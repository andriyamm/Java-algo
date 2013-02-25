package org.amm.algo.graphs.sd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WeightedEdge extends Edge {

	private int weight;
	
	public WeightedEdge() {
		super();
	}

	public WeightedEdge(Vertix from, Vertix to, int weight) {
		super(from, to);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(weight)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		WeightedEdge rhs = (WeightedEdge) obj;
		return new EqualsBuilder().append(weight, rhs.weight)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("weight", weight)
				.toString();
	}
}
