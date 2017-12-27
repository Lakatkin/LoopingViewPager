package com.asksira.loopingviewpager;

import java.util.ArrayList;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public interface ILoopingPagerAdapter<T> {

    int getListCount();

    int getLastItemPosition();

    void setItemList(ArrayList<T> secondDummyItems);

    T getDataItem (int listPosition);
}
