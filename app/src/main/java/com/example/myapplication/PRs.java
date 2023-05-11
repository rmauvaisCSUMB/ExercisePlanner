package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.myapplication.DB.AppDataBase;

import java.util.Date;

@Entity(tableName = AppDataBase.PERSONAL_RECORDS)
public class PRs {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "user_id")
    private int userId;

    @ColumnInfo(name = "movement")
    private String movement;

    @ColumnInfo(name = "weight")
    private double weight;

    private Date mDate;

    public PRs(int userId, String movement, double weight) {
        this.userId = userId;
        this.movement = movement;
        this.weight = weight;
        mDate = new Date();
    }

    @Override
    public String toString() {
        return "Personal Record # " + id + "\n" +
                "User: " + userId + "\n" +
                "Movement: " + movement + "\n" +
                "Weight: " + weight + "\n" +
                "Date: " + mDate + "\n" +
                "=-=-=-=-=-\n";
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
