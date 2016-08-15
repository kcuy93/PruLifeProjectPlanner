package com.mobee.prulifeagentplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class RegisterActivityPresenter extends AppCompatActivity {

    private final static String TAG = "RegisterActivity";

    private RadioButton agent, unitManager;
    private EditText firstName, middleName, lastName, email, agentCode;
    private SearchView selectUM, selectBM;
    private Button submit;

    private String fName, mName, lName, emailAdd, BM, UM;
    private int aCode;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        agent = (RadioButton) findViewById(R.id.agentRadioButton);
        unitManager = (RadioButton) findViewById(R.id.umRadioButton);
        firstName = (EditText) findViewById(R.id.firstNameField);
        middleName = (EditText) findViewById(R.id.middleNameField);
        lastName = (EditText) findViewById(R.id.lastNameField);
        email = (EditText) findViewById(R.id.emailField);
        agentCode = (EditText) findViewById(R.id.agentCodeField);
        selectBM = (SearchView) findViewById(R.id.bmSearch);
        selectUM = (SearchView) findViewById(R.id.umSearch);
        submit = (Button) findViewById(R.id.submitButton);

        final RegisterModel registerModel = new RegisterModel();

        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agent.isChecked()){
                    Log.d(TAG, "Agent radio button clicked");
                    agent.setChecked(true);
                    unitManager.setChecked(false);
                }else{
                    agent.setChecked(false);
                    unitManager.setChecked(true);
                }
            }
        });

        unitManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(unitManager.isChecked()){
                    Log.d(TAG, "Unit Manager radio button clicked");
                    agent.setChecked(false);
                    unitManager.setChecked(true);
                }else{
                    agent.setChecked(true);
                    unitManager.setChecked(false);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fName = firstName.getText().toString();
                mName = middleName.getText().toString();
                lName = lastName.getText().toString();
                emailAdd = email.getText().toString();
                aCode = Integer.parseInt(agentCode.getText().toString());
                BM = selectBM.getQuery().toString();
                UM = selectUM.getQuery().toString();
                if(validateInformation(fName, mName, lName, emailAdd, aCode, BM, UM)){
                    registerModel.Register(fName, mName, lName, emailAdd, aCode, BM, UM, new RegisterModel.RegisterListener(){
                        @Override
                        public void onSuccess() {
                            Toast.makeText(RegisterActivityPresenter.this, "login.setOnClickListener successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivityPresenter.this, TeamSummaryActivity.class);
                            startActivity(intent);
                        }
                        @Override
                        public void onFail() {
                            Log.d(TAG, "submit.setOnClickListener failed");
                            Toast.makeText(RegisterActivityPresenter.this, "Register failed.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }

    public boolean validateInformation(String fName, String mName, String lName, String emailAdd, int aCode, String BM, String UM){
        boolean valid = true;

        if(TextUtils.isEmpty(fName) && TextUtils.isEmpty(mName) && TextUtils.isEmpty(lName) && TextUtils.isEmpty(emailAdd) && TextUtils.isEmpty(String.valueOf(aCode)) && TextUtils.isEmpty(BM) && TextUtils.isEmpty(UM))
        {
            firstName.setError("Required");
            middleName.setError("Required");
            lastName.setError("Required");
            email.setError("Required");
            agentCode.setError("Required");
            valid = false;
        }else if(fName.length() > 50 && mName.length() > 50 && lName.length() > 50 && emailAdd.length() > 50 && String.valueOf(aCode).length() > 8){
            Toast.makeText(RegisterActivityPresenter.this, "Fields should not exceed 50 characters", Toast.LENGTH_LONG).show();
            valid = false;
        }

        return valid;
    }
}
