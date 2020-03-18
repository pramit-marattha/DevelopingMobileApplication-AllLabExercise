package applicationdma.example.com.HelloConstraint;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private int pCount = 0;
    private TextView ShowCount;
    private Button ResetButton;
    private Button CountButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowCount = findViewById(R.id.show_count);
        ResetButton = findViewById(R.id.button_zero);
        CountButton = findViewById(R.id.button_count);
    }
    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message,
                Toast.LENGTH_SHORT);
        toast.show();
    }
    public void countUp(View view) {
        pCount++;
        if (ShowCount != null){
            ShowCount.setText(Integer.toString(pCount));
    }

        ResetButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        ResetButton.setClickable(true);

        switch (pCount % 2){
//            if mCount mod 2 is 0, number is even otherwise odd
            case 0: view.setBackgroundColor(Color.MAGENTA);
                break;
            case 1: view.setBackgroundColor(Color.GREEN);
                break;
            default: break;
        }
    }

    public void resetZero(View view) {
        pCount = 0;
        ShowCount.setText(String.valueOf(pCount));

        view.setClickable(false);
        view.setBackgroundColor(Color.GRAY);
        CountButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }
}