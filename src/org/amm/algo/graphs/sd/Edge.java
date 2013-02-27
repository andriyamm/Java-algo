package org.amm.algo.graphs.sd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Edge implements IEdge{

	protected Integer from;
	protected Integer to;

	public Edge() {
		super();
	}

	public Edge(Integer from, Integer to) {
		super();
		this.from = from;
		this.to = to;
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

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(from).append(to).toHashCode();
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

		Edge rhs = (Edge) obj;
		return new EqualsBuilder().append(from, rhs.from).append(to, rhs.to)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("from", from).append("to", to)
				.toString();
	}

//	@Override
//	public int compareTo(Edge o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
