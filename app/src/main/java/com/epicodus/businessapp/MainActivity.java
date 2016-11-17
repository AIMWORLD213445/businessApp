package com.epicodus.businessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.productList) ListView mProductView;
    private String[] products = new String[] {"Guatemala Finca El Injerto Pena Blanca Gesha--$75",
            "Guatemala Finca El Injerto - Bourbon--$19", "African Trio--$40", "Masala Chai--$12",
            "Diner Mug--$12", "Blazer's Blend--$16", "Ethiopia Duromina--$18" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, products);
        mProductView.setAdapter(adapter);

        mProductView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>adapterView, View view, int position, long l) {
            Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                String product = (String) mProductView.getItemAtPosition(position);
                intent.putExtra("position", position);
                intent.putExtra("product", product);
                startActivity(intent);
            }
        });
    };
}
