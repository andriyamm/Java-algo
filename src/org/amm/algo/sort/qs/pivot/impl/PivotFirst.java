package org.amm.algo.sort.qs.pivot.impl;

import org.amm.algo.sort.qs.pivot.IPivot;


public class PivotFirst implements IPivot {
	
	@Override
	public int ChoosePivot(Integer[] array, int start, int end) {
		return start;
	}
}
