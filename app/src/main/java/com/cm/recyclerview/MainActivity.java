package com.cm.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Serie> series;
    LinearLayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        series= new ArrayList<>();

        rv = findViewById(R.id.recycler);
        rv.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        rv.setLayoutManager(lManager);

        prepareSeries();

        adapter = new SeriesAdapter(series);
        rv.setAdapter(adapter);
    }

    public void prepareSeries(){
        String TAG = "Mensaje";
        series = new ArrayList<>();
        series.add(new Serie("The Walking Dead", "13", R.drawable.wd, "TV show created by Robert Kirgman"));
        series.add(new Serie("Game of Thrones", "13", R.drawable.got, "TV show created by George R. Martin"));
        series.add(new Serie("Breaking bad", "13", R.drawable.bb, "TV show created by Vince Gilligan"));
    }
}
