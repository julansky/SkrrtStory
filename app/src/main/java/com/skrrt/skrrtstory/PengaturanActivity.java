package com.skrrt.skrrtstory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PengaturanActivity extends AppCompatActivity {

    Button riwayat, agenda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        riwayat = (Button)findViewById(R.id.hapus_riwayat);
        agenda = (Button)findViewById(R.id.hapus_agenda);

        riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PengaturanActivity.this,"COMING SOON : )", Toast.LENGTH_SHORT).show();
            }
        });

        agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(PengaturanActivity.this,"COMING SOON : )", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
