package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities.CustomerActivity;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities.MainActivity;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Add_Customer_Object;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Subscription;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Utils.FirebaseHandler;
import com.example.ast.carwash_nadeemahmed.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by AST on 9/16/2017.
 */

public class Add_Customer extends android.support.v4.app.Fragment {

    public LinearLayout add_subscription;

    public static TextView ActionBartitle;
    public Button add_customer_btn;
    public ImageView back_arrow;
    public EditText customer_name, customer_flat, customer_parking_slot_not, customer_mobile, customer_email;
    public Spinner spiner_apartment, spinner_block, customer_parking_spinner;

    public String apartmentName[] = {"Swan Lakes", "Eden Gardens", "Aparment 3", "Aparment 4", "Aparment 5", "Aparment 6", "Aparment 7"
            , "Aparment 8", "Aparment 9", "Aparment 10"};
    public String blockName[] = {"Tower 1", "Tower 2", "Tower 3", "Tower 4", "Tower 5", "Tower 6", "Tower 7", "Tower 8", "Tower 9", "Tower 10"};
    public String parkingName[] = {"Basement 1", "Basement 2", "Basement 3", "Basement 4", "Basement 5", "Basement 6", "Basement 7", "Basement 8"
            , "Basement 9", "Basement 10"};
    ArrayAdapter<String> adapterApartmentName;
    ArrayAdapter<String> adapterBlockName;
    ArrayAdapter<String> adapterParkingName;
    public Subscription subscription;
    public Add_Customer_Object add_customer_object;
    public TextView vehicle_make,vehicle_regNo;
    DatabaseReference reference;
    public String key;
   // Add_Customer_Object add_customer_object;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_customer, null);

        initializeView(view);
        initializeAdapters();
       reference = FirebaseHandler.getInstance().getAdd_customer().push();
        key = reference.getKey();
        if (getArguments() != null) {
            if (getArguments().getParcelable("object") != null) {
                add_customer_object = getArguments().getParcelable("object");
                subscription = add_customer_object.getSubscription();
                customer_name.setText(add_customer_object.getCust_name());
                customer_flat.setText(add_customer_object.getCust_flat());
                customer_email.setText(add_customer_object.getCust_email());
                customer_parking_slot_not.setText(add_customer_object.getCust_parking_slot());
                customer_mobile.setText(add_customer_object.getCust_mobile());
                customer_parking_spinner.setSelection(adapterParkingName.getPosition(add_customer_object.getCust_parking()));
                spinner_block.setSelection(adapterBlockName.getPosition(add_customer_object.getCust_block()));
                spiner_apartment.setSelection(adapterApartmentName.getPosition(add_customer_object.getCust_apartment()));
                vehicle_make.setText(add_customer_object.getSubscription().getVehicle_make());
                vehicle_regNo.setText(add_customer_object.getSubscription().getVehicle_Reg_no());
                key = add_customer_object.getCust_Uid().toString();
            }


        }

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerActivity.getInstance().onBackPressed();

            }
        });


        add_subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add_Subscription add_subscription = new Add_Subscription();
              //  if (add_customer_object!=null) {
                    add_customer_object = new Add_Customer_Object(
                            customer_name.getText().toString(), customer_mobile.getText().toString(),
                            spiner_apartment.getSelectedItem().toString(), customer_parking_slot_not.getText().toString(),
                            spinner_block.getSelectedItem().toString(), customer_email.getText().toString(), customer_flat.getText().toString()
                            , customer_parking_spinner.getSelectedItem().toString(), subscription, key, ""
                    );
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("object",add_customer_object);
                    add_subscription.setArguments(bundle);
             //   }
                getFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                        .addToBackStack(null)
                        .replace(R.id.customer_container, add_subscription).commit();


            }
        });

        add_customer_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (subscription != null) {
                    if (customer_name.getText().toString().equals("")) {
                        Snackbar.make(view, "Add customer_name First", Snackbar.LENGTH_LONG).show();
                    } else if (customer_mobile.getText().toString().equals("")) {
                        Snackbar.make(view, "Add customer_mobile First", Snackbar.LENGTH_LONG).show();
                    } else if (customer_parking_slot_not.getText().toString().equals("")) {
                        Snackbar.make(view, "Add customer_parking_slot_not First", Snackbar.LENGTH_LONG).show();
                    } else if (customer_email.getText().toString().equals("")) {
                        Snackbar.make(view, "Add customer_email First", Snackbar.LENGTH_LONG).show();
                    } else if (customer_flat.getText().toString().equals("")) {
                        Snackbar.make(view, "Add customer_flat First", Snackbar.LENGTH_LONG).show();
                    } else {
                          add_customer_object = new Add_Customer_Object(
                                customer_name.getText().toString(), customer_mobile.getText().toString(),
                                spiner_apartment.getSelectedItem().toString(), customer_parking_slot_not.getText().toString(),
                                spinner_block.getSelectedItem().toString(), customer_email.getText().toString(), customer_flat.getText().toString()
                                , customer_parking_spinner.getSelectedItem().toString(), subscription, key, ""
                        );


                        FirebaseHandler.getInstance().getAdd_customer()
                                .child(key)
                                .setValue(add_customer_object, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        Customer_Detail customer_detail = new Customer_Detail();
                                        Bundle bundle = new Bundle();
                                        bundle.putParcelable("object", add_customer_object);
                                        customer_detail.setArguments(bundle);
                                        getFragmentManager().beginTransaction()
                                                .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                                                //   .addToBackStack(null)
                                                .replace(R.id.customer_container, customer_detail).commit();
                                    }
                                });


                    }
                } else {
                    Snackbar.make(view, "Add Subscription First", Snackbar.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }


    public void initializeAdapters() {
        adapterApartmentName = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, apartmentName);

        adapterBlockName = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, blockName);

        adapterParkingName = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_spinner_item, parkingName);


        spiner_apartment.setAdapter(adapterApartmentName);
        spinner_block.setAdapter(adapterBlockName);
        customer_parking_spinner.setAdapter(adapterParkingName);
    }

    private void initializeView(View view) {
        add_subscription = (LinearLayout) view.findViewById(R.id.add_subscription);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_outside);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(0, android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);

        ActionBartitle = (TextView) toolbar.findViewById(R.id.main_appbar_textView);
        ActionBartitle.setText("Add Customers");
        add_customer_btn = (Button) view.findViewById(R.id.add_customer_btn);
        customer_name = (EditText) view.findViewById(R.id.customer_name);
        customer_flat = (EditText) view.findViewById(R.id.customer_flat);
        customer_parking_slot_not = (EditText) view.findViewById(R.id.customer_parking_slot_not);
        customer_mobile = (EditText) view.findViewById(R.id.customer_mobile);
        customer_email = (EditText) view.findViewById(R.id.customer_email);
        spiner_apartment = (Spinner) view.findViewById(R.id.spiner_apartment);
        spinner_block = (Spinner) view.findViewById(R.id.spinner_block);
        customer_parking_spinner = (Spinner) view.findViewById(R.id.customer_parking_spinner);
        back_arrow = (ImageView) toolbar.findViewById(R.id.back_image);
        vehicle_make = (TextView)view.findViewById(R.id.vehicle_make);
        vehicle_regNo = (TextView)view.findViewById(R.id.vehicle_reg_no);
    }
}
