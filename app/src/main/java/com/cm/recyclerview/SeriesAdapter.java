package com.cm.recyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UCA on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Serie> series;

    public SeriesAdapter(ArrayList<Serie> series) {
        this.series = series;
    }

    public static class SeriesViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView name;
        ImageView img;

        public SeriesViewHolder(View itemView) {
            super(itemView);
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
;         }

    }

    @Override
    public SeriesAdapter.SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent, false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(SeriesAdapter.SeriesViewHolder holder, int position) {
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());


    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}
