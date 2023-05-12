package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.DB.AppDataBase;
import com.example.myapplication.DB.GymExerciseDAO;

public class SignUpActivity extends AppCompatActivity {


    private EditText editTextRegisterUser;
    private EditText passwordRegister1;
    private EditText passwordRegister2;

    private GymExerciseDAO mGymLogDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button mHomePage = findViewById(R.id.homePage);
        editTextRegisterUser = findViewById(R.id.editTextUserNameSignUp);
        passwordRegister1 = findViewById(R.id.editTextPasswordSignUp1);
        passwordRegister2 = findViewById(R.id.editTextPasswordSignUp2);

        getDataBase();

        Button signUpButton = findViewById(R.id.signUpNow);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextRegisterUser.getText().toString().trim();
                String passWord1 = passwordRegister1.getText().toString().trim();
                String passWord2 = passwordRegister2.getText().toString().trim();

                registerUser(userName, passWord1, passWord2);
            }
        });

        mHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void registerUser(String user, String pass1, String pass2) {
        if (pass1.equals(pass2)) {
            User u = new User(user, pass1, false);
            mGymLogDAO.insert(u);
            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Passwords Don't Match!", Toast.LENGTH_SHORT).show();
        }
    }

    private void getDataBase(){
        mGymLogDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .GymLogDAO();
    }


    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }
}