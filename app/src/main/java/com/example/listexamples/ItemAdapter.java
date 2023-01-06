package com.example.listexamples;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_item, null);
            viewHolder = new ItemViewHolder();
            viewHolder.imageThumb = view.findViewById(R.id.image_thumb);
            viewHolder.textTitle = view.findViewById(R.id.text_title);
            viewHolder.checkSelected = view.findViewById(R.id.check_selected);
            view.setTag(viewHolder);
        } else
            viewHolder = (ItemViewHolder) view.getTag();

        ItemModel item = items.get(i);

        viewHolder.imageThumb.setImageResource(item.getImageResource());
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.checkSelected.setChecked(item.isSelected());

        viewHolder.checkSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.setSelected(!item.isSelected());
                notifyDataSetChanged();
            }
        });

        return view;
    }

    static class ItemViewHolder {
        ImageView imageThumb;
        TextView textTitle;
        CheckBox checkSelected;
    }
}
