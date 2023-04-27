package com.example.myapplication.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.User;

import java.util.List;

@Dao
public interface GymExerciseDAO {

//    @Insert
//    void insert(GymLog ... gymLogs);
//
//    @Update
//    void update(GymLog... gymLogs);
//
//    @Delete
//    void delete(GymLog... gymLogs);
//
//    @Query("SELECT * FROM " + AppDataBase.GYMLOG_TABLE + " ORDER BY mDate desc")
//    List<GymLog> getAllGymLogs();
//
//    @Query("SELECT * FROM " + AppDataBase.GYMLOG_TABLE + " WHERE mLogId = :logId")
//    List<GymLog> getLogById(int logId);

   // @Query("SELECT * FROM " + AppDataBase.GYMLOG_TABLE + " WHERE mUserId = :userId ORDER BY mDate DESC")
   // List<GymLog> getGymLogsByUserId(int userId);

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User... user);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUsername = :username")
    User getUserByUserName(String username);

    @Query("SELECT * FROM " + AppDataBase.USER_TABLE + " WHERE mUserId = :userId")
    User getUserByUserId(int userId);

}
