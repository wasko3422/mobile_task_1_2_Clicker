package com.example.mobile_task_1_2_clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainBtn;
    Button subtarctBtn;
    Button resetBtn;


    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainText);
        mainBtn = (Button) findViewById(R.id.button);
        subtarctBtn = (Button) findViewById(R.id.subbutton);
        resetBtn = (Button) findViewById(R.id.reset);


        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score++;
                String s = "Кликов: " + forms(score);
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };
        mainBtn.setOnClickListener(clickListener);


        View.OnClickListener clickListener1 = new View.OnClickListener(){
            @Override
            public void onClick(View V){
                score--;
                String s = "Кликов: " + forms(score);
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };
        subtarctBtn.setOnClickListener(clickListener1);

        View.OnClickListener clickListener2 = new View.OnClickListener(){
            @Override
            public void onClick(View V){
                score = 0;
                String s = "Кликов: " + forms(score);
                mainText.setText(s.toCharArray(),0, s.length());
            }
        };
        resetBtn.setOnClickListener(clickListener2);

    }

    protected String forms(int number){
        int ostatok = Math.abs(number) % 10;

        switch (ostatok){
            case 2:
            case 3:
            case 4:
                return number + "раза";
            default: return number + "раз";

        }
    }
}

