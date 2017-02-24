package com.example.apple.tagalong;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> eventNames;
    private DataHandler dbHandler;
    private ListView lv;
    ListAdapter itemsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.MyCustomTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        dbHandler = new DataHandler(this);

        eventNames = dbHandler.getEventName();

        System.out.println("EVENT NAMES" + eventNames);

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, eventNames);

        lv = (ListView) findViewById(R.id.listView);

        lv.setAdapter(itemsAdapter);



    }

    public void onClickAddEvent(View view) {

        Intent intent = new Intent(this, HostEvent.class);
        startActivity(intent);

    }

    public void onStart(){

        super.onStart();
        setContentView(R.layout.activity_main);

        dbHandler = new DataHandler(this);

        eventNames = dbHandler.getEventName();

        System.out.println("EVENT NAMES" + eventNames);

        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, eventNames);

        lv = (ListView) findViewById(R.id.listView);

        lv.setAdapter(itemsAdapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {

                Intent intent = new Intent(v.getContext(),AttendEvent.class);
                startActivity(intent);

                /*;*/

                //String value = (String)adapter.getItemAtPosition(position);
                // assuming string and if you want to get the value on click of list item
                // do what you intend to do on click of listview row


            }
        });
    }


}