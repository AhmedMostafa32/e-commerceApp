package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ItemViewBinding;
import com.example.recyclerview.databinding.ShoppingcartBinding;

public class MyViewHolder2 extends RecyclerView.ViewHolder{
    ShoppingcartBinding binding;
    public MyViewHolder2(ShoppingcartBinding binding) {
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
