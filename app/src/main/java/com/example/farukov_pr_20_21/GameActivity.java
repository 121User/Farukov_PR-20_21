package com.example.farukov_pr_20_21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_game);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public boolean Started = false;
    public boolean Finished = false;

    public void Start(View view){
        View semafor = (View)findViewById(R.id.Semafor);
        Button button = (Button)findViewById(R.id.btnStart);
        if(!Finished){
            if(!Started){
                semafor.setBackgroundColor(0xff008000); //green
                button.setText("Pause");
                Started = true;
            }
            else if(Started){
                semafor.setBackgroundColor(0xfff00000); //red
                button.setText("Start");
                Started = false;
            }
        }
        else{
            Intent intent=new Intent(GameActivity.this, GameActivity.class);
            startActivity(intent);
        }
    }

    public void Drive1(View view) {
        Button button = (Button)findViewById(R.id.btnStart);
        View myCar = (View)findViewById(R.id.imageCar1);
        if(!Finished){
            if(Started){
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)myCar.getLayoutParams();
                margin.leftMargin += 50;
                margin.rightMargin -= 50;
                myCar.requestLayout();
                if(margin.rightMargin <= -200){
                    TextView result = (TextView)findViewById(R.id.tvResult);
                    result.setText("Victory 1 player");
                    button.setText("Again");
                    result.setTextColor(0xffe91E63);
                    Finished = true;
                }
            }
        }
    }

    public void Drive2(View view) {
        Button button = (Button)findViewById(R.id.btnStart);
        View myCar = (View)findViewById(R.id.imageCar2);
        if(!Finished){
            if(Started){
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)myCar.getLayoutParams();
                margin.leftMargin += 50;
                margin.rightMargin -= 50;
                myCar.requestLayout();
                if(margin.rightMargin <= -200){
                    TextView result = (TextView)findViewById(R.id.tvResult);
                    result.setText("Victory 2 player");
                    button.setText("Again");
                    result.setTextColor(0xfff00000);
                    Finished = true;
                }
            }
        }
    }
}