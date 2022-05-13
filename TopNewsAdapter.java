package com.example.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.newsViewHolder> {
    private List<TopNews> topNewslist;
    private Context context;

    public TopNewsAdapter(List<TopNews> topNewslist, Context context) {
        this.topNewslist = topNewslist;
        this.context = context;
    }

    @NonNull
    @Override
    public TopNewsAdapter.newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_destination_row, parent, false);
        return new TopNewsAdapter.newsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNewsAdapter.newsViewHolder holder, int position) {
        holder.newsImage.setImageResource(topNewslist.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return topNewslist.size();
    }

    public class newsViewHolder extends RecyclerView.ViewHolder{
        public ImageView newsImage;

        public newsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.topPlaceImageView);

        }
    }
}
