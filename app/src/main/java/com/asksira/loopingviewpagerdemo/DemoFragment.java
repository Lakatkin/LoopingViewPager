package com.asksira.loopingviewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.asksira.loopingviewpager.ViewPagerFragment;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public class DemoFragment extends ViewPagerFragment<DemoFragmentData> {


    private static final String NUM_KEY = "NUM_KEY";
    private static final String COLOR_KEY = "COLOR_KEY";
    private TextView description;
    private View image;


    public static DemoFragment newInstance(Integer num, int colorRes) {
        Bundle args = new Bundle();
        args.putInt(NUM_KEY, num);
        args.putInt(COLOR_KEY, colorRes);
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        DemoFragmentData fragmentData = new DemoFragmentData();
        fragmentData.color = getArguments().getInt(COLOR_KEY);
        fragmentData.num = getArguments().getInt(NUM_KEY);
        setCurrentData(fragmentData);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected View initUI(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_pager, null);
        description = rootView.findViewById(R.id.description);
        image = rootView.findViewById(R.id.image);
        return rootView;
    }

    @Override
    protected boolean bindData(DemoFragmentData data) {
        if (data == null)
            return false;
        image.setBackgroundColor(getContext().getResources().getColor(data.color));
        description.setText(String.valueOf(data.num));
        return true;
    }
}
