package com.example.recyclerview;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ItemViewBinding;
import com.example.recyclerview.MyViewHolder;

import java.util.List;

public class Adapter4 extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item_model> items;

    public Adapter4(Context context, List<Item_model> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(items.get(position)); // Corrected to bind4 method for Item_model4
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                // Use the context from the item view to start the new activity
//                Intent intent = new Intent(holder.itemView.getContext(), PaymentActivity.class);
//
//                // Assuming Item_model4 has fields like imageResourceId, name, describe, price
//                int imageResourceId4 = items.get(position).getImg();
//                String txtname4 = items.get(position).getName();
//                String txtdesc4 = items.get(position).getDescribe();
//                int pro_price4 = items.get(position).getPrice();
//
//                // Put the item details as extras
//                intent.putExtra("picture", imageResourceId4);
//                intent.putExtra("name", txtname4);
//                intent.putExtra("describtion", txtdesc4);
//                intent.putExtra("price", pro_price4);
//
//                // Add the FLAG_ACTIVITY_NEW_TASK flag
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//                // Start the new activity
//                holder.itemView.getContext().startActivity(intent);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Retrieve the clicked item
                        Item_model clickedItem = items.get(position);

                        // Add the clicked item to the shopping cart
                        ShoppingCart.addToCart(clickedItem);

                        // Notify the user that the item has been added to the cart (optional)
                        Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}