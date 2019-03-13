package draz.rosette.rosettesms;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class MessageMangerActivity extends AppCompatActivity {

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
        openWhatsApp( );



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

    public void openWhatsApp( ){
        try {
            String text = "This is a test";// Replace with your message.

            String toNumber = "+972543460494"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    }




