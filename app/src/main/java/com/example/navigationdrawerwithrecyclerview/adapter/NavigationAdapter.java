package com.example.navigationdrawerwithrecyclerview.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.navigationdrawerwithrecyclerview.R;
import com.example.navigationdrawerwithrecyclerview.model.NavigationData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    private List<NavigationData> navigationDatas;
    private INavigation listener;

    public NavigationAdapter(INavigation listener) {
        navigationDatas = new ArrayList<>();
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Nullable @BindView(R.id.tvNavigationName) TextView tvNavigationName;
        @Nullable @BindView(R.id.ivNavigation) ImageView ivNavigation;

        @OnClick(R.id.ivNavigation) void onClickIcon()
        {
            if(ivNavigation != null)
            listener.onIconClick(Integer.parseInt(ButterKnife.findById(ivNavigation,R.id.ivNavigation).getTag().toString()));
        }

        private ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            listener.onViewClick(Integer.parseInt(view.getTag().toString()));
        }
    }

    @Override
    public NavigationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_navigation, parent, false);

        return new NavigationAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NavigationAdapter.ViewHolder holder, int position) {
        NavigationData navigationData = navigationDatas.get(position);
        if (holder.tvNavigationName != null) {
            holder.tvNavigationName.setText(navigationData.getName());
        }
        if (holder.ivNavigation != null) {
            holder.ivNavigation.setImageResource(navigationData.getDrawableId());
            holder.ivNavigation.setTag(position);
        }

        holder.itemView.setTag(position);
        holder.itemView.setBackgroundResource(navigationData.isSelected() ? R.color.ripple_color : android.R.color.transparent);
    }

    @Override
    public int getItemCount() {
        return navigationDatas.size();
    }

    public void refreshAdapter(ArrayList<NavigationData> data) {
        navigationDatas.clear();
        navigationDatas.addAll(data);
        notifyDataSetChanged();
    }

    public void setSelected(int position)
    {
        for (int i = 0; i < navigationDatas.size(); i++) {
            navigationDatas.get(i).setSelected(i == position);
        }

        notifyDataSetChanged();
    }
}
