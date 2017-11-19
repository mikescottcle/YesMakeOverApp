package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Apartment;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Model.Segment;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Utils.FirebaseHandler;
import com.example.ast.carwash_nadeemahmed.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by AST on 9/15/2017.
 */

public class AddSegment extends android.support.v4.app.Fragment {

    public static TextView ActionBartitle;
    public ImageView back_arrow;
    public Spinner segment_service,segment_number,segment_vehicle_type;
    public EditText segment_name;
    public EditText segment_cost;
    //Daily, Weekly, Monthly, Twice Monthly &  Once
    public String numbersDay[] = {"Daily","Weekly","Monthly","Twice Monthly","Once"};
    public ArrayAdapter<String> numberDaysAdapter;
    public String segment_service_array[] = {"Interior Detailing","Exterior Detailing","Washing","Mopping"};
    public ArrayAdapter<String> segment_service_adapter;
    public String segment_vehicle_type_array[] = {"Small Car","Mid/Premium Car","Suv","Bike"};
    public ArrayAdapter<String> segment_vehicle_type_adapter;
    public Button save_segment;
    public ArrayList<Segment> segmentArrayList;
    public Apartment segmentObject;
//    public DatabaseReference reference;
       public String key;
       public Segment segment;
       public String segmentkey = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.add_segment_view,null);
        initializeView(view);


        if (getArguments() != null) {
            if(getArguments().getParcelable("object") !=null) {
                segmentObject = getArguments().getParcelable("object");
                key = segmentObject.getApartmentUid();
            }
      //      add_apart_name.setText(segmentObject.getApartmentName());
            if (getArguments().getParcelable("segment") != null) {
               // if (segmentObject.getSegmentArrayList().size() > 0) {
                  //  segment.add(segmentObject.getSegmentArrayList().get(0));
          //          container_seg.setVisibility(View.VISIBLE);
                    segment = getArguments().getParcelable("segment");
                    segment_cost.setText(segment.getSegment_cost());
                 //   segment_vehicle_type.setText(segment.getVehicle_type());
                  //  segment_service.setText(segment.getService_type());
                    segment_name.setText(segment.getSegmentName());
                segment_vehicle_type.setSelection(segment_vehicle_type_adapter.getPosition(segment.getVehicle_type()));
                segment_service.setSelection(segment_service_adapter.getPosition(segment.getService_type()));
                segment_number.setSelection(numberDaysAdapter.getPosition(segment.getServiceNumber()));
                segmentkey = segment.getSegment_UID();
                 //   segment_number.set(segment.getServiceNumber());

             //   }
            }
        }


        segment_number.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //   ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLUE);
                if (adapterView.getChildAt(0) != null) {
                    ((TextView) adapterView.getChildAt(0)).setTextSize(10);
                    ((TextView) adapterView.getChildAt(0)).setTypeface(null, Typeface.BOLD);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        segment_vehicle_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getChildAt(0) != null) {
                    ((TextView) adapterView.getChildAt(0)).setTextSize(10);
                    ((TextView) adapterView.getChildAt(0)).setTypeface(null, Typeface.BOLD);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        segment_service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adapterView.getChildAt(0) != null) {
                    ((TextView) adapterView.getChildAt(0)).setTextSize(10);
                    ((TextView) adapterView.getChildAt(0)).setTypeface(null, Typeface.BOLD);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });


        save_segment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(segment_name.getText().toString().equals("")){
                    Snackbar.make(view,"Fill required fields",Snackbar.LENGTH_SHORT).show();
                }else{
                    save_segment.setEnabled(false);
                 //   Apartment segment = new Apartment();
                  //  segmentArrayList.add(
                final Segment segment;
                DatabaseReference databaseReference;

                    if(segmentkey.equals("")) {

                         databaseReference = FirebaseHandler.getInstance().getAppartment_segments()
                                .child(key).push();
                         segment = new Segment(segment_name.getText().toString(),
                                segment_number.getSelectedItem().toString(),
                                segment_service.getSelectedItem().toString(),
                                segment_vehicle_type.getSelectedItem().toString(),
                                segment_cost.getText().toString(),databaseReference.getKey(),key);
                    }else{
                        segment = new Segment(segment_name.getText().toString(),
                                segment_number.getSelectedItem().toString(),
                                segment_service.getSelectedItem().toString(),
                                segment_vehicle_type.getSelectedItem().toString(),
                                segment_cost.getText().toString(),segmentkey,key);

                        databaseReference = FirebaseHandler.getInstance().getAppartment_segments()
                                .child(key).child(segmentkey);

                    }


                        //   segmentObject.setSegmentArrayList(segmentArrayList);

                    databaseReference.setValue(segment, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            Add_Appartment add_appartment = new Add_Appartment();
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("object",segmentObject);
                            bundle.putParcelable("segment",segment);
                            add_appartment.setArguments(bundle);
                      //      getActivity().getSupportFragmentManager().popBackStack();
                            getActivity().getSupportFragmentManager().beginTransaction()
                                    .setCustomAnimations(R.anim.slide_right, R.anim.slide_out_right, R.anim.slide_left, R.anim.slide_out_left)
                                    .addToBackStack(null)
                                    .replace(R.id.profile_container,add_appartment).commit();
                        }
                    });




                }





            }
        });

        return view;
    }

    private void initializeView(View view) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_outside);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayOptions(0, android.support.v7.app.ActionBar.DISPLAY_SHOW_TITLE);

        ActionBartitle = (TextView) toolbar.findViewById(R.id.main_appbar_textView);
        ActionBartitle.setText("Add Segment");
        back_arrow = (ImageView)toolbar.findViewById(R.id.back_image);
        segment_name = (EditText)view.findViewById(R.id.segment_name);
        segment_number = (Spinner)view.findViewById(R.id.segment_number);
        segment_service = (Spinner)view.findViewById(R.id.segment_service);
        segment_vehicle_type = (Spinner)view.findViewById(R.id.segment_vehicle_type);
        segment_cost = (EditText)view.findViewById(R.id.segment_cost);
        save_segment = (Button)view.findViewById(R.id.save_segment);
        segmentArrayList = new ArrayList<>();
        numberDaysAdapter = new ArrayAdapter<String>(getActivity(),R.layout.segment_custom_spinner_text,numbersDay);
        segment_number.setAdapter(numberDaysAdapter);

        segment_service_adapter = new ArrayAdapter<String>(getActivity(),R.layout.segment_custom_spinner_text,segment_service_array);
        segment_service.setAdapter(segment_service_adapter);

        segment_vehicle_type_adapter = new ArrayAdapter<String>(getActivity(),R.layout.segment_custom_spinner_text,segment_vehicle_type_array);
        segment_vehicle_type.setAdapter(segment_vehicle_type_adapter);

        segment_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    hideKeyboard(view);
                }
            }
        });

    }
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
