package draz.rosette.rosettesms;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import draz.rosette.rosettesms.data.MyMessage;

public class MessageActivity extends AppCompatActivity {

    private ImageButton ibtnDelete, ibtnEdit;

    private MyMessage myMessage;
    private TextView tvMessage, tvReciver, tvPickedApp, tvTimePicked;

   // private MyMessage myMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        ibtnEdit = findViewById(R.id.ibtnEdit);
        ibtnDelete = findViewById(R.id.ibtnDelete);
        tvMessage = findViewById(R.id.tvMessage);


        String stMessage = tvMessage.getText().toString();
        String stReciver = tvReciver.getText().toString();
        String stApp = tvPickedApp.getText().toString();
        String stTime = tvTimePicked.getText().toString();

        Intent i = getIntent();
        if (i != null)
        {
            //أخذ الكائن الموجود بالintent المبعوث
            myMessage = (MyMessage) i.getExtras().get("Mwssage");
             //تعديل الTextView لصفات الكائن
            tvMessage.setText(myMessage.getMessage());
            tvReciver.setText(myMessage.getReciver());
            tvPickedApp.setText(myMessage.getApp());
            tvTimePicked.setText(myMessage.getTime());

        }


        ibtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MessageMangerActivity.class);
                intent.putExtra("Message", (Parcelable) myMessage);
                startActivity(intent);
            }
        });

        ibtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete message
            }
        });


    }


}
