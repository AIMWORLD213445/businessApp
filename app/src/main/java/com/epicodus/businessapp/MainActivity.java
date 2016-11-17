package com.epicodus.businessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.productList) ListView mProductView;
    private ArrayList<String> products = new ArrayList<String>(Arrays.asList("Guatemala Finca El Injerto Pena Blanca Gesha--$75",
            "Guatemala Finca El Injerto - Bourbon--$19", "African Trio--$40", "Masala Chai--$12",
            "Diner Mug--$12", "Blazer's Blend--$16", "Ethiopia Duromina--$18"));

    private ArrayList<String> descriptions = new ArrayList<String>(Arrays.asList("The Gesha variety is perhaps the most well-known single coffee variety in the world, though it is one of the rarest, and certainly the most unusual. Gesha is an ancient Ethiopian heirloom but its future is unwritten– it requires a Herculean effort to grow it, demanding hard work and good luck in equal measure. We turn to the Aguirres for this – and the result: a pristine expression of variety, farm and process in one perfect, brilliant cup.",
            "We look to this beautiful coffee as a model of perfect balance. Both coffee newbies and nerds fall hard for this one – it’s a harmonious palate pleaser of chocolate and citrus, with a smooth mouthfeel.",
            "Each of these coffees are perennial showstoppers, and this year is no exception. They represent the best of Ethiopian coffees, and that's saying something.",
            "In India, chai is a sweetly spiced tea served with foamed milk. Bright and coppery in the cup, the second flush Indian Assam teas are the famous foundation of many breakfast blends.",
            "These heavy-weight ceramic mugs are the same style we use in our cafes. Designed for heavy drinking.",
            "Rip City. Stumptown. We bear the nicknames of our shining city and couldn't be prouder of it. Our production floor is hung with Blazers banners, and our trucks fly Blazers flags on game day. Blazermania is part of the Stumptown DNA and we're thrilled to collaborate with our hometown team on this blend roasted just for them.",
            "At first, this coffee tastes like biting into a sweet, juicy peach. The black tea finish provides a lovely, balanced structure."));
    Toolbar toolbarWidget;

    private ArrayList<Integer> images = new ArrayList<Integer>(Arrays.asList(R.drawable.gesha, R.drawable.fincabourbon, R.drawable.africantrio, R.drawable.tea, R.drawable.mug, R.drawable.blazers, R.drawable.ethiopia));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbarWidget = (Toolbar) findViewById(R.id.toolbar1);

        toolbarWidget.setTitle("Stumptown");
        toolbarWidget.setTitleTextColor(0xFFFFFFFF);

        toolbarWidget.setNavigationIcon(R.mipmap.horseshoe);

        setSupportActionBar(toolbarWidget);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, products);
        mProductView.setAdapter(adapter);

        mProductView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapterView, View view, int position, long l) {
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                String product = (String) mProductView.getItemAtPosition(position);
                intent.putExtra("position", position);
                intent.putExtra("product", product);
                intent.putExtra("description", descriptions.get(position));
                intent.putExtra("image", images.get(position));
                startActivity(intent);
            }
        });
    };
}
