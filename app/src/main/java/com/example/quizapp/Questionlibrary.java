package com.example.quizapp;
class QuestionLibrary
{

    private final String[] mQuestions = {
            "Which of the following options does not belong to the layouts of Android Studio ",
            "Which of the following options is not one part of the activity lifecycle?",
            "Android is - ",
            "Android is based upon which of the following language?",
            "APK stands for - ",
    };

    private final String[][] mChoices = {
            {"Linear Layout" , "Curve Layout" ,  "Relative Layout" },
            {"onCreate()" , "onResume()" ,  "onRun()" },
            {"a web server" , "an operating system" ,  "a web browser" },
            {"Java" , "C++" ,  "C" },
            {"Android pge kit" , "Android phone kit" ,  "Android package kit" },
    };


    private final String[] mCorrectAnswers = {"Curve Layout", "onRun()", "an operating system", "Java","Android package kit"};

    public int getTotalQuestions()
    {
        return mQuestions.length;
    }

    public String getQuestion(int a) {
        return mQuestions[a];
    }


    public String getChoice1(int a) {
        return mChoices[a][0];
    }


    public String getChoice2(int a) {
        return mChoices[a][1];
    }

    public String getChoice3(int a) {
        return mChoices[a][2];
    }

    public String getCorrectAnswer(int a) {
        return mCorrectAnswers[a];
    }
}
