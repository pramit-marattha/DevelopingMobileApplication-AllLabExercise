package np.com.pramitmarattha;

import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

class CustomTimer implements LifecycleObserver {

    public static final String TAG = "CustomTimer";

    // The number of seconds counted since the timer started
    int secondsCount = 0;
    Lifecycle lifecycle;

    public CustomTimer(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    /**
     * [Handler] is a class meant to process a queue of messages (known as [android.os.Message]s)
     * or actions (known as [Runnable]s)
     */
    private Handler handler = new Handler();
    private Runnable runnable;


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void startTimer() {
        // Create the runnable action, which prints out a log and increments the seconds counter
        runnable = new Runnable() {
            @Override
            public void run() {
                secondsCount++;
                Log.i(TAG, "Timer is at : "+secondsCount);
                // postDelayed re-adds the action to the queue of actions the Handler is cycling
                // through. The delayMillis param tells the handler to run the runnable in
                // 1 second (1000ms)
                handler.postDelayed(runnable, 1000);
            }
        };

        // This is what initially starts the timer
        handler.postDelayed(runnable, 1000);

        // Note that the Thread the handler runs on is determined by a class called Looper.
        // In this case, no looper is defined, and it defaults to the main or UI thread.
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stopTimer() {
        // Removes all pending posts of runnable from the handler's queue, effectively stopping the
        // timer
        handler.removeCallbacks(runnable);
    }
}
