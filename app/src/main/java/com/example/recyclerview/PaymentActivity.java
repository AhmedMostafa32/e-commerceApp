package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recyclerview.databinding.ActivityPaymentBinding;

public class PaymentActivity extends AppCompatActivity {
    ActivityPaymentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        double totalCost = getIntent().getDoubleExtra("totalCost", 0.0);
//        Intent intent = getIntent();
//        if (intent != null) {
//            int imageResourceId = intent.getIntExtra("picture", 0);
//            String txtname = intent.getStringExtra("name");
//            String txtDesc=intent.getStringExtra("describtion");
//            String price= String.valueOf(intent.getIntExtra("price",0));
//            //----------------------------------------------------------------------------
//            int imageResourceId2 =intent.getIntExtra("picture",0);
//            String txtname2 =intent.getStringExtra("name");
//            String txtDesc2=intent.getStringExtra("describtion");
//            String price2=String.valueOf(intent.getIntExtra("price",0));
//            //-----------------------------------------------------------------------------
//            int imageResourceId3 =intent.getIntExtra("picture",0);
//            String txtname3 =intent.getStringExtra("name");
//            String txtDesc3=intent.getStringExtra("describtion");
//            String price3=String.valueOf(intent.getIntExtra("price",0));
//            //-----------------------------------------------------------------------------
//            int imageResourceId4 =intent.getIntExtra("picture",0);
//            String txtname4 =intent.getStringExtra("name");
//            String txtDesc4=intent.getStringExtra("describtion");
//            String price4=String.valueOf(intent.getIntExtra("price",0));

            // Set the image resource to the ImageView

        binding.mastercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Assuming R.drawable.mastercard is the resource ID for your MasterCard image
                int masterCardImageResource = R.drawable.oo;
                binding.repimg.setImageResource(masterCardImageResource);
            }
        });
        binding.apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int apple =R.drawable.aa;
                binding.repimg.setImageResource(apple);
            }
        });
        binding.paybal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int paybal=R.drawable.pp;
                binding.repimg.setImageResource(paybal);
            }
        });
        //-----------------------------------------------------------------------------------------------
binding.price.setText("$" +String.format("%.2f", totalCost));
//--------------------------------------------------------------------------------------------------------
binding.confirm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Intent intent=new Intent(PaymentActivity.this,PaymentSuccess.class);
startActivity(intent);
    }
});


    }
}
