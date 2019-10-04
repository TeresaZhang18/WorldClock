package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Button button24;
    Button button12;

    String format="HH:mm:ss";

    CheckBox checkSydney;
    CheckBox checkShanghai;
    CheckBox checkLondon;
    CheckBox checkTokyo;
    CheckBox checkNY;
    CheckBox checkParis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextAndPicture();

        button24 = findViewById(R.id.hour24BTN);
        button12 = findViewById(R.id.hour12BTN);

        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                format="HH:mm:ss";
                setTextAndPicture();
            }
        });

        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                format="hh:mm:ss a";
                setTextAndPicture();
            }
        });

        Thread running = new Thread(){

            public void run(){
                try {
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        setTextAndPicture();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        running.start();

        hide();

    }



    public void setTextAndPicture(){

        String[] cityArray = {"sydney","shanghai","london","tokyo","ny","paris"};

        String[] timeArray = {"Australia/Sydney","GMT+8","Europe/London","Japan","America/New_York","Europe/Paris"};

        for (int i=0; i<cityArray.length; i++){
            String city = cityArray[i];
            int cityID = this.getResources().getIdentifier(city,"id", this.getPackageName());
            int cityString = this.getResources().getIdentifier(city, "string", this.getPackageName());
            int cityDrawable = this.getResources().getIdentifier(city,"drawable", this.getPackageName());

            LinearLayout cityClock = findViewById(cityID);
            TextView cityText = cityClock.findViewById(R.id.cityText);
            cityText.setText(cityString);
            ImageView cityImage = cityClock.findViewById(R.id.cityImage);
            cityImage.setImageResource(cityDrawable);

            String time = timeArray[i];
            Date myDate = new Date();
            DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
            dateformat.setTimeZone(TimeZone.getTimeZone(time));


            DateFormat timeformat = new SimpleDateFormat(format);
            timeformat.setTimeZone(TimeZone.getTimeZone(time));

            TextView cityDate = cityClock.findViewById(R.id.dateText);
            cityDate.setText(dateformat.format(myDate));

            TextView cityTime = cityClock.findViewById(R.id.timeText);
            cityTime.setText(timeformat.format(myDate));
        }

    }


    public void hide(){
        checkSydney = findViewById(R.id.checkSydney);
        checkSydney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSydney.isChecked()){
                    LinearLayout view = findViewById(R.id.sydney);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.sydney);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        checkShanghai = findViewById(R.id.checkShanghai);
        checkShanghai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkShanghai.isChecked()){
                    LinearLayout view = findViewById(R.id.shanghai);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.shanghai);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        checkLondon = findViewById(R.id.checkLondon);
        checkLondon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLondon.isChecked()){
                    LinearLayout view = findViewById(R.id.london);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.london);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        checkTokyo = findViewById(R.id.checkTokyo);
        checkTokyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkTokyo.isChecked()){
                    LinearLayout view = findViewById(R.id.tokyo);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.tokyo);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        checkNY = findViewById(R.id.checkNY);
        checkNY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkNY.isChecked()){
                    LinearLayout view = findViewById(R.id.ny);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.ny);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });

        checkParis = findViewById(R.id.checkParis);
        checkParis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkParis.isChecked()){
                    LinearLayout view = findViewById(R.id.paris);
                    view.setVisibility(View.GONE);
                } else {
                    LinearLayout view = findViewById(R.id.paris);
                    view.setVisibility(View.VISIBLE);
                }
            }
        });
    }




}
