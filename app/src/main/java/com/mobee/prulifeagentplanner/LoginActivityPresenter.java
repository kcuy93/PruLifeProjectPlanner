package com.mobee.prulifeagentplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivityPresenter extends AppCompatActivity {

    private static final String TAG = "LoginActivityPresenter";

    private EditText email, password;
    Button login;
    TextView register;

    private String emailAddress, passWord;
    LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.usernameField);
        password = (EditText) findViewById(R.id.passwordField);
        login = (Button) findViewById(R.id.loginButton);
        register = (TextView) findViewById(R.id.requestAccess);

        final LoginModel loginModel = new LoginModel();

        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                email.setHint(R.string.agentCode);
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                password.setHint("");
            }
        });

        /**
         * Upon clicking login button, email & password will be validated
         * when both email and password fields are validated
         * it will call login function in LoginModel and pass email & password
         * if login function returns true, login is successful
         * **/
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(validateEmail() && validatePassword()){
                    emailAddress = email.getText().toString();
                    passWord = password.getText().toString();
                    loginModel.login(emailAddress, passWord, new LoginModel.LoginListener() {
                        @Override
                        public void onLoginSuccess() {
                            Toast.makeText(LoginActivityPresenter.this, "login.setOnClickListener successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivityPresenter.this, RegisterActivityPresenter.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onLoginFail() {
                            Log.d(TAG, "login.setOnClickListener failed");
                            Toast.makeText(LoginActivityPresenter.this, "Login failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivityPresenter.this, RegisterActivityPresenter.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateEmail()
    {
        boolean valid = true;
        String emailAddress = email.getText().toString();
        if(TextUtils.isEmpty(emailAddress))
        {
            email.setError("Email required");
            valid = false;
        }

        return valid;
    }

    private boolean validatePassword()
    {
        boolean valid = true;
        String pass = password.getText().toString();
        if(TextUtils.isEmpty(pass))
        {
            password.setError("Password required");
            valid = false;
        }
        return valid;
    }
}
