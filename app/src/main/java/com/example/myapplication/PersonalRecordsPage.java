package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.DB.AppDataBase;
import com.example.myapplication.DB.GymExerciseDAO;
import com.example.myapplication.DB.PersonalRecordsDAO;
import com.example.myapplication.databinding.ActivityPersonalRecordsPageBinding;

import java.util.List;

public class PersonalRecordsPage extends AppCompatActivity {

    private static final String USER_ID_KEY = "com.example.myapplication.userIdKey";
    ActivityPersonalRecordsPageBinding binding;
    private TextView mPRview;
    private EditText mMovement;
    private EditText mWeight;
    private Button mSubmit;

    private PersonalRecordsDAO mPersonalRecordsDAO;

    private List<PRs> mPRsList;

    private int mUserId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_records_page);

        getDatabase();

        checkForUser();

        binding = ActivityPersonalRecordsPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mPRview = binding.personalRecordView;
        mMovement = binding.editTextMovementPR;
        mWeight = binding.editTextWeight;
        mSubmit = binding.submitButtonPR;

        mPRview.setMovementMethod(new ScrollingMovementMethod());

        refreshDisplay();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitPR();
                refreshDisplay();
            }
        });
    }

    private void getDatabase() {
        mPersonalRecordsDAO = Room.databaseBuilder(this, AppDataBase.class, AppDataBase.PERSONAL_RECORDS)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .mPersonalRecordsDAO();
    }

    private void checkForUser() {
        mUserId = getIntent().getIntExtra(USER_ID_KEY, 0);

        if (mUserId != -1) {
            return;
        }

    }

    private void submitPR() {
        String movement = mMovement.getText().toString();
        double weight = Double.parseDouble(mWeight.getText().toString());

        PRs pr = new PRs(mUserId, movement, weight);

        mPersonalRecordsDAO.insert(pr);
    }


    public static Intent intentFactory(Context context){
        Intent intent = new Intent(context, PersonalRecordsPage.class);
        return intent;
    }

    private void refreshDisplay() {
        mPRsList = mPersonalRecordsDAO.getAllPRs(mUserId);
        if(! mPRsList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (PRs pr : mPRsList) {
                sb.append(pr.toString());
            }
            mPRview.setText(sb.toString());
        } else {
            mPRview.setText(R.string.hitPR);
        }
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