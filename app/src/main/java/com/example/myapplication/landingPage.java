package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        if (value.equals("true")) {
            mAdminButton.setVisibility(View.VISIBLE);
        } else {
            mAdminButton.setVisibility(View.INVISIBLE);
        }

    }




    public static Intent intentFactory(Context context, int userId, String admin){
        Intent intent = new Intent(context, landingPage.class);
        intent.putExtra(adminCheck ,admin);
        intent.putExtra("user_id", userId);
        return intent;
    }

}