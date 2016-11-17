package com.epicodus.businessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity {
    @Bind(R.id.productTitleView) TextView mProductTitleView;
    @Bind(R.id.productDescriptionView) TextView mProductDescriptionView;
    @Bind(R.id.productImageView)
    ImageView mProductImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        Integer image = intent.getIntExtra("image", 0);
        Integer position = intent.getIntExtra("position", 9);
        String description = intent.getStringExtra("description");

        mProductTitleView.setText(product);
        mProductDescriptionView.setText(description);
        mProductImageView.setImageResource(image);
    }
}
