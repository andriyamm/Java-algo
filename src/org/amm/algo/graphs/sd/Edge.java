package org.amm.algo.graphs.sd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Edge implements Comparable<Edge>, IEdge{

	protected Vertix from;
	protected Vertix to;

	public Edge() {
		super();
	}

	public Edge(Vertix from, Vertix to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Vertix getFrom() {
		return from;
	}

	public void setFrom(Vertix from) {
		this.from = from;
	}

	public Vertix getTo() {
		return to;
	}

	public void setTo(Vertix to) {
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

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
