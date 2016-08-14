package com.mobee.prulifeagentplanner;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivityModel extends AppCompatActivity {

    private static final String TAG = "LoginActivityModel";
    boolean auth = false;
    boolean signIn = false;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public boolean login(final String emailAddress, final String password) {
        boolean loggedIn = false;
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:USER: " + user.getUid() + "signed in.");
                    auth = true;
                } else {
                    Log.d(TAG, "onAuthStateChanged:User logged out.");
                    auth = false;
                }
            }
        };

        mAuth.signInWithEmailAndPassword(emailAddress, password).addOnCompleteListener(LoginActivityModel.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d(TAG, "signInWithEmailAndPassword");
                if (!task.isSuccessful()) {
                    Log.w(TAG, "signIn:onComplete failed", task.getException());
                    Toast.makeText(LoginActivityModel.this, R.string.authFailed, Toast.LENGTH_SHORT).show();
                    signIn = false;
                } else {
                    Log.d(TAG, "signIn:onComplete successful: " + task.isSuccessful());
                    signIn = true;
                }
            }
        });

        if (auth || signIn) {
            loggedIn = true;
        }
        return loggedIn;
    }


    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);

    }

    public void onStop() {
        super.onStop();
        if (mAuth != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}
