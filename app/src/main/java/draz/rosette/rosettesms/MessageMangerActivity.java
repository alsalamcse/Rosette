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
import java.util.List;

import javax.sql.CommonDataSource;



public class MessageMangerActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;


    private EditText etMessage, etPhoneNumber;
    private TextView pickedTime;
    private Button btnPick, btnSubmit;
    static final int DIALOG_ID = 0;

    Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_manger);
        SmsManager smsManager = SmsManager.getDefault();

//Send the SMS//

        smsManager.sendTextMessage("0543460494", null, "Rosette's app", null, null);

        pickedTime = (TextView) findViewById(R.id.pickedTime);

        Calendar calendar = Calendar.getInstance();
        final int hour = calendar.get(Calendar.HOUR_OF_DAY);
        final int minute = calendar.get(Calendar.MINUTE);

        btnPick = (Button) findViewById(R.id.btnPick);
        etMessage = (EditText) findViewById(R.id.etMessage);
        etPhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        pickedTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, android.text.format.DateFormat.is24HourFormat(mContext));
                timePickerDialog.show();
            }

        });
    }
}