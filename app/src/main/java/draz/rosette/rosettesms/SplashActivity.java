package draz.rosette.rosettesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import draz.rosette.rosettesms.data.MyMessage;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        MyThread myThread=new MyThread();
        myThread.start();
        super.onResume();
    }

    public class MyThread extends Thread
    {
        @Override
        public void run() {
            try {
                sleep(3000);
                Intent i=new Intent(getApplicationContext(), MessageMangerActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
