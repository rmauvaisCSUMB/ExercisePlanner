package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class landingPage extends AppCompatActivity {

    private Button mAdminButton;

    private String value;

    private static String adminCheck = "com.example.myapplication.adminCheck";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);
        mAdminButton = findViewById(R.id.adminTools);
        value = getIntent().getStringExtra(adminCheck);
            if(value != null && value.equalsIgnoreCase("true")) {
                mAdminButton.setVisibility(View.VISIBLE);
                mAdminButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(landingPage.this, adminHome.class);
                        startActivity(intent);
                    }
                });
        } else {
            mAdminButton.setVisibility(View.INVISIBLE);
        }

        Button mPlansButton = findViewById(R.id.planButton);
        mPlansButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landingPage.this, GymPlan.class);
                startActivity(intent);
            }
        });

        Button mMenuButton = findViewById(R.id.newPersonalRecord);
        mMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(landingPage.this, PersonalRecordsPage.class);
                startActivity(intent);
            }
        });

    }

    public static Intent intentFactory(Context context, int userId, String admin){
        Intent intent = new Intent(context, landingPage.class);
        intent.putExtra(adminCheck ,admin);
        intent.putExtra("user_id", userId);
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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.item3) {
            Intent intent = new Intent(this, landingPage.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}