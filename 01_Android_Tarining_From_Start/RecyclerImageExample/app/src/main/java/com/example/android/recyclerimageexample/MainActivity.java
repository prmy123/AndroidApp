package com.example.android.recyclerimageexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private int[] images = {R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,
           R.drawable.pic5};

   private RecyclerView.LayoutManager layoutManager;

   private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(images,this);
        recyclerView.setAdapter(adapter);
    }
}
