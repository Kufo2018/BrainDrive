package com.example.kuforiji.braindrive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    CheckBox Question1a, Question1b, Question1c, Question1d, Question5a, Question5b, Question5c, Question5d;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Getting instance of the submit score button from the activity_main2.xml file
        Button submitScore = findViewById(R.id.finalScore);

        //Applying the Listener on the Button click
        submitScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Q1ans, Q2ans, Q3ans, Q4ans, Q5ans;

                StringBuilder result = new StringBuilder();

                //ANSWERING QUESTION1//

                Question1a = findViewById(R.id.question1a_checkbox);
                Question1b = findViewById(R.id.question1b_checkbox);
                Question1c = findViewById(R.id.question1c_checkbox);
                Question1d = findViewById(R.id.question1d_checkbox);

                boolean option1a = Question1a.isChecked();
                boolean option1b = Question1b.isChecked();
                boolean option1c = Question1c.isChecked();
                boolean option1d = Question1d.isChecked();

                if (option1a && !option1b && option1c && !option1d) {
                    result.append("\nQ1- Correct");
                    Q1ans = 1;
                } else {
                    result.append("\nQ1- Wrong");
                    Q1ans = 0;
                }

                //ANSWERING QUESTION 2

                EditText Q2 = findViewById(R.id.question2);
                Editable Qu2 = Q2.getText();
                String Q2Imput = Qu2.toString();
                String correctAnswer2 = "two";
                if (Q2Imput.equals(correctAnswer2)) {
                    result.append("\nQ2- Correct");
                    Q2ans = 1;
                } else {
                    result.append("\nQ2- Wrong");
                    Q2ans = 0;
                }

                //ANSWERING QUESTION 3
                //Getting instance of Q3RadioButton from the activity_main2.xml file
                final RadioButton question3 = findViewById(R.id.question3a_radiobox);

                if (question3.isChecked()) {
                    result.append("\nQ3- Correct");
                    Q3ans = 1;
                } else {
                    result.append("\nQ3- Wrong");
                    Q3ans = 0;
                }

                //ANSWERING QUESTION 4
                EditText Q4 = findViewById(R.id.question4);
                Editable Qu4 = Q4.getText();
                String Q4Imput = Qu4.toString();
                String correctAnswer4 = "true";

                if (Q4Imput.equals(correctAnswer4)) {
                    result.append("\nQ4- Correct");
                    Q4ans = 1;
                } else {
                    result.append("\nQ4- Wrong");
                    Q4ans = 0;
                }

                //ANSWERING QUESTION 5

                //Getting instance of Q5CheckBox from the activity_main2.xml file
                Question5a = findViewById(R.id.question5a_checkbox);
                Question5b = findViewById(R.id.question5b_checkbox);
                Question5c = findViewById(R.id.question5c_checkbox);
                Question5d = findViewById(R.id.question5d_checkbox);

                boolean option5a = Question5a.isChecked();
                boolean option5b = Question5b.isChecked();
                boolean option5c = Question5c.isChecked();
                boolean option5d = Question5d.isChecked();

                if (option5a && !option5b && !option5c && option5d) {
                    result.append("\nQ5- Correct");
                    Q5ans = 1;
                } else {
                    result.append("\nQ5- Wrong");
                    Q5ans = 0;
                }

                //Displaying the final score
                result.append("\nFinalScore=").append(Q1ans + Q2ans + Q3ans + Q4ans + Q5ans);
                //Displaying the correct answers on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
    }

    //Go Home button
    public void launchfirstActivity(View view) {
        Log.d(LOG_TAG, "Go Home!");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
