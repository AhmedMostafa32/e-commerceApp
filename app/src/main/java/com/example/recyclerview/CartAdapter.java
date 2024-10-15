package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ShoppingcartBinding;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<MyViewHolder2> {
    private Context context;
    private List<Item_model> cartItems;

    public CartAdapter(Context context, List<Item_model> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShoppingcartBinding binding = ShoppingcartBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder2(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        Item_model cartItem = cartItems.get(position);
        holder.bind(cartItem);

        holder.binding.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                    // Remove the item from the shopping cart
                    removeFromCart(cartItem);
                    // Notify the user that the item has been removed (optional)
                    Toast.makeText(context, "Item removed from cart", Toast.LENGTH_SHORT).show();
                    // Optionally, you can update the UI or navigate to another screen after removing
                    // For example, you can refresh the RecyclerView
                    notifyDataSetChanged();
                }
        });
    }

    // Method to remove an item from the shopping cart
    private void removeFromCart(Item_model item) {
        ShoppingCart.removeFromCart(item);
        cartItems.remove(item);
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }
}