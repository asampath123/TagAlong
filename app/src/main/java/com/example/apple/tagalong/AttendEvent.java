package com.example.apple.tagalong;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AttendEvent extends AppCompatActivity {

    private Cursor cursor;
    private DataHandler dbHandler;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private String mEventName,mEventDesc,mEventLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attend_event);


        dbHandler = new DataHandler(this);

        cursor = dbHandler.getEventDetails();

        mEventName = cursor.getString(cursor.getColumnIndexOrThrow(dbHandler.COLUMN_EVENT_NAME));

        mEventDesc = cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_EVENT_DESCRIPTION));

        mEventLoc = cursor.getString(cursor.getColumnIndex(dbHandler.COLUMN_EVENT_LOCATION));

        tv1 = (TextView)findViewById(R.id.editText);
        tv2 = (TextView)findViewById(R.id.editText2);
        tv3 = (TextView)findViewById(R.id.editText3);

        tv1.setText(mEventName);

        tv2.setText(mEventDesc);
        tv3.setText(mEventLoc);

    }

    public void onButtonToConfirm(View view){

        AlertDialog alertDialog = new AlertDialog.Builder(AttendEvent.this).create();
        alertDialog.setTitle("Confirm");
        alertDialog.setMessage("Are you sure you want to attend this event?");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

}
