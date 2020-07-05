package com.example.glamworlddigitalservice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.glamworlddigitalservice.serviceList.ServiceList;
import com.squareup.picasso.Picasso;

public class NewActivity extends AppCompatActivity {

    int position;

    ServiceList serviceList;
    ImageView imageView;
    TextView name, price, details;


    String valueOfName, valueOfPrice, valueOfDetails, valueOfPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);



        imageView = findViewById(R.id.image_service);

        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        details = findViewById(R.id.details);

       valueOfName = getIntent().getExtras().getString("name");
       valueOfPrice = getIntent().getExtras().getString("price");
       valueOfDetails = getIntent().getExtras().getString("details");
        valueOfPhoto = getIntent().getExtras().getString("url");






       name.setText(valueOfName);
       price.setText(valueOfPrice);
       details.setText(valueOfDetails);
        Picasso.get().load(valueOfPhoto).fit().centerCrop().into(imageView);








    }
}