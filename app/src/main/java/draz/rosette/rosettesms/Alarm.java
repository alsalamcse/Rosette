package draz.rosette.rosettesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;
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




public class Alarm extends BroadcastReceiver {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    @Override
    public void onReceive(Context context, Intent intent) {
        //   Toast.makeText(context,"finally", Toast.LENGTH_LONG).show();
        //Send the SMS//
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("0543460494", null, "sms message", null, null);

        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("1", 1);


    }

}