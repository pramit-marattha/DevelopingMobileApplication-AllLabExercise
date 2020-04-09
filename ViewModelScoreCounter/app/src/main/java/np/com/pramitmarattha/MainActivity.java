package np.com.pramitmarattha;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ScoreViewModel viewModel;


    private TextView textViewTeamA;
    private TextView textViewTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTeamA=findViewById(R.id.team_a_score);
        textViewTeamB=findViewById(R.id.team_b_score);

        Log.i("MainActivity","ViewModelProviders called");

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);



    }

    public void add3TeamA(View view){
        viewModel.teamAScore = viewModel.teamAScore +3;
        displayScoreForTeamA(viewModel.teamAScore);
    }

    public void add2TeamA(View view){
        viewModel.teamAScore = viewModel.teamAScore +2;
        displayScoreForTeamA(viewModel.teamAScore);
    }
    public void add1TeamA(View view){
        viewModel.teamAScore = viewModel.teamAScore +1;
        displayScoreForTeamA(viewModel.teamAScore);
    }

    public void add3TeamB(View view){
        viewModel.teamBScore = viewModel.teamBScore +3;
        displayScoreForTeamB(viewModel.teamBScore);
    }

    public void add2TeamB(View view){
        viewModel.teamBScore = viewModel.teamBScore +2;
        displayScoreForTeamB(viewModel.teamBScore);
    }
    public void add1TeamB(View view){
        viewModel.teamBScore = viewModel.teamBScore +1;
        displayScoreForTeamB(viewModel.teamBScore);
    }

    public void displayScoreForTeamA(int score) {
        textViewTeamA.setText(String.valueOf(score));

    }

    public void displayScoreForTeamB(int score) {
        textViewTeamB.setText(String.valueOf(score));

    }

    public void resetScore(View view)
    {
        viewModel.teamAScore = 0;
        viewModel.teamBScore = 0;
        displayScoreForTeamA(viewModel.teamAScore);
        displayScoreForTeamB(viewModel.teamBScore);
    }




}
