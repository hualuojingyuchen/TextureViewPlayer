package test1.dongfang.dayima.hymplayeritem.player;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import test1.dongfang.dayima.hymplayeritem.R;

/**
 * @author: xdf on 2016/10/31
 */
public class FullScreenPlayVideoActivity extends AppCompatActivity
            implements HYMPlayerView.ExitFullScreenListener {

    private VideoPlayState mCurrPlayState;
    private ViewGroup mParent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen_play_video);
        mParent = (ViewGroup) findViewById(R.id.root);
        VideoPlayerHelper.getInstance().fullScreen(mParent, this);
    }

    @Override
    protected void onPause() {

        super.onPause();
        mCurrPlayState = VideoPlayerHelper.getInstance().getVideoPlayState();
        VideoPlayerHelper.getInstance().pause();
    }

    @Override
    protected void onResume() {

        super.onResume();
        if(mCurrPlayState == VideoPlayState.PLAY) {
            VideoPlayerHelper.getInstance().play();
        }
    }

    @Override
    protected void onStop() {

        VideoPlayerHelper.getInstance().exitFullScreen(mCurrPlayState);
        super.onStop();
    }

    @Override
    public void exitFullScreen() {

        finish();
    }
}
