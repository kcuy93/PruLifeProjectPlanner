package com.mobee.prulifeagentplanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobee.prulifeagentplanner.TeamSummary;

public class TeamSummaryPresenterActivity extends AppCompatActivity{

    private DatabaseReference dataRef;

    private TextView approachTally, approachTotal;
    private TextView appointmentsTally, appointmentsTotal;
    private TextView presentationTally, presentationTotal;
    private TextView closedSaleTally, closedSaleTotal;
    private TextView prospectingTally, prospectingTotal;
    private TextView totalPointsTally, grandTotalPoints;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_summary);

        /**
         * Initialize database
         * **/
        dataRef = FirebaseDatabase.getInstance().getReference();

        approachTally = (TextView) findViewById(R.id.approachTally);
        approachTotal = (TextView) findViewById(R.id.approachTallyTotal);
        appointmentsTally = (TextView) findViewById(R.id.appointmentsTally);
        appointmentsTotal = (TextView) findViewById(R.id.appointmentsTotal);
        presentationTally = (TextView) findViewById(R.id.presentationTally);
        presentationTotal = (TextView) findViewById(R.id.presentationTotal);
        closedSaleTally = (TextView) findViewById(R.id.closedSaleTally);
        closedSaleTotal = (TextView) findViewById(R.id.closedSaleTotal);
        prospectingTally = (TextView) findViewById(R.id.prospectingTally);
        prospectingTotal = (TextView) findViewById(R.id.prospectingTotal);
        totalPointsTally = (TextView) findViewById(R.id.totalPointsTally);
        grandTotalPoints = (TextView) findViewById(R.id.grandTotalPoints);



    /*    *//**
         * Reading from database
         * **//*
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
    }
}
