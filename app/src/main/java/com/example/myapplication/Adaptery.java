package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;


import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<ResturantModelClass> mData;

   public Adaptery(Context mContext, List<ResturantModelClass> mData) {
       this.mContext = mContext;
       this.mData = mData;
   }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.resturant_items, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mData.get(position).getName());
        holder.description.setText(mData.get(position).getDescription()); //using Glide library to display the image

        Glide.with(mContext)
                .load(mData.get(position).getImg())
                .into(holder.img); //at 18:51
    }

    @Override
    public int getItemCount() {
       return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

       TextView name;
       TextView description;
       ImageView img; //might not need to change json

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.id_txt);
            description = itemView.findViewById(R.id.name_txt);
            img = itemView.findViewById(R.id.imageView);
        }
    }
}
