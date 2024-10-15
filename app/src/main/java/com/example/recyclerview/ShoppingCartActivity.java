package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerview.databinding.ActivityShoppingCartBinding;

import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {
    private ActivityShoppingCartBinding binding;
    private CartAdapter cartAdapter; // Declare the CartAdapter variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        List<Item_model> cartItems = ShoppingCart.getCartItems();

        // Display the items in your RecyclerView
        binding.cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(this, cartItems); // Initialize the CartAdapter
        binding.cartRecyclerView.setAdapter(cartAdapter);

        // Calculate and display the total cost (optional)
        double totalCost = calculateTotalCost(cartItems);
//        Toast.makeText(this, "Total Cost: $" + totalCost, Toast.LENGTH_SHORT).show();
//        binding.textTotalCost.setText("Total Cost: $" + String.format("%.2f", totalCost));
        //---------------------------------------------------------------------------------------------
        binding.confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ShoppingCartActivity.this,PaymentActivity.class);
                intent.putExtra("totalCost", totalCost);
                startActivity(intent);

            }
        });
    }


    private double calculateTotalCost(List<Item_model> items) {
        double totalCost = 0;
        for (Item_model item : items) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
