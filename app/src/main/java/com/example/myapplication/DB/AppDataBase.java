package com.example.myapplication.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.myapplication.User;

@Database(entities = {User.class}, version = 2)
@TypeConverters({DateTypeConverter.class})

public abstract class AppDataBase extends RoomDatabase {

    public static final String DATABASE_NAME = "GymLog.db";
    public static final String WORKOUT_PLANS = "WORKOUT_PLANS";
    public static final String USER_TABLE = "USER_TABLE";

    private static volatile AppDataBase instance;
    private static final Object LOCK = new Object();

    public abstract GymExerciseDAO GymLogDAO();
    public abstract WorkoutPlans WorkoutPlanDAO();

    public static AppDataBase getInstance(Context context) {
        if(instance == null) {
            synchronized (LOCK){
                if (instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }


}