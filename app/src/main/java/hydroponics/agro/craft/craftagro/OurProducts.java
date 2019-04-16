package hydroponics.agro.craft.craftagro;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OurProducts extends AppCompatActivity
{
    List<ProductsAdapterList> productList;
    private ImageView img1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_products);

        img1 = (ImageView) findViewById(R.id.imagenewboyproductsshop);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent parBrahma = new Intent(OurProducts.this,Home.class);
                startActivity(parBrahma);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerproducts_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        productList = new ArrayList<>();

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.abouteight));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfive));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfour));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.abouttwo));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfour));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.abouteight));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfour));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfive));

        productList.add(
                new ProductsAdapterList(
                        1,
                        "BakChoy",
                        "Healthy food is good",
                        R.drawable.aboutfive));

        ProductsImageAdapterList adapter = new ProductsImageAdapterList(this, productList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewTouchListener(getApplicationContext(),
                recyclerView, new RecyclerViewClickListener()
        {
            @Override
            public void onClick(View view, final int position)
            {
                Toast.makeText(OurProducts.this,"Hello", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position)
            {
                //   Toast.makeText(getApplicationContext(), bookList.get(position).getTitle() + " is long pressed!",
                //          Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
