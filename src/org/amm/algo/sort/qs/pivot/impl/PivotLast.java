package org.amm.algo.sort.qs.pivot.impl;

import org.amm.algo.sort.qs.pivot.IPivot;
import org.amm.algo.utils.AlgoHelper;

public class PivotLast implements IPivot {

	@Override
	public int ChoosePivot(Integer[] array, int start, int end) {
		AlgoHelper.swap(array, start, end);
		return start;
	}
}
