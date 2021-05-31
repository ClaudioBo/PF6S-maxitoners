package mx.itson.maxitoners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        SplashScreen algo = this;

        new Thread(new Runnable(){
            public void run() {
                SystemClock.sleep(2000);
                Intent intent = new Intent(algo, ProductosListActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();

    }




}