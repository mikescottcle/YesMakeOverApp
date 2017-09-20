package com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.ast.carwash_nadeemahmed.R;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);


        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.TRANSPARENT);

//            mayRequestContacts();
//
        }


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                            // User is signed out
                            Intent intent = new Intent(Splash_Activity.this,LoginActivity.class);
                            overridePendingTransition(R.anim.slide_down,R.anim.slide_up);
                            startActivity(intent);
                            finish();

            }
        }, 3000);
    }
}
