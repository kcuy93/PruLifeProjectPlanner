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
    DatabaseReference prulifeDatabase;

    public AccountActivationModel(){
        this.prulifeDatabase = FirebaseDatabase.getInstance().getReference().child(ACTIVATION_REQUEST_ROOT);
    }

    public void requestActivation(String managerID, String requesterID){
        prulifeDatabase.child(managerID).child(requesterID).setValue(false);
    }

    public void acceptActivation(){

    }

    public void getPendingRequests(String managerID, final GetPendingRequestListener listener){

        prulifeDatabase.child(managerID).addListenerForSingleValueEvent(new ValueEventListener() {
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


}
