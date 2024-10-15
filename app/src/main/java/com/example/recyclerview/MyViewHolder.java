package com.example.recyclerview;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ItemViewBinding;

public class MyViewHolder extends RecyclerView.ViewHolder  {
    ItemViewBinding binding;
    public MyViewHolder(ItemViewBinding binding) {
        super(binding.getRoot());
        this.binding=binding;

    }
    public void bind(Item_model itemModel){
        binding.ProductName.setText(itemModel.getName());
        binding.priceProduct.setText(String.valueOf(itemModel.getPrice()));
        binding.productImage.setImageResource(itemModel.getImg());
        binding.productDescribe.setText(itemModel.getDescribe());
    }
}

