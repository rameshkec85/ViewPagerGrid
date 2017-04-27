package com.viewpagergrod.viewpagergrid;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramesh on 27/04/17.
 */

public class DummyFragment extends Fragment {
    public static Fragment newInstance(List<DummyData> subList, int pageNo) {
        //
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("data", (ArrayList<? extends Parcelable>) subList);
        bundle.putInt("pageNo", pageNo);
        DummyFragment fragment = new DummyFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getActivity()).inflate(R.layout.dummy_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView txt_title = (TextView) getView().findViewById(R.id.txt_title);
        txt_title.setText("" + (getArguments().getInt("pageNo") + 1));
    }
}
