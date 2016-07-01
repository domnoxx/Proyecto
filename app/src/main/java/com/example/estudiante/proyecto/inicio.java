package com.example.estudiante.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class inicio extends Activity {
    public static final int segundos =8;
    public static final int mils= segundos*1000;
    public static final int delay = 2;
    private ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            setContentView(R.layout.activity_inicio);
            animacion();
            pbar= (ProgressBar)findViewById(R.id.pBar);
            pbar.setMax(maxProgreso());

            //Thread timerThread = new Thread(){
            //    public void run(){
            //          try{
            //            sleep(4000);
            //         }catch(InterruptedException e){
            //             e.printStackTrace();
            //          }finally{
            //             Intent intent = new Intent(inicio.this, pantallaInicio.class);
            //              startActivity(intent);
            //         }
            //      }
            //    };
            //     timerThread.start();
        }

    public void animacion() {
        new CountDownTimer(mils,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                pbar.setProgress(progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent i=new Intent(inicio.this,menu.class);
                startActivity(i);
            }
        }.start();
    }

    public int progreso(long miliseconds){
        return(int)(mils-miliseconds)/1000;
    }
    public int maxProgreso(){
        return segundos-delay;
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }


}