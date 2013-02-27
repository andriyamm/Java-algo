package org.amm.algo.graphs.path;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class WeightedEdge implements Comparable<WeightedEdge> {

	private Integer from;
	private Integer to;
	private int weight;

	public WeightedEdge() {
		super();
	}

	public WeightedEdge(Integer from, Integer to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int compareTo(WeightedEdge edge) {
		if (weight - edge.getWeight() < 0) {
			return -1;
		} else if (weight - edge.getWeight() > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(weight).append(from)
				.append(to).toHashCode();
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
				.append(from, rhs.from).append(to, rhs.to).isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("from", from).append("to", to)
				.append("weight", weight).toString();
	}

}
