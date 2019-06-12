package draz.rosette.rosettesms;

import android.Manifest;
import android.accessibilityservice.AccessibilityService;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
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
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import java.util.Date;
import java.util.List;

import javax.sql.CommonDataSource;



public class MessageMangerActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    AlarmManager alarmManager;

    private EditText etMessage, etPhoneNumber;
    private TextView pickedTime;
    private Button btnPick, btnSubmit;
    static final int DIALOG_ID = 0;
    private TimePicker alarmTimePicker;
    private PendingIntent pendingIntent;

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_manger);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //Send the SMS//

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("0543460494", null, "sms message", null, null);


        Date currentDate= Calendar.getInstance().getTime();
















        pickedTime = (TextView) findViewById(R.id.pickedTime);

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);



        btnPick = (Button) findViewById(R.id.btnPick);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        etMessage = (EditText) findViewById(R.id.etMessage);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        pickedTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }

        });

    //    Toast.makeText(getApplicationContext(), timePickerDialog.getC.toString(), Toast.LENGTH_SHORT).show();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


public void onTime (View view)
{

    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
    calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
    Intent myIntent = new Intent(MessageMangerActivity.this, MainActivity.class);
    pendingIntent = PendingIntent.getBroadcast(MessageMangerActivity.this, 0, myIntent, 0);
    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);


}


}