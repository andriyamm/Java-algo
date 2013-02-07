package org.amm.algo.sort.qs.pivot.impl;

import org.amm.algo.sort.qs.pivot.IPivot;
import org.amm.algo.utils.AlgoHelper;

public class PivotMedian implements IPivot {

	@Override
	public int ChoosePivot(Integer[] array, int start, int end) {
		int mid = start + (end - start) / 2;

		if (array[start] < array[mid]) {
			if (array[mid] < array[end]) {
				AlgoHelper.swap(array, start, mid);
			} else if (array[start] < array[end]) {
				AlgoHelper.swap(array, start, end);
			}// else start - pivot (do nothing)
		} else if (array[start] > array[end]) {
			if (array[mid] < array[end]) {
				AlgoHelper.swap(array, start, end);
			} else {
				AlgoHelper.swap(array, start, mid);
			}
		}// else start - pivot (do nothing)

		return start;
	}
}
