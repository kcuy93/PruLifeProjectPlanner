package com.mobee.prulifeagentplanner;

import android.util.Log;

public class Login {

    private static final String TAG = "Login";

    private String m_email;
    private String m_password;

    Login(){
        Log.d(TAG, "Login constructor");
    }

    Login(String email, String password){
        m_email = email;
        m_password = password;
    }

    String getEmail()
    {
        return m_email;
    }

    String getPassword()
    {
        return m_password;
    }

    void setEmail(String email)
    {
        m_email = email;
    }

    void setPassword(String password)
    {
        m_password = password;
    }


}
