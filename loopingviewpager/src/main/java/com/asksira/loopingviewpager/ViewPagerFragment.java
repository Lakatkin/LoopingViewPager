package com.asksira.loopingviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public abstract class ViewPagerFragment<T> extends Fragment implements IUpdatableFragment<T> {

    private View rootView;
    private T currentData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = initUI(inflater, container, savedInstanceState);
            bindData(getCurrentData());
        }
        return rootView;
    }

    @Nullable
    @Override
    public View getView() {
        return rootView;
    }


    protected abstract View initUI(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected abstract boolean bindData(T data);


    @Override
    public boolean update(T t) {
        currentData = t;
        if (rootView == null)
            return false;
        return bindData(t);
    }


    @Override
    public T getCurrentData() {
        return currentData;
    }

    public void setCurrentData(T currentData) {
        this.currentData = currentData;
    }
}
