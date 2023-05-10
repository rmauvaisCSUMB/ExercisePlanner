package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication.DB.AppDataBase;

@Entity(tableName = AppDataBase.WORKOUT_PLANS)
public class Plans {

    @PrimaryKey(autoGenerate = true)
    private String mTitle;
    private String mAreaOfBody;
    private int mDuration;

    public Plans(String Title, String AreaOfBody, int Duration){
        mTitle = Title;
        mAreaOfBody = AreaOfBody;
        mDuration = Duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAreaOfBody() {
        return mAreaOfBody;
    }

    public void setAreaOfBody(String areaOfBody) {
        mAreaOfBody = areaOfBody;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }


}
