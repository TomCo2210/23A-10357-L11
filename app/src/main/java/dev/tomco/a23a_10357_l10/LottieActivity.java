package dev.tomco.a23a_10357_l10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

public class LottieActivity extends AppCompatActivity {
    private LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);

        findViews();
        //load data from FB
        lottieAnimationView.resumeAnimation();

    }

    private void findViews(){
        lottieAnimationView = findViewById(R.id.lottie_ANIM_lottie);
    }
}