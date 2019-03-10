package draz.rosette.rosettesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TimePicker;

public class MessageMangerActivity extends AppCompatActivity {

    private EditText etMessage;
    private TimePicker simpleTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_manger);

        simpleTimePicker=findViewById(R.id.simpleTimePicker);







    }
}
