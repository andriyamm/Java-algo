package org.amm.algo.graphs.sd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Edge<T> implements Comparable<Edge<T>>{

	protected Vertix<T> from;
	protected Vertix<T> to;

	public Edge() {
		super();
	}

	public Edge(Vertix<T> from, Vertix<T> to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Vertix<T> getFrom() {
		return from;
	}

	public void setFrom(Vertix<T> from) {
		this.from = from;
	}

	public Vertix<T> getTo() {
		return to;
	}

	public void setTo(Vertix<T> to) {
		this.to = to;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(from).append(to).toHashCode();
	}

	@SuppressWarnings("unchecked")
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

		Edge<T> rhs = (Edge<T>) obj;
		return new EqualsBuilder().append(from, rhs.from).append(to, rhs.to)
				.isEquals();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("from", from).append("to", to)
				.toString();
	}

	@Override
	public int compareTo(Edge<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
