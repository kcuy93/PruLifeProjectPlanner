package com.mobee.prulifeagentplanner;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mobee.prulifeagentplanner.model.AccountActivationModel;

import java.util.List;


/**
 * A fragment that contains the Requests sent by field agents to the Manager
 */
public class PendingFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    private ListView pendingRequestList;
    AccountActivationModel accountActivationModel;

    public PendingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pending,
                container, false);

        final AccountActivationModel accountActivationModel = new AccountActivationModel("kevin");

        pendingRequestList = (ListView) view.findViewById(R.id.pending_request_list);

        final ProgressDialog dialog = ProgressDialog.show(getActivity(), null, "Retrieving list..");

        accountActivationModel.getPendingRequests(new AccountActivationModel.GetPendingRequestListener() {
            @Override
            public void onDataChange(List<String> pendingList) {

                PendingListAdapter pendingListAdapter = new PendingListAdapter(getActivity(), pendingList);
                pendingListAdapter.setModel(accountActivationModel);

                pendingRequestList.setAdapter(pendingListAdapter);
                dialog.dismiss();
            }

            @Override
            public void onFail() {

            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
