package com.example.reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive=true;
    //0 = o and 1 = x
    int activePlayer=1;
    //0 = o ,1 = x and 2 = blank
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int count=0;
    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    

    public void tapToPlay(View view){
        count++;
        if(!gameActive){
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
            gameReset(view);
        }
        ImageView img=(ImageView) view;
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(gameState[tappedImage]==2 ){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0) {
               img.setImageResource(R.drawable.o);
                activePlayer=1;
                TextView status= findViewById(R.id.statusbar1);
                status.setText("x's turn tap to play");
            }
            else {
                img.setImageResource((R.drawable.x2));
                activePlayer=0;
                TextView status= findViewById(R.id.statusbar1);
                status.setText("o's turn tap to play");

            }
        img.animate().translationYBy(1000f).setDuration(300);
        }

        for(int[] winPositions:winPosition){

            if (gameState[winPositions[0]]==gameState[winPositions[1]]&&gameState[winPositions[1]]==gameState[winPositions[2]]&&gameState[winPositions[0]]!=2){
                if(gameState[winPositions[0]]==0){
                    String winner="o is winner";
                    TextView statu= findViewById(R.id.statusbar1);
                    statu.setText(winner);
                    gameActive=false;
                }
                else if(gameState[winPositions[0]]==1){
                    String winner="x is a winner";
                    TextView statu= findViewById(R.id.statusbar1);
                    statu.setText(winner);
                    gameActive=false;
                }

            }
            else{

                if(count==8){
                    TextView statu= findViewById(R.id.statusbar1);
                    statu.setText("game is tie");
                    gameActive=false;
                }
            }


        }




    }
    public void gameReset(View view){
        gameActive=true;
        activePlayer=1;
        for(int i=0;i<gameState.length;i++) gameState[i]=2;


        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView14)).setImageResource(0);
        TextView status= findViewById(R.id.statusbar1);
        status.setText("x's turn tap to play");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}