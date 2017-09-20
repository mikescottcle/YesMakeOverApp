package com.example.ast.carwash_nadeemahmed.Activities.Activities.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Adapters.Navigations_ItemsAdapter;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Adapters.OnSwipeTouchListener;
import com.example.ast.carwash_nadeemahmed.R;

/**
 * Created by AST on 9/13/2017.
 */

public class Customer_home  extends android.support.v4.app.Fragment  {

    public DrawerLayout drawer_layout;
    public ImageView navIcon;
    public ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    public RelativeLayout main_view;
    public String[] menuName= {"Change Password","Terms & Conditions","Send Messages","Add Customer","Pay Bill Online"};
    public int[] menuIcons = {R.mipmap.change_password,R.mipmap.menu_terms_and_conditions,R.mipmap.send_message,R.mipmap.add_customer,R.mipmap.pay_bill};



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.customer_home,null);

        drawer_layout = (DrawerLayout)view.findViewById(R.id.drawer_layout);
        navIcon = (ImageView)view.findViewById(R.id.nav_icon);
        mDrawerList = (ListView)view.findViewById(R.id.left_drawer);
        main_view = (RelativeLayout)view.findViewById(R.id.main_view);
        View viewinflate = inflater.inflate(R.layout.nav_header_main,null);
        Navigations_ItemsAdapter navigations_itemsAdapter = new Navigations_ItemsAdapter(getActivity(),menuName,menuIcons);
        mDrawerList.setAdapter(navigations_itemsAdapter);
        mDrawerList.addHeaderView(viewinflate);

        navIcon.setOnTouchListener(new OnSwipeTouchListener(getActivity())
        {
            @Override
            public void onTouch() {
                if(drawer_layout.isDrawerOpen(Gravity.LEFT))
                {
                    drawer_layout.closeDrawer(mDrawerList);
                    // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
                    // getSupportActionBar().setCustomView(R.layout.menu_title);
                    // getSupportActionBar().show();
                }
                else {
                    drawer_layout.openDrawer(Gravity.LEFT);
                    //getSupportActionBar().hide();
                    // requestWindowFeature(Window.FEATURE_NO_TITLE);
                }
            }
        });

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawer_layout,null, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                main_view.setTranslationX(slideOffset * drawerView.getWidth());
                drawer_layout.bringChildToFront(drawerView);
                drawer_layout.requestLayout();
            }
        };
        drawer_layout.setDrawerListener(mDrawerToggle);



        return view;


    }
}
