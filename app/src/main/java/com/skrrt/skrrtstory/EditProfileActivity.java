package com.skrrt.skrrtstory;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class EditProfileActivity extends AppCompatActivity {

    Button simpan;
    EditText edtxt_name, edtxt_city, edtxt_country, edtxt_quote;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        edtxt_name = (EditText) findViewById(R.id.edit_name);
        edtxt_city = (EditText) findViewById(R.id.edit_city);
        edtxt_country = (EditText) findViewById(R.id.edit_country);
        edtxt_quote = (EditText) findViewById(R.id.edit_quote);
        simpan = (Button)findViewById(R.id.btn_simpan);



        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences("SaveData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NameValue", edtxt_name.getText().toString());
                editor.apply();

                editor.putString("CityValue", edtxt_city.getText().toString());
                editor.apply();

                editor.putString("CountryValue", edtxt_country.getText().toString());
                editor.apply();

                editor.putString("QuoteValue", edtxt_quote.getText().toString());
                editor.apply();




                Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
                Intent intent1 = new Intent(EditProfileActivity.this,ProfileActivity.class);
                startActivity(intent1);
                finish();

            }
        });
    }
}
