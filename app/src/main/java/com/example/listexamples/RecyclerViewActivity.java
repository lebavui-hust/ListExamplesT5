package com.example.listexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity implements ItemClickListener {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        items = new ArrayList<>();
        for (int i = 1; i <= 28; i++)
            items.add(new ItemModel(
                    getResources().getIdentifier("thumb" + i, "drawable", getPackageName()),
                    "Title " + i
            ));

        ItemAdapter2 adapter = new ItemAdapter2(items, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnItemClick(int pos) {
        Log.v("TAG", items.get(pos).getTitle() + " is clicked.");
    }
}