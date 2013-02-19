package org.amm.algo.utils;


public class AlgoHelper {



	public static void swap(Integer[] array, int l, int r) {
		int temp = array[l];
		array[l] = array[r];
		array[r] = temp;
	}

	/**
	 * TODO
	 * 
	 * @param max
	 * @return
	 */
	public static int randomNumber(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}
}