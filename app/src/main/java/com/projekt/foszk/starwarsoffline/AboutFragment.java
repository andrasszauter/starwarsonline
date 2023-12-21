package com.projekt.foszk.starwarsoffline;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutFragment extends Fragment {

    TextView textView1, textView2, textView3, textView4, textView5,
            textView6, textView7, textView8, textView9, textView10, textView11;
    ImageView imgLogo;
    LinearLayout linearLayout, linLayAbout, layAlphaBkg;


    public AboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);

        imgLogo = (ImageView) view.findViewById(R.id.img_swLogo);

        linearLayout = (LinearLayout) view.findViewById(R.id.linearLay);
        linLayAbout = (LinearLayout) view.findViewById(R.id.linLayAbout);
        layAlphaBkg = (LinearLayout) view.findViewById(R.id.layAlphaBkg);

        textView1 = (TextView) view.findViewById(R.id.textView1);
        textView2 = (TextView) view.findViewById(R.id.textView2);
        textView3 = (TextView) view.findViewById(R.id.textView3);
        textView4 = (TextView) view.findViewById(R.id.textView4);
        textView5 = (TextView) view.findViewById(R.id.textView5);
        textView6 = (TextView) view.findViewById(R.id.textView6);
        textView7 = (TextView) view.findViewById(R.id.textView7);
        textView8 = (TextView) view.findViewById(R.id.textView8);
        textView9 = (TextView) view.findViewById(R.id.textView9);
        textView10 = (TextView) view.findViewById(R.id.textView10);
        textView11 = (TextView) view.findViewById(R.id.textView11);

        int movValFrom = 500;
        int movValTo = -200;
        int movValToChange = 100;
        int scaleXFrom = (int) 2.5;
        int scaleXTo = (int) 0.2;
        int rotXFrom = 50;
        int rotXTo = 80;
        int duration_1 = 30000; // translationY
        int duration_2 = 30000; // scaleX
        int duration_3 = 30000; // rotationX

        ///////////////////////////////////
        //
        // ObjectAnimator propertyName:
        //
        // translationX, translationY,
        // rotation, rotationX, rotationY,
        // scaleX, scaleY,
        // pivotX, pivotY,
        // x, y,
        // alpha
        //
        ///////////////////////////////////

        ObjectAnimator animLogo = ObjectAnimator.ofFloat(imgLogo, "scaleX", 40, 1);
        animLogo.setDuration(5000);

        ObjectAnimator animLogo2 = ObjectAnimator.ofFloat(imgLogo, "scaleY", 40, 1);
        animLogo2.setDuration(5000);

        ObjectAnimator text1 = ObjectAnimator.ofFloat(textView1, "translationY", movValFrom, movValTo);
        ObjectAnimator text1_2 = ObjectAnimator.ofFloat(textView1, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text1_3 = ObjectAnimator.ofFloat(textView1, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text1_4 = ObjectAnimator.ofFloat(textView1, "alpha", 100, 0);
        text1.setDuration(duration_1);
        text1_2.setDuration(duration_2);
        text1_3.setDuration(duration_3);
        text1_4.setDuration(13000);
        movValTo -= movValToChange;

        ObjectAnimator text2 = ObjectAnimator.ofFloat(textView2, "translationY", movValFrom, (movValTo));
        ObjectAnimator text2_2 = ObjectAnimator.ofFloat(textView2, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text2_3 = ObjectAnimator.ofFloat(textView2, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text2_4 = ObjectAnimator.ofFloat(textView2, "alpha", 100, 0);
        text2.setDuration(duration_1);
        text2_2.setDuration(duration_2);
        text2_3.setDuration(duration_3);
        text2_4.setDuration(14000);
        movValTo -= movValToChange;

        ObjectAnimator text3 = ObjectAnimator.ofFloat(textView3, "translationY", movValFrom, (movValTo));
        ObjectAnimator text3_2 = ObjectAnimator.ofFloat(textView3, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text3_3 = ObjectAnimator.ofFloat(textView3, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text3_4 = ObjectAnimator.ofFloat(textView3, "alpha", 100, 0);
        text3.setDuration(duration_1);
        text3_2.setDuration(duration_2);
        text3_3.setDuration(duration_3);
        text3_4.setDuration(15000);
        movValTo -= movValToChange;

        ObjectAnimator text4 = ObjectAnimator.ofFloat(textView4, "translationY", movValFrom, (movValTo));
        ObjectAnimator text4_2 = ObjectAnimator.ofFloat(textView4, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text4_3 = ObjectAnimator.ofFloat(textView4, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text4_4 = ObjectAnimator.ofFloat(textView4, "alpha", 100, 0);
        text4.setDuration(duration_1);
        text4_2.setDuration(duration_2);
        text4_3.setDuration(duration_3);
        text4_4.setDuration(16000);
        movValTo -= movValToChange;

        ObjectAnimator text5 = ObjectAnimator.ofFloat(textView5, "translationY", movValFrom, (movValTo));
        ObjectAnimator text5_2 = ObjectAnimator.ofFloat(textView5, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text5_3 = ObjectAnimator.ofFloat(textView5, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text5_4 = ObjectAnimator.ofFloat(textView5, "alpha", 100, 0);
        text5.setDuration(duration_1);
        text5_2.setDuration(duration_2);
        text5_3.setDuration(duration_3);
        text5_4.setDuration(17000);
        movValTo -= movValToChange;

        ObjectAnimator text6 = ObjectAnimator.ofFloat(textView6, "translationY", movValFrom, (movValTo));
        ObjectAnimator text6_2 = ObjectAnimator.ofFloat(textView6, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text6_3 = ObjectAnimator.ofFloat(textView6, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text6_4 = ObjectAnimator.ofFloat(textView6, "alpha", 100, 0);
        text6.setDuration(duration_1);
        text6_2.setDuration(duration_2);
        text6_3.setDuration(duration_3);
        text6_4.setDuration(17500);
        movValTo -= movValToChange;

        ObjectAnimator text7 = ObjectAnimator.ofFloat(textView7, "translationY", movValFrom, (movValTo));
        ObjectAnimator text7_2 = ObjectAnimator.ofFloat(textView7, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text7_3 = ObjectAnimator.ofFloat(textView7, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text7_4 = ObjectAnimator.ofFloat(textView7, "alpha", 100, 0);
        text7.setDuration(duration_1);
        text7_2.setDuration(duration_2);
        text7_3.setDuration(duration_3);
        text7_4.setDuration(18000);
        movValTo -= movValToChange;

        ObjectAnimator text8 = ObjectAnimator.ofFloat(textView8, "translationY", movValFrom, (movValTo));
        ObjectAnimator text8_2 = ObjectAnimator.ofFloat(textView8, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text8_3 = ObjectAnimator.ofFloat(textView8, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text8_4 = ObjectAnimator.ofFloat(textView8, "alpha", 100, 0);
        text8.setDuration(duration_1);
        text8_2.setDuration(duration_2);
        text8_3.setDuration(duration_3);
        text8_4.setDuration(18500);
        movValTo -= movValToChange + 25;

        ObjectAnimator text9 = ObjectAnimator.ofFloat(textView9, "translationY", movValFrom, (movValTo));
        ObjectAnimator text9_2 = ObjectAnimator.ofFloat(textView9, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text9_3 = ObjectAnimator.ofFloat(textView9, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text9_4 = ObjectAnimator.ofFloat(textView9, "alpha", 100, 0);
        text9.setDuration(duration_1);
        text9_2.setDuration(duration_2);
        text9_3.setDuration(duration_3);
        text9_4.setDuration(19000);
        movValTo -= movValToChange + 35;

        ObjectAnimator text10 = ObjectAnimator.ofFloat(textView10, "translationY", movValFrom, (movValTo));
        ObjectAnimator text10_2 = ObjectAnimator.ofFloat(textView10, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text10_3 = ObjectAnimator.ofFloat(textView10, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text10_4 = ObjectAnimator.ofFloat(textView10, "alpha", 100, 0);
        text10.setDuration(duration_1);
        text10_2.setDuration(duration_2);
        text10_3.setDuration(duration_3);
        text10_4.setDuration(19500);
        movValTo -= movValToChange + 50;

        ObjectAnimator text11= ObjectAnimator.ofFloat(textView11, "translationY", movValFrom, (movValTo));
        ObjectAnimator text11_2 = ObjectAnimator.ofFloat(textView11, "scaleX", scaleXFrom, scaleXTo);
        ObjectAnimator text11_3 = ObjectAnimator.ofFloat(textView11, "rotationX", rotXFrom, rotXTo);
        ObjectAnimator text11_4 = ObjectAnimator.ofFloat(textView11, "alpha", 100, 0);
        text11.setDuration(duration_1);
        text11_2.setDuration(duration_2);
        text11_3.setDuration(duration_3);
        text11_4.setDuration(20000);

        ObjectAnimator lay_1 = ObjectAnimator.ofFloat(linLayAbout, "alpha", 0, 1);
        lay_1.setStartDelay(20000);
        lay_1.setDuration(10000);

        ObjectAnimator layAlpha = ObjectAnimator.ofFloat(layAlphaBkg, "scaleX", 1, 1.5f);
        ObjectAnimator layAlpha_2 = ObjectAnimator.ofFloat(layAlphaBkg, "scaleY", 1, 1.5f);
        layAlpha.setDuration(100000);
        layAlpha.setRepeatMode(ObjectAnimator.REVERSE);
        layAlpha.setRepeatCount(-1);
        layAlpha_2.setDuration(100000);
        layAlpha_2.setRepeatMode(ObjectAnimator.REVERSE);
        layAlpha_2.setRepeatCount(-1);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animLogo, animLogo2,
                text1, text1_2, text1_3, text1_4,
                text2, text2_2, text2_3, text2_4,
                text3, text3_2, text3_3, text3_4,
                text4, text4_2, text4_3, text4_4,
                text5, text5_2, text5_3, text5_4,
                text6, text6_2, text6_3, text6_4,
                text7, text7_2, text7_3, text7_4,
                text8, text8_2, text8_3, text8_4,
                text9, text9_2, text9_3, text9_4,
                text10, text10_2, text10_3, text10_4,
                text11, text11_2, text11_3, text11_4,
                lay_1, layAlpha, layAlpha_2

        );
        animatorSet.start();

        return view;
    }
}