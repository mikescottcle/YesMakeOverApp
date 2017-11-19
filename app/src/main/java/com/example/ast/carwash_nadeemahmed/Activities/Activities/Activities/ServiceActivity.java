package com.example.ast.carwash_nadeemahmed.Activities.Activities.Activities;

import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.ast.carwash_nadeemahmed.Activities.Activities.Adapters.Navigations_ItemsAdapter;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Add_Customer;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Change_Password;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.CustomerList_Fragment;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Send_Message;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Service_Details_onRegular;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Service_Regular_Fragment;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.UI.Terms_and_Condition;
import com.example.ast.carwash_nadeemahmed.Activities.Activities.Utils.AppLogs;
import com.example.ast.carwash_nadeemahmed.R;

public class ServiceActivity extends AppCompatActivity {

   public static ServiceActivity serviceActivity;
    public DrawerLayout drawer_layout;
    public ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    public String[] menuName= {"Change Password","Terms & Conditions","Send Messages","Add Customer","Pay Bill Online"};
    public int[] menuIcons = {R.mipmap.change_password,R.mipmap.menu_terms_and_conditions,R.mipmap.send_message,R.mipmap.add_customer,R.mipmap.pay_bill};
    public FrameLayout service_container;



    public static ServiceActivity getInstance(){
        return serviceActivity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            Window window = ServiceActivity.this.getWindow();
            window.setStatusBarColor(ContextCompat.getColor(ServiceActivity.this, R.color.colorWhite));

//            mayRequestContacts();
//
        }
        serviceActivity = this;
        service_container = (FrameLayout)findViewById(R.id.service_container);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        View viewinflate = ServiceActivity.this.getLayoutInflater().inflate(R.layout.nav_header_main,null);
        drawer_layout = (DrawerLayout)findViewById(R.id.drawer_layout);

        Navigations_ItemsAdapter navigations_itemsAdapter = new Navigations_ItemsAdapter(ServiceActivity.this,menuName,menuIcons);
        mDrawerList.setAdapter(navigations_itemsAdapter);
        mDrawerList.addHeaderView(viewinflate);

        mDrawerToggle = new ActionBarDrawerToggle(ServiceActivity.this, drawer_layout,null, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                service_container.setTranslationX(slideOffset * drawerView.getWidth());
                drawer_layout.bringChildToFront(drawerView);
                drawer_layout.requestLayout();
            }
        };
        drawer_layout.setDrawerListener(mDrawerToggle);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction();
        //     .setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
      //  transaction.addToBackStack(null);
        transaction.add(R.id.service_container, new Service_Regular_Fragment());
        transaction.commit();

        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                            .addToBackStack(null)
                            .add(R.id.service_container, new Change_Password()).commit();

                    drawer_layout.closeDrawer(mDrawerList);
                }

                if(i==2){
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                            .addToBackStack(null)
                            .add(R.id.service_container, new Terms_and_Condition()).commit();

                    drawer_layout.closeDrawer(mDrawerList);
                }
                if(i==4){
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                            .addToBackStack(null)
                            .add(R.id.service_container, new Add_Customer()).commit();

                    drawer_layout.closeDrawer(mDrawerList);
                }
                if(i==3){
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.slide_left, R.anim.slide_out_left, R.anim.slide_right, R.anim.slide_out_right)
                            .addToBackStack(null)
                            .add(R.id.service_container, new Send_Message()).commit();

                    drawer_layout.closeDrawer(mDrawerList);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AppLogs.d("TAG",getSupportFragmentManager().getBackStackEntryCount()+"");


    }
}
