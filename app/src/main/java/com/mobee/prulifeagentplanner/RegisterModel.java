package com.mobee.prulifeagentplanner;


import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Ristel on 14/08/2016.
 */
public class RegisterModel {

    private static final String TAG = "RegisterModel";

    public interface RegisterListener{
        void onSuccess();
        void onFail();
    }

    DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;


    RegisterModel(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
            Log.d(TAG, "User: " + firebaseUser.getUid() + "signed in.");

        }else{
            Log.d(TAG, "User: " + firebaseUser.getUid() + "sign in failed.");
        }
    }

    public void onStart() {
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop() {
        if (firebaseAuth != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void Register(final String firstName, final String middleName, final String lastName, final String email, final int agentCode, final String BM, final String UM, RegisterListener registerListener){

    }

}
