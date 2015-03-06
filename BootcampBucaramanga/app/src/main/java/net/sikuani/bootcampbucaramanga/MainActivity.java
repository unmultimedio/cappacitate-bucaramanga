package net.sikuani.bootcampbucaramanga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        String btn = "click:";

        switch (id){
            case R.id.action_settings:
                btn += "conf";
                break;
            case R.id.button_2:
                btn += "1";
                break;
            case R.id.button_3:
                btn += "2";
                break;
        }

        Toast.makeText(this,btn,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        //guardo
        super.onPause();
    }

    @Override
    protected void onStop() {
        //guardo
        super.onStop();
    }

    public void sendData(View view){

        EditText nameValueET =
                (EditText) findViewById(R.id.name_value);

        String nameValue = nameValueET.getText().toString();

        String msg =
                getResources().getString(R.string.toast_msg);

        msg += ": " + nameValue;


        Toast.makeText(
                this,
                msg,
                Toast.LENGTH_SHORT
        ).show();

        Intent callSecondActivity =
                new Intent(this, SecondActivity.class);

        callSecondActivity.putExtra("name",nameValue);

        startActivity(callSecondActivity);
    }
}
