package draz.rosette.rosettesms;

import android.accessibilityservice.AccessibilityService;
import android.app.ActionBar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
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

import draz.rosette.rosettesms.test.WhatsappAccessibilityService;

public class MessageMangerActivity extends AppCompatActivity{

    private EditText etMessage;
    private TextView textView;
    private Button btnPick;
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
     //  openWhatsApp( );
        if (!isAccessibilityOn (this, WhatsappAccessibilityService.class)) {
            Intent intent = new Intent (Settings.ACTION_ACCESSIBILITY_SETTINGS);
            this.startActivity (intent);
        }

    }

    public void showTimePickerDialog() {
        btnPick = findViewById(R.id.btnPick);
        textView = findViewById(R.id.textView);

        btnPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

    }

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
//
//    public void openWhatsApp( ){
//        try {
//            String text = "This is a test";// Replace with your message.
//
//            String toNumber = "+972543460494"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
//            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.
//
//            Intent intent = new Intent(Intent.ACTION_SEND);
//            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
//            startActivity(intent);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    private boolean isAccessibilityOn (Context context, Class<? extends AccessibilityService> clazz) {
        int accessibilityEnabled = 1;
        final String service = context.getPackageName () + "/" + clazz.getCanonicalName ();
        try {
            accessibilityEnabled = Settings.Secure.getInt (context.getApplicationContext ().getContentResolver (), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Settings.SettingNotFoundException ignored) { ignored.printStackTrace(); }

        TextUtils.SimpleStringSplitter colonSplitter = new TextUtils.SimpleStringSplitter (':');

        if (accessibilityEnabled == 1) {
            String settingValue = Settings.Secure.getString (context.getApplicationContext ().getContentResolver (), Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
            if (settingValue != null) {
                colonSplitter.setString (settingValue);
                while (colonSplitter.hasNext ()) {
                    String accessibilityService = colonSplitter.next ();

                    if (accessibilityService.equalsIgnoreCase (service)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
    }




