package com.mobee.prulifeagentplanner.model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 8/9/2016.
 */
public class AccountActivationModel {

    public interface GetPendingRequestListener{
        void onDataChange(List<String> pendingList);
        void onFail();
    }


    //constant strings for database child names
    private static String ACTIVATION_REQUEST_ROOT= "ActivationRequests";

    //get instance of database
    DatabaseReference activationReqeustNode;
    DatabaseReference prulifePlannerDatabase;
    String managerID;

    public AccountActivationModel(String managerID){
        this.prulifePlannerDatabase = FirebaseDatabase.getInstance().getReference();
        this.activationReqeustNode = prulifePlannerDatabase.child(ACTIVATION_REQUEST_ROOT);
        this.managerID = managerID;
    }

    public void requestActivation(String requesterID){
        activationReqeustNode.child(managerID).child(requesterID).setValue(false);
    }

    public void getPendingRequests(final GetPendingRequestListener listener){

        activationReqeustNode.child(managerID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<String> pendingList = new ArrayList<>();

                for(DataSnapshot x: dataSnapshot.getChildren()){
                    String pending = x.getKey();
                    pendingList.add(pending);
                }

                listener.onDataChange(pendingList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                listener.onFail();
            }
        });

    }

    public void acceptRequest(String requesterID){
        //change activation status of requester to activated
        prulifePlannerDatabase.child("Users").child(requesterID).child("agentStatus").setValue(true);

        //remove from pending list
        activationReqeustNode.child(managerID).child(requesterID).removeValue();
    }

    public void rejectRequest(String requesterID){
        //change activation status of requester to not activated
        prulifePlannerDatabase.child("Users").child(requesterID).child("agentStatus").setValue(false);

        //remove from pendinglist
        activationReqeustNode.child(managerID).child(requesterID).removeValue();
    }

    public void removeFromPendingList(String requesterID){
        activationReqeustNode.child(managerID).child(requesterID).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

            }
        });
    }


}
