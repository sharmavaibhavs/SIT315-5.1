package com.example.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;




public class relatedNewsAdapter extends RecyclerView.Adapter<relatedNewsAdapter.relatedNewsViewHolder>{

    private List<relatedNews> newsList;
    private Context context;
    private OnRowClickListener listener;

    public relatedNewsAdapter(List<relatedNews> newsList, Context context, OnRowClickListener clickListener){
        this.newsList = newsList;
        this.context = context;
        this.listener = clickListener;
    }


    @NonNull
    @Override
    public relatedNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.place_row, parent, false);
        return new relatedNewsViewHolder(itemView,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull relatedNewsViewHolder holder, int position) {
        holder.newsImg.setImageResource(newsList.get(position).getImg());
        holder.headLineTextView.setText(newsList.get(position).getHeadL());
//        holder.descriptionTextView.setText(newsList.get(position).getFullNews());

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class relatedNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView  newsImg;
        public TextView  headLineTextView;
        public OnRowClickListener onRowClickListener;

        public relatedNewsViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);
            newsImg = itemView.findViewById(R.id.newsImg);
            headLineTextView = itemView.findViewById(R.id.headLineTextView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener{
        void onItemClick(int position);
    }
}
