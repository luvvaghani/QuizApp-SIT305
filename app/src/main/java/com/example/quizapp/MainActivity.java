package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button submitButton;
    EditText editTextName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);
        editTextName = findViewById(R.id.editText);

        Intent intentnew = getIntent();
        String name = intentnew.getStringExtra("Name");
        editTextName.setText(name);


    }

    public void onClickSubmit(View view) {

        name = editTextName.getText().toString();
        if (!(name.equals(""))) {
            System.out.println(name);

            int flag = getIntent().getIntExtra("Flag", 0);
            if (flag == 1) {
                name = getIntent().getStringExtra("Name");
                editTextName.setEnabled(false);
                editTextName.setHint(name);
            } else {
                name = editTextName.getText().toString();
            }
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("Name", name);
            startActivity(intent);
        }
        else Toast.makeText(MainActivity.this, "Enter your name", Toast.LENGTH_SHORT).show();
    }
}
