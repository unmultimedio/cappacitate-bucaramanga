package com.cappacitate2015.fragmentos2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Receiver extends Fragment {

    MyCustomAdapter adapter;

    List<User> users;

    public Receiver() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        users = new ArrayList<>();

        adapter = new MyCustomAdapter(getActivity(), R.layout.user_row, users);

        View fragmentView =
                inflater.inflate(R.layout.fragment_receiver, container, false);

        ListView theList = ((ListView)fragmentView
               .findViewById(R.id.listViewUsers));

        theList.setAdapter(adapter);

        theList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick
                    (AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),
                        "clic:"+position,Toast.LENGTH_SHORT).show();

                users.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        return fragmentView;
    }


    public void updateList(User user) {

        users.add(user);

        adapter.notifyDataSetChanged();
    }
}
