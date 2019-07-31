package com.skrrt.skrrtstory;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.skrrt.skrrtstory.adapters.DiarysAdapter;
import com.skrrt.skrrtstory.callbacks.DiaryEventListener;
import com.skrrt.skrrtstory.db.DiarysDB;
import com.skrrt.skrrtstory.db.DiarysDao;
import com.skrrt.skrrtstory.model.Diary;
import com.skrrt.skrrtstory.utils.DiaryUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.skrrt.skrrtstory.EditDiaryActivity.DIARY_EXTRA_Key;

public class MainActivity extends AppCompatActivity implements DiaryEventListener {
    public static final String APP_PREFERENCES = "diary_setting";
    public static final String THEME_Key = "app_theme";
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private ArrayList<Diary> diarys;
    private DiarysAdapter adapter;
    private DiarysDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //init recycleView
        recyclerView = findViewById(R.id.diars_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //init fab button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 28/07/2019 add new diary
                onAddNewDiary();
            }
        });

        dao = DiarysDB.getInstance(this).diarysDao();
    }

    private void loadDiarys() {
        this.diarys = new ArrayList<>();
        List<Diary> list = dao.getDiarys(); //mengambil semua diary dari database
        this.diarys.addAll(list);
        this.adapter = new DiarysAdapter(this, this.diarys);
        //set listerner to adpater
        this.adapter.setListener(this);
        this.recyclerView.setAdapter(adapter);
    }



    private void onAddNewDiary() {
        // TODO: 28/07/2019 memulai EditDiaryActivity
        startActivity(new Intent(this,EditDiaryActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDiarys();
    }

    @Override
    public void onDiaryClick(Diary diary) {
        // TODO: 29/07/2019 diary clicked : edit diary

        Intent edit = new Intent(this, EditDiaryActivity.class);
        edit.putExtra(DIARY_EXTRA_Key,diary.getId());
        startActivity(edit);


    }

    @Override
    public void onDiaryLongClick(final Diary diary) {
        // TODO: 29/07/2019 diary long clicked : hapus dan share
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 29/07/2019 hapus diary dari database
                        dao.deleteDiary(diary);
                        loadDiarys();

                    }
                })
                .setNegativeButton("Share", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: 29/07/2019 share diary
                        Intent share = new Intent(Intent.ACTION_SEND);
                        String text = diary.getDiaryText()+"\n Create on :"+
                                DiaryUtils.dateFromLong(diary.getDiaryDate())+"By :"+getString(R.string.app_name);

                        share.setType("text/plain");
                        share.putExtra(Intent.EXTRA_TEXT, text);
                        startActivity(share);


                    }
                })
                .create()
                .show();




    }
}
