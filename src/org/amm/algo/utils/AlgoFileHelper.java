package org.amm.algo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.amm.algo.graphs.sd.Vertix;

public class AlgoFileHelper {

	/**
	 * TODO
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<ArrayList<Integer>> readData(String filename)
			throws FileNotFoundException {

		ArrayList<ArrayList<Integer>> data = new ArrayList<ArrayList<Integer>>();
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			ArrayList<Integer> row = new ArrayList<Integer>();
			while (rowReader.hasNextInt()) {
				row.add(rowReader.nextInt());
			}
			data.add(row);
		}
		return data;
	}

	/**
	 * TODO
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Integer[] readArrayFromFile(String filename)
			throws FileNotFoundException {

		List<Integer> sb = new ArrayList<Integer>();
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			sb.add(Integer.parseInt(input.nextLine()));
		}
		input.close();

		return sb.toArray(new Integer[1]);
	}

	/**
	 * TODO
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Map<Integer, ArrayList<Integer>> readDataToMap(String filename)
			throws FileNotFoundException {

		Map<Integer, ArrayList<Integer>> data = new HashMap<Integer, ArrayList<Integer>>();
		int vertix = 0;

		Scanner input = new Scanner(new File(filename));

		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			ArrayList<Integer> row = new ArrayList<Integer>();
			if (rowReader.hasNextInt()) {

				// first number in row is the vertex label,
				// we will used it as key in map
				vertix = rowReader.nextInt();
				while (rowReader.hasNextInt()) {
					row.add(rowReader.nextInt());
				}
			}
			data.put(vertix, row);
		}
		return data;
	}

	/**
	 * TODO
	 * 
	 * @param <T>
	 * 
	 * @param filename
	 * @return
	 * @throws FileNotFoundException
	 */
	public static Map<Vertix<Integer>, Set<Vertix<Integer>>> readDataToMap1(
			String filename) throws FileNotFoundException {

		Map<Vertix<Integer>, Set<Vertix<Integer>>> data = new HashMap<Vertix<Integer>, Set<Vertix<Integer>>>();
		Vertix<Integer> from = null, to = null;
		Set<Vertix<Integer>> adjacencies = null;

		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			if (rowReader.hasNextInt()) {

				// first number in row is the vertex label,
				// we will used it as key in map
				from = new Vertix<Integer>(rowReader.nextInt());
				// second number in row
				if (rowReader.hasNextInt()) {
					to = new Vertix<Integer>(rowReader.nextInt());
				}

				if (!data.containsKey(from)) {
					adjacencies = new HashSet<Vertix<Integer>>();
					data.put(from, adjacencies);
				} else {
					adjacencies = data.get(from);
				}
				adjacencies.add(to);
			}
			data.put(from, adjacencies);
		}
		return data;
	}
}
