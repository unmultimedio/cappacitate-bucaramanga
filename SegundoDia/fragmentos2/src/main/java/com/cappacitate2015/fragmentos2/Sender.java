package com.cappacitate2015.fragmentos2;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Sender extends Fragment {

    Communicator interfaceA;

    public Sender() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        interfaceA = (Communicator) activity;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sender, container, false);
    }


    public void prepareUser() {

        String positionStr =
                ((EditText)getActivity().findViewById(R.id.positionInput))
                .getText().toString();

        String nameStr =
                ((EditText)getActivity().findViewById(R.id.nameInput))
                .getText().toString();

        User user = new User(positionStr, nameStr);

        interfaceA.send2SecondFragment(user);
    }
}
