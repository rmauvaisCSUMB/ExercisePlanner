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

public class SignUpActivity extends AppCompatActivity {


    private GymExerciseDAO mGymLogDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button mHomePage = findViewById(R.id.homePage);

        getDataBase();

        mHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void getDataBase(){
        mGymLogDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .GymLogDAO();
        if (mGymLogDAO.getAllUsers().size() <= 0) {
            User admin2 = new User("", "", false);
            mGymLogDAO.insert(admin2);
        }
        User testUser1 = new User("testUser1", "testUser1", false);
        mGymLogDAO.insert(testUser1);
    }


    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }
}