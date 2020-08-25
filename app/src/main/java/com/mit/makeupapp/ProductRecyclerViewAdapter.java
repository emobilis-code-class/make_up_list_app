package com.mit.makeupapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mit.makeupapp.data.Product;

import java.util.List;

public class ProductRecyclerViewAdapter extends RecyclerView.Adapter<ProductRecyclerViewAdapter.MyViewHolder> {
    List<Product> products;
    Context context;
    public ProductRecyclerViewAdapter(List<Product> images, Context context){
        this.products = images;
        this.context = context;

    }
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        alt + enter
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_view_item_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Product product = products.get(position);

        holder.name.setText(product.name);
        holder.brand.setText(product.brand);
        holder.price.setText(product.price+" "+product.price_sign);
        //this is we bind view with actual content
        Glide.with(context)
                .load(product.image_link)
                .into(holder.myImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView myImage;
        TextView name,brand,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myImage = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            brand = itemView.findViewById(R.id.brand);
            price = itemView.findViewById(R.id.price);

        }
    }
}