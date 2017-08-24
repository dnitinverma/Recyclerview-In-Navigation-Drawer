package com.example.navigationdrawerwithrecyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawerwithrecyclerview.NavigationActivity;
import com.example.navigationdrawerwithrecyclerview.R;
import com.example.navigationdrawerwithrecyclerview.adapter.INavigation;
import com.example.navigationdrawerwithrecyclerview.adapter.NavigationAdapter;
import com.example.navigationdrawerwithrecyclerview.model.NavigationData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NavigationFragment extends Fragment implements INavigation {

    public static final String TAG = NavigationFragment.class.getSimpleName();

    @BindView(R.id.rvNavigation)
    RecyclerView rvNavigation;

    private NavigationAdapter adapter;

    private int array_icons [] = {R.drawable.icon_menu_news,R.drawable.icon_menu_feeds,R.drawable.icon_menu_watchlive,R.drawable.icon_menu_popular_tags,R.drawable.icon_menu_settings,R.drawable.icon_menu_about};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static NavigationFragment newInstance() {
        NavigationFragment navigationFragment = new NavigationFragment();
        Bundle args = new Bundle();
        navigationFragment.setArguments(args);
        return navigationFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        ButterKnife.bind(this, view);
        fillData();
        setAdapter();
        adapter.setSelected(0);
        return view;
    }

    private ArrayList<NavigationData> fillData() {
        ArrayList<NavigationData> navigationDataArrayList = new ArrayList<>();
        String array_navigation []= getResources().getStringArray(R.array.array_navigation);

        for (int i = 0; i <array_navigation.length ; i++) {
            NavigationData navigationData = new NavigationData();
            navigationData.setName(array_navigation[i]);
            navigationData.setDrawableId(array_icons[i]);
            navigationDataArrayList.add(navigationData);
        }

        return navigationDataArrayList;
    }

    private void setAdapter() {
        adapter = new NavigationAdapter(this);
        rvNavigation.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNavigation.setAdapter(adapter);

        adapter.refreshAdapter(fillData());
    }

    @Override
    public void onViewClick(int position) {
        Log.e(TAG,"View"+position);
        replaceFragment(position);
    }

    @Override
    public void onIconClick(int position) {
        Log.e(TAG,"Icon"+position);
        replaceFragment(position);
    }

    private void replaceFragment(int position)
    {
        ((NavigationActivity)getActivity()).replaceFragment(position);
        adapter.setSelected(position);
    }
}
