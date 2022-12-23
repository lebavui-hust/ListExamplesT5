package com.example.listexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HorizontalListActivity extends AppCompatActivity {

    List<ImageModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list);

        items = new ArrayList<>();
        for (int i = 1; i <= 28; i++)
            items.add(new ImageModel(
                    "Item " + i,
                    getResources().getIdentifier("thumb" + i, "drawable", getPackageName()),
                    getResources().getIdentifier("wall" + i, "drawable", getPackageName())
            ));

        LinearLayout layoutItems = findViewById(R.id.layout_items);
        ImageView imageWall = findViewById(R.id.image_wall);

        for (int i = 0; i < items.size(); i++) {
            View itemView = LayoutInflater.from(this).inflate(R.layout.layout_image_item, null);
            itemView.setId(i);

            ImageView imageThumb = itemView.findViewById(R.id.image_thumb);
            TextView textCaption = itemView.findViewById(R.id.text_caption);

            imageThumb.setImageResource(items.get(i).getThumbResource());
            textCaption.setText(items.get(i).getCaption());

            layoutItems.addView(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = view.getId();
                    imageWall.setImageResource(items.get(index).getWallResource());
                }
            });
        }
    }
}