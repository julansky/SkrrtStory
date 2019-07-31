package com.skrrt.skrrtstory;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toolbar;

import com.skrrt.skrrtstory.db.DiarysDB;
import com.skrrt.skrrtstory.db.DiarysDao;
import com.skrrt.skrrtstory.model.Diary;

import java.util.Date;

public class EditDiaryActivity extends AppCompatActivity {
    private EditText inputDiary;
    private DiarysDao dao;
    private Diary temp;
    public static final String DIARY_EXTRA_Key = "diary_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.APP_PREFERENCES, Context.MODE_PRIVATE);
        int theme = sharedPreferences.getInt(MainActivity.THEME_Key, R.style.AppTheme);
        setTheme(theme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);

        inputDiary = findViewById(R.id.input_diary);
        dao = DiarysDB.getInstance(this).diarysDao();

        if (getIntent().getExtras()!=null){
            int id = getIntent().getExtras().getInt(DIARY_EXTRA_Key,0);
            temp = dao.getDiaryById(id);
            inputDiary.setText(temp.getDiaryText());
        } else inputDiary.setFocusable(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_diary_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.save_diary)
            onSaveDiary();
        return super.onOptionsItemSelected(item);
    }

    private void onSaveDiary() {
        // TODO: 28/07/2019 Save Diary
        String text = inputDiary.getText().toString();
        if (!text.isEmpty()){
            long date = new Date().getTime(); //mengambil sistem waktu terkini

            if (temp==null){
                temp = new Diary(text, date);
                dao.insertDiary(temp);
            }else{
                temp.setDiaryText(text);
                temp.setDiaryDate(date);
                dao.updateDiary(temp);
            }
            finish(); //kembali ke main activity
        }
    }
}
