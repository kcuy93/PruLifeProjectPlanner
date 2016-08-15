package com.mobee.prulifeagentplanner;

/**
 * Created by Ristel on 15/08/2016.
 */
public class User {

    String firstName, middleName, lastName, emailAddress, branchManager, unitManager;
    int agentCode;

    public User(){

    }

    public User(String firstName, String middleName, String lastName, String emailAddress, int agentCode, String branchManager, String unitManager){
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.agentCode = agentCode;
        this.branchManager = branchManager;
        this.unitManager = unitManager;
    }
}
