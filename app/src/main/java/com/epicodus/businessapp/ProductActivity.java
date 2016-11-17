package com.epicodus.businessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity {
    @Bind(R.id.productTitleView) TextView mProductTitleView;
    @Bind(R.id.productDescriptionView) TextView mProductDescriptionView;

    private String[] descriptions = {
            "The Gesha variety is perhaps the most well-known single coffee variety in the world, though it is one of the rarest, and certainly the most unusual. Gesha is an ancient Ethiopian heirloom but its future is unwritten– it requires a Herculean effort to grow it, demanding hard work and good luck in equal measure. We turn to the Aguirres for this – and the result: a pristine expression of variety, farm and process in one perfect, brilliant cup.",
            "We look to this beautiful coffee as a model of perfect balance. Both coffee newbies and nerds fall hard for this one – it’s a harmonious palate pleaser of chocolate and citrus, with a smooth mouthfeel.",
            "Each of these coffees are perennial showstoppers, and this year is no exception. They represent the best of Ethiopian coffees, and that's saying something.",
            "In India, chai is a sweetly spiced tea served with foamed milk. Bright and coppery in the cup, the second flush Indian Assam teas are the famous foundation of many breakfast blends.",
            "These heavy-weight ceramic mugs are the same style we use in our cafes. Designed for heavy drinking.",
            "Rip City. Stumptown. We bear the nicknames of our shining city and couldn't be prouder of it. Our production floor is hung with Blazers banners, and our trucks fly Blazers flags on game day. Blazermania is part of the Stumptown DNA and we're thrilled to collaborate with our hometown team on this blend roasted just for them.",
            "At first, this coffee tastes like biting into a sweet, juicy peach. The black tea finish provides a lovely, balanced structure."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String product = intent.getStringExtra("product");
        Integer position = intent.getIntExtra("position", 9);

        mProductTitleView.setText(product);
        mProductDescriptionView.setText(descriptions[position]);
    }
}
