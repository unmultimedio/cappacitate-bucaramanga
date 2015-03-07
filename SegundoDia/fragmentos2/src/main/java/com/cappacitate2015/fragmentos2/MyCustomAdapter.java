package com.cappacitate2015.fragmentos2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julianfigueroa on 3/7/15.
 */
public class MyCustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<User> users;

    public MyCustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.users = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(this.resource, parent, false);

        User thisUser = users.get(position);

        ((TextView)rowView.findViewById(R.id.nameOutput))
                .setText(thisUser.getName());
        ((TextView)rowView.findViewById(R.id.positionOutput))
                .setText(thisUser.getPosition());

        return rowView;
    }
}
