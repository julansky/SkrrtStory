package com.skrrt.skrrtstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordActivity extends AppCompatActivity {

    Button mButtonLogin;
    TextView mTextRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mButtonLogin  = (Button) findViewById(R.id.btn_login);
        mTextRegister = (TextView) findViewById(R.id.txtview_register);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(PasswordActivity.this, HomeActivity.class);
                startActivity(homeIntent);

            }
        });
        mTextRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(PasswordActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });


    }
}
