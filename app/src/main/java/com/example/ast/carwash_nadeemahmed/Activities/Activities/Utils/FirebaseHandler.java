package com.example.ast.carwash_nadeemahmed.Activities.Activities.Utils;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by Faiz on 7/25/2017.
 */

public class FirebaseHandler {
    private DatabaseReference usersRef;
    private DatabaseReference add_customer;
    private DatabaseReference user_takeit_post;
    private DatabaseReference user_takeit_or_leaveit_post;
    private DatabaseReference user_privacy;
    private static final String TAG = "FirebaseHandler";
    private static FirebaseHandler ourInstance;
    private DatabaseReference firebaseRef;
    private FirebaseAuth authData;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private StorageReference mfirebaseStorage;
    private DatabaseReference activities_seen_by_user;



    public static FirebaseHandler getInstance() {
        if (ourInstance == null) {
            AppLogs.d("rootRef", "" + FirebaseDatabase.getInstance().getReference());
            ourInstance = new FirebaseHandler();
        }
        return ourInstance;
    }

    private FirebaseHandler() {
        firebaseRef = FirebaseDatabase.getInstance().getReference();
        mfirebaseStorage = FirebaseStorage.getInstance().getReferenceFromUrl(String.valueOf(FirebaseStorage.getInstance().getReference()));
        initializeChildRefs();
    }

    //  DatabaseStorage
    public StorageReference getRootStorageRef() {
        return mfirebaseStorage;
    }

    //    DatabaseReference
    public DatabaseReference getRootFirebaseRef() {
        return firebaseRef;
    }

    private void initializeChildRefs() {
        usersRef = firebaseRef.child("users");
        add_customer = firebaseRef.child("customer");
        activities_seen_by_user = firebaseRef.child("activities-seen-by-user");
       // user_takeit_post = firebaseRef.child("user-takeit-post");
    }


    public DatabaseReference getUser_leaveit_post() {
        return user_takeit_or_leaveit_post;
    }

    public DatabaseReference getUsersRef() {
        return usersRef;
    }


    public DatabaseReference getAdd_customer() {
        return add_customer;
    }

    public void setAdd_customer(DatabaseReference add_customer) {
        this.add_customer = add_customer;
    }

    public DatabaseReference getUser_privacy() {
        return user_privacy;
    }

    public DatabaseReference getActivitiesSeenByUser() {

        return activities_seen_by_user;
    }
}
