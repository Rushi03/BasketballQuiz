package com.example.android.basketballquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private int point = 0;

    private EditText doctorAnswer;
    private EditText iversonAnswer;
    private CheckBox onePoint;
    private CheckBox twoPoint;
    private CheckBox threePoint;
    private CheckBox fivePoint;
    private RadioGroup jordan;
    private RadioGroup penalty;
    private RadioButton mj;
    private RadioButton foul;
    private int selectIdOne;
    private int selectIdTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doctorAnswer = (EditText) findViewById(R.id.j_answer);
        iversonAnswer = (EditText) findViewById(R.id.iverson_answer);
        onePoint = (CheckBox) findViewById(R.id.free_throw);
        twoPoint = (CheckBox) findViewById(R.id.two_points);
        threePoint = (CheckBox) findViewById(R.id.three_points);
        fivePoint = (CheckBox) findViewById(R.id.five_points);
        jordan = (RadioGroup) findViewById(R.id.radio_jordan);
        penalty = (RadioGroup) findViewById(R.id.radio_penalty);
    }

    /**
     * Gathering the user input
     * @param view gather user input
     */
    public void submit(View view)
    {
        String docName = doctorAnswer.getText().toString();

        String answerName = iversonAnswer.getText().toString();

        boolean isOne = onePoint.isChecked();

        boolean isTwo = twoPoint.isChecked();

        boolean isThree = threePoint.isChecked();

        boolean isFive = fivePoint.isChecked();

        selectIdOne = jordan.getCheckedRadioButtonId();
        mj = (RadioButton) findViewById(selectIdOne);
        String mJ = mj.getText().toString();

        selectIdTwo = penalty.getCheckedRadioButtonId();
        foul = (RadioButton) findViewById(selectIdTwo);
        String technical = foul.getText().toString();


        int number = calculatePercent(isOne, isTwo, isThree, isFive, mJ, technical,
                docName, answerName);
        showScore(number);
    }

    /**
     *  Calculating the percentage of the answers answered correctly
     * @param one boolean response for free throw
     * @param two boolean response for two points
     * @param three boolean response for three points
     * @param five boolean response for five points
     * @param jordanNumber true/false response
     * @param typeOfFoul different types of penalty
     * @param docName input string name of Dr. J
     * @param nickName input string of Allen Iverson nickname
     * @return calculated percent
     */
    private int calculatePercent(boolean one, boolean two, boolean three, boolean five,
                                 String jordanNumber, String typeOfFoul, String docName,
                                 String nickName)
    {
        if(one && two && three && !five)
        {
            point += 1;
        }
        else
        {
            point += 0;
        }

        if (jordanNumber.equals("True"))
        {
            point += 1;
        }
        else
        {
            point += 0;
        }

        if (typeOfFoul.equals("Technical Foul"))
        {
            point += 1;
        }
        else
        {
            point += 0;
        }

        if (docName.equals("julius erving"))
        {
            point += 1;
        }
        else
        {
            point += 0;
        }

        if (nickName.equals("the answer"))
        {
            point += 1;
        }
        else
        {
            point += 0;
        }
        return (int)(((double)point/5) * 100);
    }

    /**
     * Displaying the score for user's answers
     * @param percent of questions answered correctly
     */
    private void showScore(int percent)
    {
        if (percent <= 100) {
            String finalScore = "The final score is " + percent + "%";
            Toast.makeText(MainActivity.this, finalScore, Toast.LENGTH_SHORT).show();
        }
        else
        {
            return;
        }
    }
}
