package com.example.navigationdrawerwithrecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawerwithrecyclerview.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FeedsFragment extends Fragment {

    private Unbinder unbinder;

    public static FeedsFragment newInstance()
    {
        return new FeedsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feeds,container,false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
