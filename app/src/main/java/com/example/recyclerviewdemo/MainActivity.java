package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView footballersRecyclerView;

    public static final Footballer[] dummyFootballers = {
            new Footballer("Gareth Bale", "#11 - Winger", R.drawable.bale),
            new Footballer("Karim Benzema", "#9 - Striker", R.drawable.benzema),
            new Footballer("Cristiano Ronaldo", "#7 - Winger", "SIUUUUUUU!", R.drawable.cristiano),
            new Footballer("James Rodriguez", "#10 - Attack Midfielder", R.drawable.james),
            new Footballer("Toni Kroos", "#8 - Centre Midfielder", R.drawable.kroos),
            new Footballer("Luka Modric", "#19 - Centre Midfielder", R.drawable.modric),
            new Footballer("Sergio Ramos", "#4 - Centre Back", R.drawable.ramos)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupFootballersRecyclerView();
    }

    private void setupFootballersRecyclerView() {
        footballersRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        FootballerAdapter adapter = new FootballerAdapter(
                new ArrayList<>(Arrays.asList(dummyFootballers))
        );
        footballersRecyclerView.setAdapter(adapter);
    }

    private void findViews() {
        footballersRecyclerView = findViewById(R.id.playersRecyclerView);
    }
}