package com.skrrt.skrrtstory;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button btn_profile, btn_diary, btn_kalender, btn_agenda, btn_pengaturan, btn_keluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_diary = (Button)findViewById(R.id.buttonDiary);
        btn_profile = (Button)findViewById(R.id.buttonProfile);
        btn_agenda = (Button)findViewById(R.id.buttonAgenda);
        btn_kalender = (Button)findViewById(R.id.buttonKalender);
        btn_pengaturan = (Button)findViewById(R.id.buttonPengaturan);
        btn_keluar = (Button)findViewById(R.id.buttonKeluar);

        btn_diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Diary Clicked", Toast.LENGTH_SHORT).show();
                Intent diaryIntent = new Intent(HomeActivity.this,MainActivity.class);
                startActivity(diaryIntent);
            }
        });

        btn_kalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePicerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");

            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Profile Clicked", Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(HomeActivity.this,ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        btn_agenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Agenda Clicked", Toast.LENGTH_SHORT).show();
                Intent agendaIntent = new Intent(HomeActivity.this,AgendaActivity.class);
                startActivity(agendaIntent);
            }
        });

        btn_pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Pengaturan Clicked", Toast.LENGTH_SHORT).show();
                Intent pengaturanIntent = new Intent(HomeActivity.this,PengaturanActivity.class);
                startActivity(pengaturanIntent);
            }
        });

        /*btn_keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(HomeActivity.this,"Keluar Clicked", Toast.LENGTH_SHORT).show();
                Intent keluarIntent = new Intent(HomeActivity.this,PasswordActivity.class);
                startActivity(keluarIntent);
            }
        });  */
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);


    }

    public void clickexit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
