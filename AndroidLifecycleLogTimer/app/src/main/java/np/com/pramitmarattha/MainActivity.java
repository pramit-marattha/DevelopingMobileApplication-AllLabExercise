package np.com.pramitmarattha;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    public static final String TAG = "MainActivity";
    CustomTimer timer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new CustomTimer(this.getLifecycle());
    }

    /** Lifecycle Methods **/

    @Override
    public void onStart() {
        super.onStart();
        // timer.startTimer();
        Log.i(TAG, "onStart Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        //timer.stopTimer();
        Log.i(TAG, "onStop Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy Called");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart Called");
    }

}
