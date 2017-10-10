package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities.ComplaintActivity;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities.ProfileActivity;
import com.example.ast.carwash_nadeemahmed.R;

/**
 * Created by AST on 9/15/2017.
 */

public class Add_Appartment extends android.support.v4.app.Fragment {
    public static TextView ActionBartitle;
    public ImageView back_arrow,add_segment;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_appartment,null);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_outside);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(0, android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);
        back_arrow = (ImageView)toolbar.findViewById(R.id.back_image);
        add_segment = (ImageView)view.findViewById(R.id.add_segment);
        ActionBartitle = (TextView) toolbar.findViewById(R.id.main_appbar_textView);
        ActionBartitle.setText("Add Apartment");

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_right, R.anim.slide_out_right, R.anim.slide_left, R.anim.slide_out_left)
                        .addToBackStack(null)
                        .replace(R.id.profile_container, new Owner_Home()).commit();
            }
        });

        add_segment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_right, R.anim.slide_out_right, R.anim.slide_left, R.anim.slide_out_left)
                        .addToBackStack(null)
                        .replace(R.id.profile_container, new AddSegment()).commit();
            }
        });
        return view;
    }
}
