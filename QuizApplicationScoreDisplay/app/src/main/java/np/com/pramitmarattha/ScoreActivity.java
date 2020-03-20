package np.com.pramitmarattha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        textView = findViewById(R.id.score_display_area);

        Intent intent = getIntent();
        String score = intent.getStringExtra("SCORE");
        textView.setText(score);

        Button backToStartButton = findViewById(R.id.back_to_beginning);
        backToStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }
}