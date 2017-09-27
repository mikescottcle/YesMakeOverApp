package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities.MainActivity;
import com.example.ast.carwash_nadeemahmed.R;

/**
 * Created by AST on 9/22/2017.
 */

public class Send_Message extends android.support.v4.app.Fragment {
    public static TextView ActionBartitle;
    public ImageView back_arrow;
    public Button send_message;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.send_message,null);

        Toolbar toolbar= (Toolbar)view.findViewById(R.id.toolbar_outside);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(0, android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);

        ActionBartitle = (TextView)toolbar.findViewById(R.id.main_appbar_textView);
        ActionBartitle.setText("Send Message");


        back_arrow = (ImageView) toolbar.findViewById(R.id.back_image);
        send_message = (Button)view.findViewById(R.id.send_message);

        send_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(getActivity().getSupportFragmentManager().findFragmentById(R.id.container_main) != null) {
//                    getActivity().getSupportFragmentManager()
//                            .beginTransaction().
//                            remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.container_main)).commit();
//                }

                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                        .addToBackStack(null)
                        .add(R.id.container_main, new Message_Fragment()).commit();


            }
        });

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.getInstance().onBackPressed();
            }
        });

        return view;
    }
}
