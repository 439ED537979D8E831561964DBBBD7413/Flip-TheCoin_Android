package com.example.hp.malek_w_ketaba;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;
    Random random;
    int coinside;
    MediaPlayer mediaPlayer;

    public void Intial()
    {
        button = (Button) findViewById(R.id.Flip);
        image = (ImageView) findViewById(R.id.Coin);
        random = new Random();
        mediaPlayer = MediaPlayer.create(this, R.raw.coin);
    }

    public void Start()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coinside = random.nextInt(2);
                if (coinside == 0)
                {
                    image.setImageResource(R.drawable.malek);
                }
                else if (coinside == 1)
                {
                    image.setImageResource(R.drawable.ketaba);
                }
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF,
                        0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                rotateAnimation.setDuration(1000);
                image.startAnimation(rotateAnimation);
                mediaPlayer.start();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intial();
        Start();
    }
}