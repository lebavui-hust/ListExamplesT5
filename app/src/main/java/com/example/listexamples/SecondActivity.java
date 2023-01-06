package com.example.listexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        items = new ArrayList<>();
        for (int i = 1; i <= 28; i++)
            items.add(new ItemModel(
                    getResources().getIdentifier("thumb" + i, "drawable", getPackageName()),
                    "Title " + i
            ));

        ItemAdapter adapter = new ItemAdapter(items);
        ListView listItems = findViewById(R.id.list_items);
        listItems.setAdapter(adapter);
    }
}