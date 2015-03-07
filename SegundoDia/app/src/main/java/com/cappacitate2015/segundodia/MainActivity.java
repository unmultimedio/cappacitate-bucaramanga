package com.cappacitate2015.segundodia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends ActionBarActivity implements GoogleMap.OnMapLongClickListener {

    GoogleMap myMap;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        if(setUpMap()){
            addMarker();
        }

    }

    public void addMarker(){
        MarkerOptions options = new MarkerOptions()
                .position(new LatLng(4.0, -72.0))
                .title("Hola Colombia!")
                .draggable(true);


        Marker myMarker =  myMap.addMarker(options);

        myMap.setOnMapLongClickListener(this);

        count=0;

    }

    public boolean setUpMap(){

        if(myMap == null){
            myMap = ((MapFragment)getFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            myMap.setMyLocationEnabled(true);
        }

        if(myMap == null){
            return false;
        }

        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Toast.makeText(this,"Antes",Toast.LENGTH_SHORT).show();

        count++;

        Toast.makeText(this,"Despues",Toast.LENGTH_SHORT).show();

        myMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("Clic:"+String.valueOf(count))
                .draggable(true));
    }
}
