package org.amm.algo.sort.qs;

import org.amm.algo.sort.qs.pivot.IPivot;
import org.amm.algo.utils.AlgoHelper;

public class QuickSort {
	
	private IPivot pivot;

	public static QuickSort getInstance() {
		return new QuickSort();
	}

	/**
	 * 
	 * @param values
	 * @param start
	 * @param length
	 */
	public void quickSort(Integer[] values, int start, int length) {
		// Check for empty or null array
		if (values == null || values.length == 0) {
			return;
		}
		if (length == 0 || (start - length) == 0) {
			return;
		}

		int p = pivot.ChoosePivot(values, start, length - 1);

		int i = partition(values, p, length);
		if (start <= i - 1) {
			quickSort(values, start, i);
		}
		if (i + 1 <= length) {
			quickSort(values, i + 1, length);
		}
	}

	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public int partition(Integer[] array, int start, int end) {

		int p = array[start];
		int i = start + 1;
		for (int j = start + 1; j < end; j++) {
			if (array[j] < p) {
				AlgoHelper.swap(array, i, j);
				i++;
			}
		}
		if (start < i) {
			AlgoHelper.swap(array, start, i - 1);
		}
		return i - 1;
	}

	// getters and setters
	
	public IPivot getPivot() {
		return pivot;
	}

	public void setPivot(IPivot pivot) {
		this.pivot = pivot;
	}

}
