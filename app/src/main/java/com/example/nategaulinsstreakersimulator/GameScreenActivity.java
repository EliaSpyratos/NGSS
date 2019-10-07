package com.example.nategaulinsstreakersimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class GameScreenActivity extends AppCompatActivity {

    private int milsecs = 0;
    private boolean running = false;

    // Views
   // private NateView nateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        // Timer shit
        runTimer();
        startTimer();

        // Views
      //  nateView = new NateView(this);
      //  setContentView(nateView);

        ImageView img = findViewById(R.id.playerImageView);
        img.setBackgroundResource(R.drawable.player_animation_up);

        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        frameAnimation.start();
        
    }

    // Start stopwatch when the game starts
    public void startTimer(){

        running = true;

    }


    // Stop stopwatch when the game ends
    public void stopTimer(View v){

        running = false;

    }


    // Reset stopwatch when the reset button is clicked
    public void resetTimer(View v){

        running = false;
        milsecs = 0;

    }

    private void runTimer(){

        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run() {


                int milsec = milsecs % 10;

                int secs = (milsecs / 10) % 60;

                int minutes  = (milsecs / 600);


                String time = String.format(Locale.getDefault(), "%02d:%02d:%01d", minutes, secs, milsec);

                timeView.setText(time);

                if(running){
                    milsecs ++;
                }
                handler.postDelayed(this ,100);
            }


        });



    }


}