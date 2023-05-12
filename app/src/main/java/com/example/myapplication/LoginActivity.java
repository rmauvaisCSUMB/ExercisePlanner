package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.AppDataBase;
import com.example.myapplication.DB.GymExerciseDAO;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;

    private Button mButton;

    private GymExerciseDAO mGymLogDAO;

    private String mUsernameString;
    private String mPasswordString;

    private User mUser;
    private String mAdminStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getDataBase();

        wireupDisplay();

    }


    private void wireupDisplay(){
        mUsername = findViewById(R.id.editTextTextUsername);
        mPassword = findViewById(R.id.editTextPassword);

        mButton = findViewById(R.id.user_login);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValuesFromDisplay();
                if (checkForUserInDatabase()){
                    if (!validatePassword()){
                        Toast.makeText(LoginActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    } else {

                        Intent intent = landingPage.intentFactory(getApplicationContext(), mUser.getUserId(), mAdminStats);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validatePassword(){
        return mUser.getPassword().equals(mPasswordString);
    }

    private void getValuesFromDisplay(){
        mUsernameString = mUsername.getText().toString();
        mPasswordString = mPassword.getText().toString();
    }

    private boolean checkForUserInDatabase(){
        mUser = mGymLogDAO.getUserByUserName(mUsernameString);
        if (mUser == null){
            Toast.makeText(this, "no user " + mUsernameString + " found", Toast.LENGTH_SHORT).show();
            return false;
        }
        mAdminStats = mUser.isAdmin() + "";
        return true;
    }

    private void getDataBase(){
        mGymLogDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .GymLogDAO();
        if (mGymLogDAO.getAllUsers().size() <= 0) {
            User admin2 = new User("admin2", "admin2", true);
            mGymLogDAO.insert(admin2);
            User testUser1 = new User("testUser1", "testUser1", false);
            mGymLogDAO.insert(testUser1);
        }
    }

    public static Intent intentFactory(Context context, int userId){
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("user_id", userId);
        return intent;
    }

}