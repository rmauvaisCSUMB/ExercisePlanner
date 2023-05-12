package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.DB.AppDataBase;
import com.example.myapplication.DB.GymExerciseDAO;

import java.util.ArrayList;
import java.util.List;

public class deleteUser extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private userAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private GymExerciseDAO mGymExerciseDAO;

    List<User> users;
    ArrayList<UserItem> userList = new ArrayList<>();

    public void removeItem(int position) {
        String name = userList.get(position).getUserName();
        userList.remove(position);
        User u = mGymExerciseDAO.getUserByUserName(name);
        mGymExerciseDAO.delete(u);
        Toast.makeText(this, "USER DELETED", Toast.LENGTH_SHORT).show();
        mAdapter.notifyItemRemoved(position);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);

        getDataBase();
        List<User> users = mGymExerciseDAO.getAllUsers();
        for (User u : users) {
            userList.add(new UserItem(R.drawable.ic_android, u.getUserName()));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new userAdapter(userList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new userAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    private void getDataBase() {
            mGymExerciseDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                    .GymLogDAO();
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