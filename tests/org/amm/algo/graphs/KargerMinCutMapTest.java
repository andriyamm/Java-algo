package org.amm.algo.graphs;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import org.amm.algo.graphs.karger.KargerMinCutMap;
import org.amm.algo.utils.AlgoFileHelper;
import org.junit.Before;
import org.junit.Test;

public class KargerMinCutMapTest {

	private KargerMinCutMap kargerMinCutMap;
	
	@Before
	public void setUp() {
		kargerMinCutMap = new KargerMinCutMap();
	}

	@Test
	public void kargerMinCutAlgoTest() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//long minCut = kargerMinCut.kargerMinCutAlgo(graph);
		long minCut = kargerMinCutMap.kargerMinCutAlgo(graph);
		
		System.out.println(minCut);
	}

}
