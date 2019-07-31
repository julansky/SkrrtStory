package com.skrrt.skrrtstory.callbacks;

import com.skrrt.skrrtstory.model.Diary;

public interface DiaryEventListener {



    void onDiaryClick(Diary diary);

    void onDiaryLongClick(Diary diary);
}
