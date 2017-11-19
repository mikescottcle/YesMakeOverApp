package com.example.ast.carwash_nadeemahmed.Activities.Activities.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Apartment;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Block;
import com.example.ast.carwash_nadeemahmed.R;

import java.util.ArrayList;

/**
 * Created by AST on 11/14/2017.
 */

public class SuperVisor_ApartmentAdapter extends ArrayAdapter<Apartment> {

    public ArrayList<Apartment> blockArrayList;
    public Context context;

    public SuperVisor_ApartmentAdapter(@NonNull Context context, ArrayList<Apartment> blockArrayList) {
        super(context, 0);
        this.context = context;
        this.blockArrayList = blockArrayList;
    }

    @Override
    public int getCount() {
        return blockArrayList.size();
    }

    @Nullable
    @Override
    public Apartment getItem(int position) {
        return blockArrayList.get(position);
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.supervisor_block, null);
        TextView text1 = (TextView) view.findViewById(R.id.text1);
        text1.setTag(blockArrayList.get(position));
        text1.setText(blockArrayList.get(position).getApartmentName());

        return view;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return createItemView(position, convertView, parent);
    }
}
