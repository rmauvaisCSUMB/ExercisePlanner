package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication.DB.AppDataBase;

@Entity(tableName = AppDataBase.PERSONAL_RECORDS)
public class PRs {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "movement")
    private String movement;

    @ColumnInfo(name = "date")
    private String mDate;

    public PRs(int userId, String movement, String mDate) {
        this.userId = userId;
        this.movement = movement;
        this.mDate = mDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }
}
