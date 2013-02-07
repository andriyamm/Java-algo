package org.amm.algo.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgoHelper {

	@SuppressWarnings("resource")
	public static ArrayList<ArrayList<Integer>> readMatrix(String filename)
			throws FileNotFoundException {

		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
		Scanner input = new Scanner(new File(filename));
		while (input.hasNextLine()) {
			Scanner rowReader = new Scanner(input.nextLine());
			ArrayList<Integer> row = new ArrayList<Integer>();
			while (rowReader.hasNextInt()) {
				row.add(rowReader.nextInt());
			}
			matrix.add(row);
		}
		return matrix;
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

	public static void swap(Integer[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

}