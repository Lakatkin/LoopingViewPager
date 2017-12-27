package com.asksira.loopingviewpagerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mlakatkin on 27.12.2017.
 */

public class DemoFragment extends Fragment {


    private static final String NUM_KEY = "NUM_KEY";
    private static final String COLOR_KEY = "COLOR_KEY";
    private TextView description;
    private View image;
    private View rootView;

    public static DemoFragment newInstance(Integer num, int colorRes) {
        Bundle args = new Bundle();
        args.putInt(NUM_KEY, num);
        args.putInt(COLOR_KEY, colorRes);
        DemoFragment fragment = new DemoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.item_pager, null);
            description = rootView.findViewById(R.id.description);
            image = rootView.findViewById(R.id.image);
            update(getArguments().getInt(NUM_KEY), getArguments().getInt(COLOR_KEY));
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Nullable
    @Override
    public View getView() {
        return rootView;
    }

    public void update(final Integer num, final int colorRes) {
        Log.d("WTF", "update value " + num + " rootIsNull " + (rootView == null));
        if (rootView == null)
            return;
                image.setBackgroundColor(getContext().getResources().getColor(colorRes));
                description.setText(String.valueOf(num));
    }
}
