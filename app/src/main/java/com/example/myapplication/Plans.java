package com.example.myapplication;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication.DB.AppDataBase;

@Entity(tableName = AppDataBase.WORKOUT_PLANS)
public class Plans {

    @PrimaryKey(autoGenerate = true)
    private int planId;

    private String mTitle;
    private String mAreaOfBody;
    private int mDuration;

    public Plans(String title, String areaOfBody, int duration) {
        mTitle = title;
        mAreaOfBody = areaOfBody;
        mDuration = duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
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
