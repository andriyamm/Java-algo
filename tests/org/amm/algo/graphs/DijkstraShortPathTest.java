package org.amm.algo.graphs;

import org.amm.algo.graphs.path.DijkstraShortPath;
import org.junit.Before;
import org.junit.Test;

public class DijkstraShortPathTest {

	private DijkstraShortPath dijkstraShortPath;

	@Before
	public void setUp() {
		dijkstraShortPath = new DijkstraShortPath();
	}

	@Test
	public void kosarajuAlgo_t2_Test() {
			dijkstraShortPath.init("res/dijkstra/t2.txt");
			dijkstraShortPath.run();
			dijkstraShortPath.print();
	}
	
	@Test
	public void kosarajuAlgo_t1_Test() {
			dijkstraShortPath.init("res/dijkstra/t1.txt");
			dijkstraShortPath.run();
			dijkstraShortPath.print();
	}
	
	@Test
	public void kosarajuAlgo_t0_Test() {
			dijkstraShortPath.init("res/dijkstra/t0.txt");
			dijkstraShortPath.run();
			dijkstraShortPath.print();
	}
	
	@Test
	public void kosarajuAlgo_t3_Test() {
			dijkstraShortPath.init("res/dijkstra/t3.txt");
			dijkstraShortPath.run();
			dijkstraShortPath.print();
	}
	
	@Test
	public void kosarajuAlgo_t_Test() {
			dijkstraShortPath.init("res/dijkstra/t.txt");
			dijkstraShortPath.run();
			dijkstraShortPath.print();
	}
}
