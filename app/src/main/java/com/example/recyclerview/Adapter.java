package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.recyclerview.MyViewHolder;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.databinding.ItemViewBinding;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    List<Item_model> items;

    public Adapter(Context context, List<Item_model> items) {
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(items.get(position));

  holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
//
                // Use the context from the item view to start the new activity
//                Intent intent = new Intent(holder.itemView.getContext(), PaymentActivity.class);
//
//                // Assuming Item_model has a field called imageResourceId
//                int imageResourceId = items.get(position).getImg();
//                String txtname = items.get(position).getName();
//                String txtdesc=items.get(position).getDescribe();
//                int pro_price=items.get(position).getPrice();
//
//                // Put the image resource ID as an extra
//                intent.putExtra("picture", imageResourceId);
//                intent.putExtra("name",txtname);
//                intent.putExtra("describtion",txtdesc);
//                intent.putExtra("price",pro_price);

                // Add the FLAG_ACTIVITY_NEW_TASK flag
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

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

                // Start the new activity
//     holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
