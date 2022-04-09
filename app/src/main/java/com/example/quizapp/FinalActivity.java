package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    Button takenewQuizButton, finish;
    TextView score, nameText;
    String name;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        takenewQuizButton = findViewById(R.id.takeNewQuizButton);
        finish = findViewById(R.id.finishButton);
        score = findViewById(R.id.mscore);
        nameText = findViewById(R.id.tetViewFinalResult);

        name = getIntent().getStringExtra("Name");
        System.out.println("Name = " + name);
        nameText.setText("Congratulations " + name);
        score.setText(getIntent().getIntExtra(("Score"), 0) + "/" + "5");

        finish.setOnClickListener(view -> {
            finishAffinity();
        });

        takenewQuizButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("Flag",1);
            intent.putExtra("Name", name);
            startActivity(intent);
        });
    }
}
