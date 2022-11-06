package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    // 0=X
    // 1=O
    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //0 = X
    //1 = O
    //2 = NULL
    int[][] winState = {{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if (!gameActive){
            gamereset(view);
        }
        if (gameState[tappedImage] == 2){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if (activePlayer == 0){
                img.setImageResource(R.drawable.x);
                activePlayer =1;
                TextView status = findViewById(R.id.textviewstatus);
                status.setText("O's Turn - Tap to play!");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                TextView status = findViewById(R.id.textviewstatus);
                status.setText("X's Turn - Tap to play!");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winstate: winState){
            if (gameState[winstate[0]] == gameState[winstate[1]] &&
                    gameState[winstate[1]] == gameState[winstate[2]] &&
                    gameState[winstate[0]] != 2){
                String winstr;
                gameActive = false;
                if (gameState[winstate[0]] == 0){
                    winstr = "X has won!";
                }
                else{
                    winstr = "O has won!";
                }
                TextView status = findViewById(R.id.textviewstatus);
                status.setText(winstr);
            }
        }

    }

    public void gamereset(View view){
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i< gameState.length ; i++){
            gameState[i] = 2;
        }

        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}