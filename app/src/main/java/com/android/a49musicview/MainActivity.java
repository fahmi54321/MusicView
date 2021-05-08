package com.android.a49musicview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import dyanamitechetan.vusikview.VusikView;

public class MainActivity extends AppCompatActivity {

    boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VusikView musikView = (VusikView) findViewById(R.id.musicView);
        Button btnPause = findViewById(R.id.btnPause);
        Button btnStop = findViewById(R.id.btnStop);
        findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musikView.start();
                musikView.startNotesFall();
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isPause){
                    musikView.pauseNotesFall();
                    btnPause.setText("Resume");
                }else{
                    musikView.resumeNotesFall();
                    btnPause.setText("Pause");
                }
                isPause = !isPause;
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musikView.stopNotesFall();
            }
        });

    }
}