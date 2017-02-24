package com.example.apple.tagalong;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class HostEvent extends AppCompatActivity {


    private EditText mEventName;
    private EditText mEventDesc;
    private EditText mEventLocation;
    private DatePicker mEventDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_event);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mEventName = (EditText)findViewById(R.id.eventName);
        mEventDesc = (EditText) findViewById(R.id.eventDescription);
        mEventLocation = (EditText) findViewById(R.id.location);
        mEventDate =  (DatePicker) findViewById(R.id.datePicker2);

    }

    public void addEventOnClick(View view){


        Event event = new Event(mEventName.getText().toString(),mEventLocation.getText().toString(),
                mEventDesc.getText().toString(),null);


        DataHandler dataHandler = new DataHandler(this);

        dataHandler.addEvent(event);

        mEventName.setText("");
        mEventDesc.setText("");
        mEventLocation.setText("");

        Toast.makeText(this,"Event was added successfully", Toast.LENGTH_LONG).show();
    }


}
