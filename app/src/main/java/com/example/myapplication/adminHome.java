package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.DB.AppDataBase;
import com.example.myapplication.DB.GymExerciseDAO;

public class adminHome extends AppCompatActivity {


    private GymExerciseDAO mGymLogDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        Button mDeleteUser = findViewById(R.id.buttonDeleteUser);

        mDeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGymLogDAO.delete();
                Toast.makeText(adminHome.this, "USER DELETED", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getDataBase(){
        mGymLogDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .GymLogDAO();
    }

    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, adminHome.class);
        return intent;
    }
}