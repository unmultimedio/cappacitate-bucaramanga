package com.example.usuario.fragmentossample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Receiver extends Fragment {

    ListView lista;

    List<String> entries;

    ArrayAdapter<String> myAdapter;

    public Receiver() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receiver, container, false);

        lista = (ListView)v.findViewById(R.id.listReceiver);

        entries = new ArrayList<>();

        myAdapter
                = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                entries
        );

        lista.setAdapter(myAdapter);

        return v;
    }

    public void updateInfo(String msg) {
        /*
        ((TextView)getActivity()
                .findViewById(R.id.textViewResponse))
                .setText(msg);
                */

        entries.add(msg);

        myAdapter.notifyDataSetChanged();

    }
}
