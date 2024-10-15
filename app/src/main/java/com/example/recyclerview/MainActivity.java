package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.shoppingcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ShoppingCartActivity.class);
                startActivity(intent);
            }
        });
        List<Item_model> itemModels = new ArrayList<>();
        itemModels.add(new Item_model("Gem Glow", "High Waisted Shorts", R.drawable.cyan2, 100));
        itemModels.add(new Item_model("ZARA", "Strapless Corset Bustier Top", R.drawable.white, 200));
        itemModels.add(new Item_model("Shawl Collar", "Rounded Collar Blazer", R.drawable.cyan, 120));
        itemModels.add(new Item_model("Single-Breasted", "Clean Cut Blazer", R.drawable.babyblue, 150));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView.setAdapter(new Adapter(getApplicationContext(), itemModels));

// For the second RecyclerView
        List<Item_model> item_models2 = new ArrayList<>();
        item_models2.add(new Item_model("Crystal Cascade", "by Joe Waterman", R.drawable.blackjins, 50));
        item_models2.add(new Item_model("ZARA", "bLong Classical Blazer", R.drawable.clasic, 200));
        item_models2.add(new Item_model("Navy Blazer", "Long Cuts", R.drawable.pink, 150));
        item_models2.add(new Item_model("Zara", "Long Classical Blazer", R.drawable.formal, 175));
        binding.recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView2.setAdapter(new Adapter2(getApplicationContext(), item_models2));

// For the third RecyclerView
        List<Item_model> item_models3 = new ArrayList<>();
        item_models3.add(new Item_model("Lux Band", "Elegance wrapped handbag", R.drawable.bag, 50));
        item_models3.add(new Item_model("Prada", "Tiered Mini Dress", R.drawable.dress, 120));
        item_models3.add(new Item_model("ZARA", "black Long Cuts", R.drawable.blackhodie, 150));
        item_models3.add(new Item_model("ZARA", "Hijab Fashion", R.drawable.hejab, 80));
        binding.recyclerView3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView3.setAdapter(new Adapter3(getApplicationContext(), item_models3));

// For the fourth RecyclerView
        List<Item_model> item_models4 = new ArrayList<>();
        item_models4.add(new Item_model("Radiant Ring", "Shine like diamond", R.drawable.juice, 250));
        item_models4.add(new Item_model("Lamerei", "Reversible Angora Sweater", R.drawable.funny, 85));
        item_models4.add(new Item_model("Crystal Cascade", "by Joe Waterman", R.drawable.jacket, 490));
        item_models4.add(new Item_model("Gem Glow", "Long Shoes", R.drawable.shoes, 70));
        binding.recyclerView4.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.recyclerView4.setAdapter(new Adapter4(getApplicationContext(), item_models4));
    }
    public void onBackPressed() {
        // Add your custom behavior here
        Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}