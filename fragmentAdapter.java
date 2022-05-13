package com.example.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragmentAdapter extends RecyclerView.Adapter<fragmentAdapter.MyViewHolder> {
    Context context;
    ArrayList<FragmentRecyclerModel>additionalNewsList;

    public fragmentAdapter(Context context , ArrayList<FragmentRecyclerModel>additionalNewsList)
    {
        this.context =context;
        this.additionalNewsList=additionalNewsList;
    }


    @NonNull
    @Override
    public fragmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.relatednews, parent, false);
        return new fragmentAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fragmentAdapter.MyViewHolder holder, int position) {
        holder.img.setImageResource(additionalNewsList.get(position).getImg());
        holder.headline.setText(additionalNewsList.get(position).getHeadline());

    }

    @Override
    public int getItemCount() {
        return additionalNewsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView headline;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img= itemView.findViewById(R.id.imageView2);
            headline= itemView.findViewById(R.id.headline);

        }
    }

}
