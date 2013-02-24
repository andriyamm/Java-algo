package org.amm.algo.graphs.sd;

public class Vertix<T> {

	private final T name;
	private boolean visited = false; // used for Kosaraju's algorithm

	public Vertix(T name, boolean visited) {
		super();
		this.name = name;
		this.visited = visited;
	}

	public Vertix(T name) {
		super();
		this.name = name;
		this.visited = false;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public T getName() {
		return name;
	}

}
