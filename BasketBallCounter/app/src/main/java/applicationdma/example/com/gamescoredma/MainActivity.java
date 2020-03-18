package applicationdma.example.com.gamescoredma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAScore;
    private int teamBScore;
    private TextView textViewTeamA;
    private TextView textViewTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTeamA=findViewById(R.id.team_a_score);
        textViewTeamB=findViewById(R.id.team_b_score);
    }

    public void add3TeamA(View view){
        teamAScore = teamAScore +3;
                displayScoreForTeamA(teamAScore);
    }

    public void add2TeamA(View view){
        teamAScore = teamAScore +2;
        displayScoreForTeamA(teamAScore);
    }
    public void add1TeamA(View view){
        teamAScore = teamAScore +1;
        displayScoreForTeamA(teamAScore);
    }

    public void add3TeamB(View view){
        teamBScore = teamBScore +3;
        displayScoreForTeamB(teamBScore);
    }

    public void add2TeamB(View view){
        teamBScore = teamBScore +2;
        displayScoreForTeamB(teamBScore);
    }
    public void add1TeamB(View view){
        teamBScore = teamBScore +1;
        displayScoreForTeamB(teamBScore);
    }

    public void displayScoreForTeamA(int score) {
        textViewTeamA.setText(String.valueOf(score));

    }

    public void displayScoreForTeamB(int score) {
        textViewTeamB.setText(String.valueOf(score));

    }

    public void resetScore(View view)
    {
        teamAScore = 0;
        teamBScore = 0;
        displayScoreForTeamA(teamAScore);
        displayScoreForTeamB(teamBScore);
    }




}
