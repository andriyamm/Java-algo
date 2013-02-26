package org.amm.algo.graphs.karger;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.amm.algo.graphs.karger.KargerMinCut;
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
	public void kargerMinCutAlgo_t0_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t0.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(2, kargerMinCut.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t1_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t1.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(2, kargerMinCut.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t2_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(1, kargerMinCut.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t3_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(3, kargerMinCut.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t4_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t4.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(4, kargerMinCut.kargerMinCutAlgo(graph));
	}
	
	@Test
	public void kargerMinCutAlgo_t_Test() {

		ArrayList<ArrayList<Integer>> graph = null;
		try {
			graph = AlgoFileHelper.readData("res/karger/t.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		assertEquals(17, kargerMinCut.kargerMinCutAlgo(graph));
	}
}
