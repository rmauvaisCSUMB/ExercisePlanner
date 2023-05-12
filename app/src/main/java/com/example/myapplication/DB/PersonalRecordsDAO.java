package com.example.myapplication.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.PRs;

import java.util.List;

@Dao
public interface PersonalRecordsDAO {

    @Insert
    void insert(PRs... pRs);

    @Update
    void update(PRs... pRs);

    @Delete
    void delete(PRs... pRs);

    @Query("SELECT * FROM " + AppDataBase.PERSONAL_RECORDS + " WHERE user_id= :userId ORDER BY mDate DESC")
    List<PRs> getAllPRs(int userId);
}

