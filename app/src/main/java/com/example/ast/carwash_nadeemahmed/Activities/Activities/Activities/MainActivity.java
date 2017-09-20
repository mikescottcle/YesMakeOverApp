package com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities;

import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Owner_Home;
import com.example.ast.carwash_nadeemahmed.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Window window = MainActivity.this.getWindow();
            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorWhite));

//            mayRequestContacts();
//
        }


        Owner_Home owner_home = new Owner_Home();


        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.container_main, owner_home);
        transaction.commit();



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Window window = MainActivity.this.getWindow();
            window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorWhite));

//            mayRequestContacts();
//
        }
    }
}