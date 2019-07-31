package com.skrrt.skrrtstory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    ImageView ImageBackHome;
    Button EditProfile;
    TextView name, city, country, quote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageBackHome = (ImageView) findViewById(R.id.backtohome);
        EditProfile = (Button) findViewById(R.id.editp);
        name = (TextView) findViewById(R.id.name);
        city = (TextView) findViewById(R.id.city);
        country = (TextView) findViewById(R.id.country);
        quote = (TextView) findViewById(R.id.quote);

        SharedPreferences result = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
        String name_value = result.getString("NameValue","Your Name");
        name.setText(name_value);

        String city_value = result.getString("CityValue","City");
        city.setText(city_value);

        String country_value = result.getString("CountryValue","Country");
        country.setText(country_value);

        String quote_value = result.getString("QuoteValue","This is your quote");
        quote.setText(quote_value);





        ImageBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent backHomeIntent = new Intent(ProfileActivity.this,HomeActivity.class);
                startActivity(backHomeIntent);
                finish();
            }
        });

        EditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent EditProfileIntent = new Intent(ProfileActivity.this,EditProfileActivity.class);
                startActivity(EditProfileIntent);
            }
        });
    }
}
