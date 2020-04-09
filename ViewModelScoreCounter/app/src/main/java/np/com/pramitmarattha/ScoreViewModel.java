package np.com.pramitmarattha;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {


    public int teamAScore ;
    public int teamBScore ;


    public ScoreViewModel(){
        super();
        Log.i("ScoreViewModel","ScoreViewModel Created");
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("ScoreViewModel","ScoreViewModel Destroyed");
    }
}
