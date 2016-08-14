package com.mobee.prulifeagentplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.gms.common.api.GoogleApiClient;

public class RegisterActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final RadioButton agent, unitManager;
        final EditText firstName, middleName, lastName, email, agentCode;
        final Spinner selectUM, selectBM;
        final Button submit;
        final String fName, mName, lName, emailAdd;
        final int aCode;

        agent = (RadioButton) findViewById(R.id.agentRadioButton);
        unitManager = (RadioButton) findViewById(R.id.umRadioButton);
        firstName = (EditText) findViewById(R.id.firstNameField);
        middleName = (EditText) findViewById(R.id.middleNameField);
        lastName = (EditText) findViewById(R.id.lastNameField);
        email = (EditText) findViewById(R.id.emailField);
        agentCode = (EditText) findViewById(R.id.agentCodeField);
        selectBM = (Spinner) findViewById(R.id.bmSpinner);
        selectUM = (Spinner) findViewById(R.id.umSpinner);
        submit = (Button) findViewById(R.id.submitButton);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (firstName.getText().toString().isEmpty() || middleName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || email.getText().toString().isEmpty() || agentCode.getText().toString().isEmpty()) {
                    submit.setEnabled(false);
                } else {
                    submit.setEnabled(true);
                }
            }
        };

        agent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(agent.isChecked()){
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
                    agent.setChecked(false);
                    unitManager.setChecked(true);
                }else{
                    agent.setChecked(true);
                    unitManager.setChecked(false);
                }
            }
        });

    }


}
