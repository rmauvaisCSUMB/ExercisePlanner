package com.example.myapplication.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.Plans;

import java.util.List;

@Dao
public interface WorkoutPlans {

    @Insert
    void insert(Plans... plans);

    @Update
    void update(Plans... plans);

    @Delete
    void delete(Plans... plans);

    @Query("SELECT * FROM " + AppDataBase.WORKOUT_PLANS)
    List<Plans> getAllPlans();

//    @Query("SELECT * FROM " + AppDataBase.WORKOUT_PLANS + " WHERE mTitle = :Title")
//    Plans getPlans(String Title);

}
