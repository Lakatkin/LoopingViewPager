package com.asksira.loopingviewpagerdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.asksira.loopingviewpager.LoopingFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public class DemoFragmentAdapter extends LoopingFragmentPagerAdapter<Integer> {


    public DemoFragmentAdapter(Context context, FragmentManager fm, ArrayList<Integer> itemList, boolean isInfinite) {
        super(context, fm, itemList, isInfinite);
    }

    @Override
    protected void bindData(Fragment convertView, int listPosition) {
        DemoFragment demoFragment = (DemoFragment) convertView;
        DemoFragmentData fragmentData = new DemoFragmentData();
        fragmentData.color = getBackgroundColor(listPosition);
        fragmentData.num = itemList.get(listPosition);
        demoFragment.update(fragmentData);
    }

    @Override
    protected Fragment getViewFragment(int listPosition) {
        return DemoFragment.newInstance(itemList.get(listPosition), getBackgroundColor(listPosition));
    }

    private int getBackgroundColor(int number) {
        switch (number) {
            case 0:
                return android.R.color.holo_red_light;
            case 1:
                return android.R.color.holo_orange_light;
            case 2:
                return android.R.color.holo_green_light;
            case 3:
                return android.R.color.holo_blue_light;
            case 4:
                return android.R.color.holo_purple;
            case 5:
                return android.R.color.black;
            default:
                return android.R.color.black;
        }
    }


}
