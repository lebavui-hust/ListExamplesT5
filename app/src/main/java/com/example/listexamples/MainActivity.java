package com.example.listexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;

    String[] words = { "words", "starting", "with", "set", "Setback",
            "Setline", "Setoffs", "Setouts", "Setters", "Setting",
            "Settled", "Settler", "Wordless", "Wordiness", "Adios" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            items.add("Item " + i);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                items);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                R.layout.layout_simple_item,
//                R.id.text_view,
//                items
//        );

//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.v("TAG", items.get(i) + " is clicked.");
//            }
//        });

//        GridView gridView = findViewById(R.id.grid_view);
//        gridView.setAdapter(adapter);
//
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.v("TAG", items.get(i) + " is clicked.");
//            }
//        });

//        Spinner spinner = findViewById(R.id.spinner);
//        spinner.setAdapter(adapter);
//
//        spinner.setSelection(20);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Log.v("TAG", items.get(i) + " is selected");
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                words
        );

        AutoCompleteTextView editKeyword = findViewById(R.id.autoCompleteTextView);
        editKeyword.setAdapter(adapter);

        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.add(0, "New Item");
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.set(0, "Updated Item");
                adapter.notifyDataSetChanged();
            }
        });
    }
}