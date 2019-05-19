package draz.rosette.rosettesms;

import android.Manifest;
import android.accessibilityservice.AccessibilityService;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import java.io.File;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.sql.CommonDataSource;



public class MessageMangerActivity extends AppCompatActivity{
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;


    private EditText etMessage, etPhone;
    private TextView textView;
    private Button btnPick, btnSubmit;
    static final int DIALOG_ID = 0;
    int hourFinal;
    int minuteFinal;

    // int day, month, year, hour, minute;
    // int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    // private DatePickerDialog datePickerDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_manger);
        showTimePickerDialog();
        checkForSmsPermission();



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smsSendMessage();
            }

            private void smsSendMessage() {

                EditText editText = (EditText) findViewById(R.id.etPhone);
                // Set the destination phone number to the string in editText.
                String destinationAddress = editText.getText().toString();
                // Find the sms_message view.
                EditText smsEditText = (EditText) findViewById(R.id.etMessage);
                // Get the text of the sms message.
                String smsMessage = smsEditText.getText().toString();

               // Set the service center address if needed, otherwise null.
                        String scAddress = "0548047916";
                // Set pending intents to broadcast
                // when message sent and when delivered, or set to null.
                PendingIntent sentIntent = null, deliveryIntent = null;

                // Use SmsManager.
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage
                        (destinationAddress, scAddress, smsMessage,
                                sentIntent, deliveryIntent);
            }
        });



    }

    private void checkForSmsPermission() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission not yet granted.", Toast.LENGTH_LONG).show();
           //Log.e(Tag, "Permission not yet granted");
            // Permission not yet granted. Use requestPermissions().
            // MY_PERMISSIONS_REQUEST_SEND_SMS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        } else {
            // Permission already granted. Toast.
            Toast.makeText(this, "Permission already granted.", Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.SEND_SMS)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted. Toast.
                    Toast.makeText(this, "Permission was granted.", Toast.LENGTH_LONG).show();
                } else {
                    // Permission denied.
                   // Log.d(TAG, getString(R.string.failure_permission));
                    Toast.makeText(this, "failure_permission.", Toast.LENGTH_LONG).show();

                    // Disable the sms button.

                }
            }
        }
    }
    public void showTimePickerDialog() {
        btnPick = findViewById(R.id.btnPick);
        textView = findViewById(R.id.textView);


//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                smsSendMessage();
//            }
//        });

    }

//    private void smsSendMessage() {
//        EditText etMessage = (EditText) findViewById(R.id.etMessage);
//        String stMessage = etMessage.getText().toString();
//
//        String phone = "+972522982533";
//        // Set the service center address if needed, otherwise null.
//        String scAddress = null;
//// Set pending intents to broadcast
//// when message sent and when delivered, or set to null.
//        PendingIntent sentIntent = null, deliveryIntent = null;
//        SmsManager smsManager = SmsManager.getDefault();
//        smsManager.sendTextMessage
//                (phone, scAddress, stMessage,
//                        sentIntent, deliveryIntent);
//



    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new TimePickerDialog(MessageMangerActivity.this, kTimePickerListner, hourFinal, minuteFinal, false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener kTimePickerListner =
            new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hourFinal = hourOfDay;
                    minuteFinal = minute;
                    Toast.makeText(MessageMangerActivity.this, hourFinal + ":" + minuteFinal, Toast.LENGTH_LONG).show();

                }
            };



    }




