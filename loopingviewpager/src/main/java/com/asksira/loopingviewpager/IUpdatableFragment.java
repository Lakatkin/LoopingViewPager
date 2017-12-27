package com.asksira.loopingviewpager;

/**
 * Created by mlakatkin on 21.12.2017.
 */

public interface IUpdatableFragment<DATA> {
	boolean update(DATA data);

	DATA getCurrentData();
}
