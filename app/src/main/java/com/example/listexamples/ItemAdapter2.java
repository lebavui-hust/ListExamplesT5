package com.example.listexamples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<ItemModel> items;
    ItemClickListener listener;

    public ItemAdapter2(List<ItemModel> items, ItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, null);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.imageThumb.setImageResource(item.getImageResource());
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.checkSelected.setChecked(item.isSelected());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageThumb;
        TextView textTitle;
        CheckBox checkSelected;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageThumb = itemView.findViewById(R.id.image_thumb);
            textTitle = itemView.findViewById(R.id.text_title);
            checkSelected = itemView.findViewById(R.id.check_selected);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null)
                        listener.OnItemClick(position);
                }
            });
        }
    }
}
