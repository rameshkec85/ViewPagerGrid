package com.viewpagergrod.viewpagergrid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final Context context;
    private final int cellSize;
    List<DummyData> mList = new ArrayList<>();

    public GridAdapter(Context context) {
        this.context = context;
        this.cellSize = Helper.getScreenWidth(context) / 4;
//        mListener = listener;
    }

    public void addItems(List<DummyData> list) {
        this.mList = new ArrayList<>(list);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.home_grid_image, parent, false);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
        layoutParams.height = cellSize;
        layoutParams.width = cellSize;
        layoutParams.setFullSpan(false);
        view.setLayoutParams(layoutParams);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        bindPhoto((PhotoViewHolder) holder, position);
        //
        ((PhotoViewHolder) holder).txt_title.setText(mList.get(position).title);
    }

    private void bindPhoto(final PhotoViewHolder holder, int position) {
        //
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView txt_title;

        public PhotoViewHolder(View view) {
            super(view);
            txt_title = (TextView) view.findViewById(R.id.txt_title);
        }
    }


}
