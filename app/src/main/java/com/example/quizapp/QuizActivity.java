package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity
{

    private final QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button nextButton;
    TextView textView;
    String name;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ProgressBar simpleProgressBar=(ProgressBar)findViewById(R.id.simpleProgressBar); // initiate the progress bar
        simpleProgressBar.setMax(100); // 100 maximum value for the progress value
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        textView = findViewById(R.id.textViewname);
        nextButton = (Button)findViewById(R.id.next);

        name = getIntent().getStringExtra("Name");
        System.out.println(name);
        textView.setText("Hello " + name);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(view -> {
            //My logic for Button goes in here
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            if (mButtonChoice1.getText() == mAnswer){
                mScore = mScore + 1;
                //This line of code is option a
                Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
              //  mButtonChoice1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.green), PorterDuff.Mode.MULTIPLY);
                mButtonChoice1.setBackgroundColor(Color.GREEN);


            }else {
               // mButtonChoice1.getBackground().setColorFilter(ContextCompat.getColor(this, R.color.red), PorterDuff.Mode.MULTIPLY);
                mButtonChoice1.setBackgroundColor(Color.RED);
                Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(view -> {
            //My logic for Button goes in here
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            if (mButtonChoice2.getText() == mAnswer){
                mScore = mScore + 1;
                //This line of code is option a
                mButtonChoice2.setBackgroundColor(Color.GREEN);
                Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

            }else {
                mButtonChoice2.setBackgroundColor(Color.RED);
                Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
            }
        });

        //End of Button Listener for Button2


        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(view -> {
            //My logic for Button goes in here
            mButtonChoice1.setEnabled(false);
            mButtonChoice2.setEnabled(false);
            mButtonChoice3.setEnabled(false);
            if (mButtonChoice3.getText() == mAnswer){
                mScore = mScore + 1;
                //This line of code is option a
                mButtonChoice3.setBackgroundColor(Color.GREEN);
                Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

            }else {
                mButtonChoice3.setBackgroundColor(Color.RED);
                Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
            }

        });

        nextButton.setOnClickListener(view -> {
            if (mButtonChoice1.isEnabled() || mButtonChoice2.isEnabled() || mButtonChoice3.isEnabled()) {

                Toast.makeText(this, " Select One Option " , Toast.LENGTH_SHORT ).show();
            } else {
            updateQuestion();
            simpleProgressBar.setProgress((mQuestionNumber-1)*(100/mQuestionLibrary.getTotalQuestions()));
            }

        });
        //End of Button Listener for Button3

    }

    private void updateQuestion(){

        if(mQuestionNumber == mQuestionLibrary.getTotalQuestions())
        {
            Intent intent = new Intent(this,FinalActivity.class);
            intent.putExtra("Score",mScore);
            intent.putExtra("Name", name);
            startActivity(intent);
        }
        else {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice1.setBackgroundColor(Color.WHITE);
            mButtonChoice1.setEnabled(true);
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice2.setBackgroundColor(Color.WHITE);
            mButtonChoice2.setEnabled(true);
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice3.setBackgroundColor(Color.WHITE);
            mButtonChoice3.setEnabled(true);

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
    }


}
