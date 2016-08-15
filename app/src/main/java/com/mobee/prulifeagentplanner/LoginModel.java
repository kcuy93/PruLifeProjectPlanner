package com.mobee.prulifeagentplanner;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginModel {

    private static final String TAG = "LoginModel";

    public interface LoginListener{
        void onLoginSuccess();
        void onLoginFail();
    }

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    LoginListener mLoginListener;

    LoginModel(){
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:USER: " + user.getUid() + "signed in.");
                    mLoginListener.onLoginSuccess();
                } else {
                    Log.d(TAG, "onAuthStateChanged:User logged out.");
                }
            }
        };
    }

    public void login(final String emailAddress, final String password, LoginListener loginListener) {

        mLoginListener = loginListener;
        mAuth.signInWithEmailAndPassword(emailAddress, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful())
                {
                    mLoginListener.onLoginFail();
                }
                else
                {
                    mLoginListener.onLoginSuccess();
                }
            }
        });
    }


    public void onStart() {
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void onStop() {
        if (mAuth != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
