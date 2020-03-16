package np.com.pramitmarattha;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = findViewById(R.id.show_count);
        if (savedInstanceState != null)
        {

                mShowCount.setText(savedInstanceState.getString("string"));
                mCount=savedInstanceState.getInt("integer");
            }
        }
    public void countUp(View view)
    {
        mCount++;

        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount));

    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

            outState.putInt("integer",mCount);
            outState.putString("string", mShowCount.getText().toString());

    }
}
