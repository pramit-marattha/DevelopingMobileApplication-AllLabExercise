package np.com.pramitmarattha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public final static String RETURN_MESSAGE = "np.com.pramitmarattha.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE);
        TextView mMessage = findViewById(R.id.simpleText);
        mMessage.setText(String.valueOf(message));
        mShowCount = findViewById(R.id.show_count);
        if (savedInstanceState != null)
        {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");

            if (isVisible)
            {
                mShowCount.setText(savedInstanceState.getString("reply_text"));
                mShowCount.setVisibility(View.VISIBLE);
            }
        }

        Log.d(LOG_TAG, "on--Create...");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        if (mShowCount.getVisibility() == View.VISIBLE)
        {
            outState.putBoolean("reply_visible", true);
            outState.putString("reply_text", mShowCount.getText().toString());
        }
    }
    public void countUp(View view)
    {
        mCount++;

        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount));
    }

    public void countReset(View view)
    {
        mCount = 0;

        if (mShowCount != null)
            mShowCount.setText(String.valueOf(mCount));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG,"start vhayo....");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG,"Resume hudai xa");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG,"pause hudai xa");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG,"Restart Hudai xa");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG,"It stopped");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG,"Got destroyed");
    }



    public void Abort(View view)
    {
        finish();
    }
}

