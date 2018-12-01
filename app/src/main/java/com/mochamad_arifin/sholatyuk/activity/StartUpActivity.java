package com.mochamad_arifin.sholatyuk.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.mochamad_arifin.sholatyuk.R;

/**
 * Created by mochamad arifin on 24/11/2018.
 * github   :   https://github.com/flasharifin
 * linkedin :   https://www.linkedin.com/in/mochamad-arifin-13554112b/
 */

public class StartUpActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Thread t;
    private boolean stop = false;

    private int progressStatus;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        animload();
    }

    private void animload(){
        progressStatus = 0;

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus < 100){
                    progressStatus += 1;

                    try{
                        //miliseconds
                        Thread.sleep(100);//500
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            if(!stop){
//                                stop = true;
                                progressBar.setProgress(progressStatus);

                                if(progressStatus == 100){
                                    stop = true;
                                    progressBar.setProgress(progressStatus);
                                    Intent intent = new Intent(StartUpActivity.this, SignInActivity.class);
                                    startActivity(intent);
                                    overridePendingTransition(R.transition.fadein, R.transition.fadeout);
                                }
                            }

                        }

                    });

                }
            }

        });
        t.start();

    }
}
