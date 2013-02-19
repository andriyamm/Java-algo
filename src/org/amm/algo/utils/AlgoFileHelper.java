package org.amm.algo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoFileHelper {
	
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

}
