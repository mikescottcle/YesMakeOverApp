package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Add_Customer_Object;
import com.example.ast.carwash_nadeemahmed.R;

import org.w3c.dom.Text;

/**
 * Created by AST on 9/15/2017.
 */

public class Customer_Profile extends android.support.v4.app.Fragment {

    public TextView cust_name,cust_mob,cust_app,cust_block,cust_flat,cust_parking,cust_email;
    public Add_Customer_Object add_customer_object;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_profile,null);
        initView(view);

        if(getArguments()!=null){
            add_customer_object = getArguments().getParcelable("cust");
            cust_app.setText(add_customer_object.getCust_apartment());
            cust_block.setText(add_customer_object.getCust_block());
            cust_email.setText(add_customer_object.getCust_email());
            cust_flat.setText(add_customer_object.getCust_flat());
            cust_parking.setText(add_customer_object.getCust_parking());
            cust_name.setText(add_customer_object.getCust_name());
            cust_mob.setText(add_customer_object.getCust_mobile());
        }


        return view;
    }

    private void initView(View view) {
        cust_name = (TextView)view.findViewById(R.id.cust_name);
        cust_mob = (TextView)view.findViewById(R.id.cust_mob);
        cust_app = (TextView)view.findViewById(R.id.cust_app);
        cust_block = (TextView)view.findViewById(R.id.cust_block);
        cust_flat = (TextView)view.findViewById(R.id.cust_flat);
        cust_parking = (TextView)view.findViewById(R.id.cust_parking);
        cust_email = (TextView)view.findViewById(R.id.cust_email);
    }
}
