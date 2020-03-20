package np.com.pramitmarattha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private String[] ResultQuizz = new String[6];
    private RadioGroup GroupOne;
    private RadioGroup GroupTwo;
    private RadioGroup GroupThree;
    private RadioGroup GroupFour;
    private RadioGroup GroupFive;
    private RadioGroup GroupSeven;
    private RadioGroup GroupEight;
    private RadioGroup GroupNine;
    private RadioGroup GroupTen;
    private EditText editText;
    private CheckBox error_varCheckbox;
    private CheckBox undefined_variableCheckbox;
    private CheckBox local_var_Checkbox;
    private CheckBox global_shadow_Checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submitButton = findViewById(R.id.submit_button);
        error_varCheckbox = findViewById(R.id.error_var_checkbox);
        undefined_variableCheckbox = findViewById(R.id.undefined_variable_checkbox);
        local_var_Checkbox = findViewById(R.id.local_var_checkbox);
        global_shadow_Checkbox = findViewById(R.id.global_shadow_checkbox);
        GroupOne = findViewById(R.id.group_one_Radio);
        GroupTwo = findViewById(R.id.group_two_Radio);
        GroupThree = findViewById(R.id.group_three_Radio);
        GroupFour = findViewById(R.id.group_four_Radio);
        GroupFive = findViewById(R.id.group_five_Radio);
        GroupSeven = findViewById(R.id.group_six_Radio);
        GroupEight = findViewById(R.id.group_seven_Radio);
        GroupNine = findViewById(R.id.group_eight_Radio);
        GroupTen = findViewById(R.id.group_nine_Radio);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score = 0;
                if (GroupOne.getCheckedRadioButtonId() == R.id.two_stars_radiobutton) {
                    score = score + 1;
                }
                if (GroupTwo.getCheckedRadioButtonId() == R.id.zero_or_more_radiobutton) {
                    score = score + 1;
                }
                if (GroupThree.getCheckedRadioButtonId() == R.id.getopt_radiobutton) {
                    score = score + 1;
                }
                if (GroupFour.getCheckedRadioButtonId() == R.id.list_radiobutton) {
                    score += 1;
                }
                if (GroupFive.getCheckedRadioButtonId() == R.id.false_radiobutton) {
                    score = score + 1;
                }
                if (global_shadow_Checkbox.isChecked() && !local_var_Checkbox.isChecked() && !undefined_variableCheckbox.isChecked() &&
                        !error_varCheckbox.isChecked()) {
                    score = score + 1;
                }
                if (GroupSeven.getCheckedRadioButtonId() == R.id.recursive_fast_radiobutton) {
                    score = score + 1;
                }
                if (GroupEight.getCheckedRadioButtonId() == R.id.direct_execution_radiobutton) {
                    score = score + 1;
                }
                if (GroupNine.getCheckedRadioButtonId() == R.id.exponent_radiobutton) {
                    score = score + 1;
                }
                if (GroupTen.getCheckedRadioButtonId() == R.id.int_radiobutton) {
                    score = score + 1;
                }
                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score + "/10");
                startActivity(intent);
            }
        });
    }
}