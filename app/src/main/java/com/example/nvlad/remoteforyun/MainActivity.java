package com.example.nvlad.remoteforyun;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buttonAddClick(View v)
    {
        findViewById(R.id.buttonTop).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                new Test().execute("http://192.168.240.1/arduino/digital/13/100");
            }
        });
    }
    public void buttonAddClickDown(View v)
    {
        findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                new testDown().execute("http://192.168.240.1/arduino/digital/13/0");
            }
        });
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

}

















