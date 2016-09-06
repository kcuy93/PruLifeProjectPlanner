package com.mobee.prulifeagentplanner;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mobee.prulifeagentplanner.model.AccountActivationModel;
import com.mobee.prulifeagentplanner.model.UserModel;

import java.util.List;

/**
 * Created by Kevin on 8/7/2016.
 */
public class PendingListAdapter extends BaseAdapter {

    List<String> pendingAgentIDList;
    Activity activity;
    AccountActivationModel model;

    public PendingListAdapter(Activity activity, List<String> pendingList){
        this.pendingAgentIDList = pendingList;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return pendingAgentIDList.size();
    }

    @Override
    public Object getItem(int position) {
        return pendingAgentIDList.get(position);
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

        //get user name
        UserModel userModel = new UserModel();
        Agent agent = userModel.getAgent(pendingAgentIDList.get(position));
        String fullname = agent.getFirstName() + " " + agent.getLastName();
        fullname = agent.getId();

        holder.agentName.setText(fullname);
        holder.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendingAgentIDList.remove(position);
                getModel().acceptRequest(pendingAgentIDList.get(position));
                notifyDataSetChanged();
            }
        });

        holder.rejectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pendingAgentIDList.remove(position);
                Toast.makeText(activity, "Reject Agent!", Toast.LENGTH_SHORT).show();
                getModel().rejectRequest(pendingAgentIDList.get(position));
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


    public AccountActivationModel getModel() {
        return model;
    }

    public void setModel(AccountActivationModel model) {
        this.model = model;
    }
}
