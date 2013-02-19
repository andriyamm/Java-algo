package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.amm.algo.utils.AlgoFileHelper;
import org.junit.Before;
import org.junit.Test;

public class KargerMinCutTest {

	private KargerMinCut kargerMinCut;

	@Before
	public void setUp() {
		kargerMinCut = new KargerMinCut();
	}

	@Test
	public void kargerMinCutAlgoTest() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long minCut = kargerMinCut.kargerMinCutAlgo(graph);

		System.out.println(minCut);
	}
}
