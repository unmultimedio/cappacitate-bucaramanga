package com.example.usuario.fragmentossample;


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

    Activity parentA;

    Communicator interfaceParent;

    public Sender() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sernder, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        parentA = activity;

        try{
            interfaceParent = (Communicator)activity;
        }catch (Exception e){
            //La actividad que me adjunto no implementa la interfaz
        }
    }


    public void prepareInfo() {
        String val =
                ((EditText)
                        parentA.findViewById(R.id.editText))
                        .getText().toString();

        interfaceParent.send2SecondFragment(val);
    }
}
