package org.amm.algo.graphs.karger;

import static org.junit.Assert.assertEquals;

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
	public void kargerMinCutAlgo_t0_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t0.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(2, kargerMinCutMap.kargerMinCutAlgo(graph));
	}

	@Test
	public void kargerMinCutAlgo_t1_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(2, kargerMinCutMap.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t2_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, kargerMinCutMap.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t3_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(3, kargerMinCutMap.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t4_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t4.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(4, kargerMinCutMap.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t_Test() {

		Map<Integer, ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readDataToMap("res/karger/t.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(17, kargerMinCutMap.kargerMinCutAlgo(graph));
	}
}
