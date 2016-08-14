package com.mobee.prulifeagentplanner.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobee.prulifeagentplanner.Agent;

/**
 * Created by Kevin on 8/10/2016.
 */
public class UserModel {

    DatabaseReference userModelDatabase;

    public UserModel(){
        this.userModelDatabase = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public Agent getAgent(String agentID){
        return new Agent(agentID, "Kevin", "Uy", "Salanga", "kevincarlo.uy@gmail.com", Agent.AGENT_TYPE.AGENT, true);
    }
}
