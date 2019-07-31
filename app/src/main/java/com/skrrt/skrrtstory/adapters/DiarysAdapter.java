package com.skrrt.skrrtstory.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skrrt.skrrtstory.R;
import com.skrrt.skrrtstory.callbacks.DiaryEventListener;
import com.skrrt.skrrtstory.model.Diary;
import com.skrrt.skrrtstory.utils.DiaryUtils;

import java.util.ArrayList;

public class DiarysAdapter extends RecyclerView.Adapter<DiarysAdapter.DiaryHolder> {
    private Context context;
    private ArrayList<Diary> diarys;
    private DiaryEventListener listener;

    public DiarysAdapter(Context context, ArrayList<Diary> diarys) {
        this.context = context;
        this.diarys = diarys;
    }


    @Override
    public DiaryHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.diary_layout,viewGroup,false);
        return new DiaryHolder(v);
    }

    @Override
    public void onBindViewHolder(DiaryHolder diaryHolder, int i) {
        final Diary diary = getDiary(i);
        if (diary != null){
            diaryHolder.diaryText.setText(diary.getDiaryText());
            diaryHolder.diaryDate.setText(DiaryUtils.dateFromLong(diary.getDiaryDate()));

            diaryHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDiaryClick(diary);
                }
            });

            diaryHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onDiaryLongClick(diary);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return diarys.size();
    }

    private Diary getDiary(int position){
        return diarys.get(position);
    }

    class DiaryHolder extends RecyclerView.ViewHolder{
        TextView diaryText, diaryDate;
        public DiaryHolder(@NonNull View itemView) {
            super(itemView);
            diaryDate = itemView.findViewById(R.id.diary_date);
            diaryText = itemView.findViewById(R.id.diary_text);
        }
    }

    public void setListener(DiaryEventListener listener) {
        this.listener = listener;
    }


}
