package com.example.pertemuan5mobile;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class GridFoodAdapter extends RecyclerView.Adapter<GridFoodAdapter.GridViewHolder> {
    private ArrayList<Food> listFood;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context mContext;

    // data is passed into the constructor
    GridFoodAdapter(Context context, ArrayList<Food> data) {
        this.mInflater = LayoutInflater.from(context);
        this.listFood = data;
        mContext = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    @NonNull
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_grid_food, parent, false);
        return new GridViewHolder(view);
    }
   // private OnItemClickCallback onItemClickCallback;
    @Override
    public void onBindViewHolder(@NonNull final GridFoodAdapter.GridViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(listFood.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //     onItemClickCallback.onItemClicked(listFood.get(holder.getAdapterPosition()));
                Intent intent = new Intent(mContext, DetailActivity.class);
                //intent.putExtra("image_url", listFood.get(position));
                intent.putExtra("index", position);
                mContext.startActivity(intent);
            }
        });
    }


    // total number of cells
    @Override
    public int getItemCount() {
        return listFood.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView imgName;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
//            int position = getAdapterPosition();
//            Intent intent = new Intent(mContext, DetailActivity.class);
//            intent.putExtra("index", position);
//            mContext.startActivity(intent);


        }
    }

    // convenience method for getting data at click position

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}