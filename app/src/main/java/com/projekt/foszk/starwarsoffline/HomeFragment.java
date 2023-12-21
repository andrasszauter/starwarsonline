package com.projekt.foszk.starwarsoffline;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    ImageView homeBkg, homeIntroBkg, homeIntroLogo, tieFighter;

    /////////////////////////////////////////////////////////
    // Create a Timer object to play the timed Tie Fighter sound
    final Timer timer = new Timer();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        homeBkg = (ImageView) view.findViewById(R.id.homeBkg);
        homeIntroBkg = (ImageView) view.findViewById(R.id.homeIntroBkg);
        homeIntroLogo = (ImageView) view.findViewById(R.id.homeIntroLogo);
        tieFighter = (ImageView) view.findViewById(R.id.Tie);

        /////////////////////////////////////////////////////////
        // Play Tie Fighter flyby effect

        MediaPlayer mpFlyBy = MediaPlayer.create(getActivity(), R.raw.tie_fighter_flyby);
        mpFlyBy.setVolume(0.4f, 0.4f);

        /////////////////////////////////////////////////////////
        // Create a TimerTask object ( so that the sound only plays here, the timer stops in onStop() )
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                mpFlyBy.start();
            }
        };

        /////////////////////////////////////////////////////////
        // Set the schedule for the TimerTask
        timer.schedule(timerTask, 15000);

        /////////////////////////////////////////////////////////
        // Animation

        // stars background fade out
        ObjectAnimator homeIntroBkgFadeOut = ObjectAnimator.ofFloat(homeIntroBkg, "alpha", 0, 1);
        homeIntroBkgFadeOut.setDuration(5000);

        // stars background animate
        ObjectAnimator homeIntroBkgScaleX = ObjectAnimator.ofFloat(homeIntroBkg, "scaleX", 1, 1.1f);
        homeIntroBkgScaleX.setDuration(50000);
        ObjectAnimator homeIntroBkgScaleY = ObjectAnimator.ofFloat(homeIntroBkg, "scaleY", 1, 1.1f);
        homeIntroBkgScaleY.setDuration(50000);

        // logo scale down
        ObjectAnimator homeIntroLogoScaleX = ObjectAnimator.ofFloat(homeIntroLogo, "scaleX", 40, 1);
        homeIntroLogoScaleX.setDuration(3000);
        homeIntroLogoScaleX.setStartDelay(2000);

        ObjectAnimator homeIntroLogoScaleY = ObjectAnimator.ofFloat(homeIntroLogo, "scaleY", 40, 0.4f);
        homeIntroLogoScaleY.setDuration(3000);
        homeIntroLogoScaleY.setStartDelay(2000);

        // Logo scale down, by...
        ObjectAnimator homeIntroLogoScaleX_2 = ObjectAnimator.ofFloat(homeIntroLogo, "scaleX", 1, 0);
        homeIntroLogoScaleX_2.setDuration(5000);
        homeIntroLogoScaleX_2.setStartDelay(10000);

        ObjectAnimator homeIntroLogoScaleY_2 = ObjectAnimator.ofFloat(homeIntroLogo, "scaleY", 0.4f, 0);
        homeIntroLogoScaleY_2.setDuration(5000);
        homeIntroLogoScaleY_2.setStartDelay(10000);

        // tie fighter movement --------------------------------------------------------------------------------------------------

        ObjectAnimator tieMoveDown = ObjectAnimator.ofFloat(tieFighter, "translationY", -200, 2200);
        tieMoveDown.setInterpolator(new AccelerateInterpolator(2));
        tieMoveDown.setDuration(4000);
        tieMoveDown.setStartDelay(15000);

        ObjectAnimator tieScaleUpX = ObjectAnimator.ofFloat(tieFighter, "ScaleX", 0.1f, 10);
        tieScaleUpX.setInterpolator(new AccelerateInterpolator(10));
        tieScaleUpX.setDuration(4000);
        tieScaleUpX.setStartDelay(15000);

        ObjectAnimator tieScaleUpY = ObjectAnimator.ofFloat(tieFighter, "ScaleY", 0.1f, 10);
        tieScaleUpY.setInterpolator(new AccelerateInterpolator(10));
        tieScaleUpY.setDuration(4000);
        tieScaleUpY.setStartDelay(15000);

        // stars background fade in
        ObjectAnimator homeIntroBkgFadeIn = ObjectAnimator.ofFloat(homeIntroBkg, "alpha", 1, 0);
        homeIntroBkgFadeIn.setDuration(5000);
        homeIntroBkgFadeIn.setStartDelay(22000);

        // home background fade in
        ObjectAnimator homeBkgFadeOut = ObjectAnimator.ofFloat(homeBkg, "alpha", 0, 1);
        homeBkgFadeOut.setDuration(5000);
        homeBkgFadeOut.setStartDelay(25000);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                homeIntroBkgFadeOut,
                homeIntroLogoScaleX,
                homeIntroLogoScaleY,
                homeIntroBkgScaleX,
                homeIntroBkgScaleY,
                homeIntroLogoScaleX_2,
                homeIntroLogoScaleY_2,
                tieMoveDown,
                tieScaleUpX,
                tieScaleUpY,
                homeIntroBkgFadeIn,
                homeBkgFadeOut
        );

        animatorSet.start();

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();

        if (timer != null) {
            timer.cancel();
        }
    }
}
