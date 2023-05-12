package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GymPlan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym_plan);

        Button mPushDayButton = findViewById(R.id.pushDayButton);
        mPushDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GymPlan.this);

                builder.setMessage("EACH SET WILL BE 4 SETS EACH, 1ST SET 10-12 REPS THE REST OF THE SETS 6-8 AND LAST SET IS TO FAILURE" + "\n" +
                        "===---===---CHEST---===---===" + "\n" +
                        "~ Chest Flies w/ pec deck or cables" + "\n" +
                        "~ Incline Dumbbell Bench" + "\n" +
                        "~ Decline Cables" + "\n" +
                        "===---===---SHOULDERS---===---===" + "\n" +
                        "~ Dumbbell Shoulder Press" + "\n" +
                        "~ Side Lateral Raise w/ cables or dumbbells" + "\n" +
                        "~ Rear Delts w/ cables" + "\n" +
                        "===---===---TRICEPS---===---===" + "\n" +
                        "~ Cross Cable Dual Extension" + "\n" +
                        "~ SkullCrushers w/ EZ bar" + "\n" +
                        "~ Overhead Cable Extension");
                builder.setPositiveButton("Push Day", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button mPullDayButton = findViewById(R.id.pullDayButton);
        mPullDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GymPlan.this);

                builder.setMessage("");
                builder.setNegativeButton("Pull Day", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button mLegDayButton = findViewById(R.id.legDayButton);
        mLegDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GymPlan.this);

                builder.setNegativeButton("Leg Day", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        Button mCoreDayButton = findViewById(R.id.coreDayButton);
        mCoreDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GymPlan.this);

                builder.setNegativeButton("Core Day", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

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