package com.mobee.prulifeagentplanner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Kevin on 8/7/2016.
 */
public class PendingListAdapter extends BaseAdapter {

    List<String> pendingList;
    Activity activity;

    public PendingListAdapter(Activity activity, List<String> pendingList){
        this.pendingList = pendingList;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return pendingList.size();
    }

    @Override
    public Object getItem(int position) {
        return pendingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;

        if(convertView==null){

            LayoutInflater inflater = activity.getLayoutInflater();
            vi = inflater.inflate(R.layout.request_list_item, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.agentName = (TextView) vi.findViewById(R.id.agentName);
            holder.acceptButton=(Button) vi.findViewById(R.id.acceptButton);
            holder.rejectButton=(Button)vi.findViewById(R.id.rejectButton);

            /************  Set holder with LayoutInflater ************/
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();


        holder.agentName.setText(pendingList.get(position));
        holder.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendingList.remove(position);
                Toast.makeText(activity, "Accept Agent!", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        holder.rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendingList.remove(position);
                Toast.makeText(activity, "Reject Agent!", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });


        return vi;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{

        public TextView agentName;
        public Button acceptButton;
        public Button rejectButton;

    }
}
