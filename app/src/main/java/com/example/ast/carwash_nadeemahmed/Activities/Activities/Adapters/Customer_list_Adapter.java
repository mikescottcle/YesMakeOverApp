package com.example.ast.carwash_nadeemahmed.Activities.Activities.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Add_Customer_Object;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.UserModel;
import com.example.ast.carwash_nadeemahmed.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by AST on 10/9/2017.
 */

public class Customer_list_Adapter extends BaseAdapter {

    public ArrayList<Add_Customer_Object> userModels;
    public Context mContext;

    public Customer_list_Adapter(ArrayList<Add_Customer_Object> userModels, Context mContext) {
        this.userModels = userModels;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return userModels.size();
    }

    @Override
    public Object getItem(int i) {
        return userModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vieww = layoutInflater.inflate(R.layout.cust_list_adapter,null);

        CircleImageView cust_adapter_image = (CircleImageView)vieww.findViewById(R.id.cust_adapter_image);
        TextView cust_adapter_user_name = (TextView)vieww.findViewById(R.id.cust_adapter_name);
        TextView cust_adapter_user_app = (TextView)vieww.findViewById(R.id.cust_adapter_app_name);
        TextView cust_adapter_rupee = (TextView)vieww.findViewById(R.id.cust_rupee_adapter);
        TextView cust_adapter_block = (TextView)vieww.findViewById(R.id.cust_adapter_block);

        Add_Customer_Object add_customer_object = userModels.get(i);


        Glide.with(mContext).load(add_customer_object.getCust_imagUrl()).placeholder(R.drawable.user).fitCenter().into(cust_adapter_image);
        cust_adapter_block.setText(add_customer_object.getCust_block());
        cust_adapter_rupee.setText("$700");
        cust_adapter_user_app.setText(add_customer_object.getCust_apartment());
        cust_adapter_user_name.setText(add_customer_object.getCust_name());



        return vieww;
    }
}
