package com.cm.recyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    ArrayList<Serie> favoritos;
    LinearLayoutManager lManager;
    Button series_buttom;
    Button favorite;
    View left, middle, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.leftV);
        right = findViewById(R.id.rightV);
        favoritos = new ArrayList<>();
        series = new ArrayList<>();

        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new SeriesAdapter(series, this);
        rv.setAdapter(adapter);

        series_buttom = findViewById(R.id.serie_buttom);
        favorite = findViewById(R.id.favoritos);

        series_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resizeRight();
                adapter.SetFalse();
                adapter = new SeriesAdapter(series, view.getContext());
                rv.setAdapter(adapter);
            }
        });
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resizeLeft();
                adapter.SetTrue();
                adapter = new SeriesAdapter(series, view.getContext());
                rv.setAdapter(adapter);
            }
        });
    }

    public void prepareSeries() {
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("The Walking Dead", "13", R.drawable.wd, "TV show created by Robert Kirgman"));
        series.add(new Serie("Game of Thrones", "13", R.drawable.got, "TV show created by George R. Martin"));
        series.add(new Serie("Breaking bad", "13", R.drawable.bb, "TV show created by Vince Gilligan"));
    }

    public void Change (Serie like){
        favoritos.add(like);
    }
    public void Remove (String x){
        int count =0;
        for (Serie e : favoritos){
            if (e.getName() == x){
                break;
            }
            count++;
        }
        favoritos.remove(count);
        if (adapter.ischeck()){
            adapter = new SeriesAdapter(favoritos, this);
            rv.setAdapter(adapter);
        }
    }
    public void resizeLeft(){
        left.setVisibility(View.INVISIBLE);
        right.setVisibility(View.VISIBLE);
    }
    public void resizeRight(){
        left.setVisibility(View.VISIBLE);
        right.setVisibility(View.INVISIBLE);
    }

}
