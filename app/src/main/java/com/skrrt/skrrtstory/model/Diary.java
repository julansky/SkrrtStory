package com.skrrt.skrrtstory.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "diarys")
public class Diary {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "text")
    private String diaryText;
    @ColumnInfo(name = "date")
    private long diaryDate;

    public Diary() {
    }

    public Diary(String diaryText, long diaryDate) {
        this.diaryText = diaryText;
        this.diaryDate = diaryDate;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryText;
    }

    public long getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(long diaryDate) {
        this.diaryDate = diaryDate;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", diaryDate=" + diaryDate +
                '}';
    }
}
