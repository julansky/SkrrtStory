package com.skrrt.skrrtstory.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.skrrt.skrrtstory.model.Diary;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DiarysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDiary (Diary diary);

    @Delete
    void deleteDiary (Diary diary);

    @Update
    void updateDiary (Diary diary);

    @Query("SELECT * FROM diarys")
    List<Diary> getDiarys();

    @Query("SELECT * FROM diarys WHERE id = :diaryId")
    Diary getDiaryById(int diaryId);

    @Query("DELETE FROM diarys WHERE id = :diaryId")
    void deleteDiaryById(int diaryId);

}
