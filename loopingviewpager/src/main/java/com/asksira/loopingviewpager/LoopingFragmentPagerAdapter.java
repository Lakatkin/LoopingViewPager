package com.asksira.loopingviewpager;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public abstract class LoopingFragmentPagerAdapter<T> extends FragmentPagerAdapter implements ILoopingPagerAdapter<T> {

    protected Context context;
    private FragmentManager fm;
    protected ArrayList<T> itemList;

    protected boolean isInfinite = false;
    protected boolean canInfinite = true;


    public LoopingFragmentPagerAdapter(Context context, FragmentManager fm, ArrayList<T> itemList, boolean isInfinite) {
        super(fm);
        this.fm = fm;
        this.context = context;
        this.isInfinite = isInfinite;
        setItemList(itemList);
    }

    @Override
    public void setItemList(ArrayList<T> itemList) {
        if (this.itemList != null) {
            this.itemList.clear();
            this.itemList.addAll(itemList);
        } else
            this.itemList = itemList;
        canInfinite = itemList.size() > 1;
        notifyDataSetChanged();
    }

    @Override
    public T getDataItem(int listPosition) {
        if (listPosition >= 0 && listPosition < itemList.size()) {
            return itemList.get(listPosition);
        } else {
            return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return getViewFragment(getListPosition(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("WTF", "getItem " + position);
        Object convertView = super.instantiateItem(container, position);
        bindData((Fragment) convertView, getListPosition(position));
        return convertView;
    }

    protected abstract void bindData(Fragment convertView, int listPosition);

    protected abstract Fragment getViewFragment(int listPosition);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        int count = 0;
        if (itemList != null) {
            count = itemList.size();
        }
        if (isInfinite && canInfinite) {
            return count + 2;
        } else {
            return count;
        }
    }

    @Override
    public int getListCount() {
        return itemList == null ? 0 : itemList.size();
    }

    private int getListPosition(int position) {
        if (!(isInfinite && canInfinite)) return position;
        int arrayListPosition;
        if (position == 0) {
            arrayListPosition = getCount() - 1 - 2; //First item is a dummy of last item
        } else if (position > getCount() - 2) {
            arrayListPosition = 0; //Last item is a dummy of first item
        } else {
            arrayListPosition = position - 1;
        }
        return arrayListPosition;
    }

    @Override
    public int getLastItemPosition() {
        if (isInfinite) {
            return itemList == null ? 0 : itemList.size();
        } else {
            return itemList == null ? 0 : itemList.size() - 1;
        }
    }
}
