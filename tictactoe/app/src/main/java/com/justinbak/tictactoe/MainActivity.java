/* This is a tic tac toe app developed by Justin Bak in 2017 in Android Studio */

package com.justinbak.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int turn;
    int[] grid = new int[9];


    public void init() {
        turn = 1;
        //set grid spaces to zero (empty)
        for (int i = 0; i < grid.length; i++) {
            grid[i] = 0;
        }


    }

    public void playAgainButton(View v) {

    }
    int[][] winsPos = {{0,1,2}, {3,4,5}, {6,7,8},
                    {0,3,6}, {1,4,7}, {2,5,8},
                    {0,4,8}, {2,4,6}};

    public void fadeIn(View v) {

        ImageView counter = (ImageView) v;

        counter.animate().alpha(1.0f).rotation(90).setDuration(1000);

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(!gameOver() && grid[tappedCounter] == 0) {

            grid[tappedCounter] = turn;

            //Switches the mark used based on the turn. Also swtiches turns
            if (turn == 1) {
                counter.setImageResource(R.drawable.tictactoe_x);
                turn = 2;
            } else {
                counter.setImageResource(R.drawable.red_mark);
                turn = 1;
            }

            if(gameOver()){
                gameOverPrint();
            }
        }
    }

    public boolean gameOver() {
        for (int[] winningPosition: winsPos) {
            if(grid[winningPosition[0]] == grid[winningPosition[1]] &&
                grid[winningPosition[1]] == grid[winningPosition[2]] &&
                grid[winningPosition[0]] != 0) {

                return true;
            }
        }
        return false;
    }

    public void gameOverPrint() {


        System.out.println("won");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
}
