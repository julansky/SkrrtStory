package com.skrrt.skrrtstory.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.skrrt.skrrtstory.model.Diary;

@Database(entities = Diary.class, version = 1)
public abstract class DiarysDB extends RoomDatabase {

    public abstract DiarysDao diarysDao();

    public static final String DATABASE_NAME = "diarysDb";
    private static DiarysDB instance;

    public static DiarysDB getInstance(Context context){
        if (instance==null)
            instance = Room.databaseBuilder(context, DiarysDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
