package np.com.pramitmarattha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount;
    private TextView mShowCount;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public final static String MESSAGE = "np.com.pramitmarattha.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d(LOG_TAG, "on--Start...");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d(LOG_TAG, "on--Resume...");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d(LOG_TAG, "on--Pause...");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d(LOG_TAG, "on--Restart...");
    }


    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d(LOG_TAG, "on--Stop...");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(LOG_TAG, "on--Destroy...");
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

    public void showSecondActivity(View view)
    {
        Intent newActivity = new Intent(this, SecondActivity.class);
        newActivity.putExtra(MESSAGE, "Helloo, Pramit!! ");
        startActivityForResult(newActivity, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                String reply = data.getStringExtra(SecondActivity.RETURN_MESSAGE);
                Log.d(LOG_TAG, reply);
            } else
            {
                Log.d(LOG_TAG, getString(R.string.no_response));
            }
        }
    }
}