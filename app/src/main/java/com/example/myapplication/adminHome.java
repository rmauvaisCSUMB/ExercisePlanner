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
                User userToDelete = new User("dug", "dug123", false);
                mGymLogDAO.delete(userToDelete);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.popup_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.item2) {
            Intent intent = new Intent(this, landingPage.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.item3) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}