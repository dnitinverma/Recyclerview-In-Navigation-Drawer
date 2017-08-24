package com.example.navigationdrawerwithrecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawerwithrecyclerview.R;

import butterknife.ButterKnife;

public class PopularTagsFragment extends Fragment {

    public static PopularTagsFragment newInstance()
    {
        return new PopularTagsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_tags,container,false);
        ButterKnife.bind(this,view);
        return view;
    }


}
