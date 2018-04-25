package com.cm.recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by UCA on 18/04/2018.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Serie> series;

    private static boolean check = false;

    private Context mcontext;
    private int lastPosition=-1;

    public SeriesAdapter(ArrayList<Serie> series, Context context) {
        this.series = series;
        this.mcontext=context;

    }

    public void SetTrue() {
        check=true;
    }
    public void SetFalse() {
        check=false;
    }


    public static class SeriesViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView name;
        ImageView img;
        RatingBar click;

        public SeriesViewHolder(View itemView) {
            super(itemView);
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
            click= itemView.findViewById(R.id.ratingBar);
;         }

    }

    public boolean check(final int position){
        series.get(position).setCheck(!series.get(position).isCheck());
        return series.get(position).isCheck();
    }

    @Override

    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent, false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(final SeriesViewHolder holder, final int position) {

        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());


        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check(position)){
                    holder.click.setIsIndicator(true);
                    if (mcontext instanceof MainActivity){
                        ((MainActivity)mcontext).Change(series.get(position));
                    }
                }
                else {
                    holder.click.setIsIndicator(false);
                    if (mcontext instanceof MainActivity){
                        ((MainActivity)mcontext).Change(series.get(position));
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return series.size();
    }
    public boolean ischeck(){
        return check;
    }

}

