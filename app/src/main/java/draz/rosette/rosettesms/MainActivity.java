package draz.rosette.rosettesms;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Adapter;
        import android.widget.ListAdapter;
        import android.widget.ListView;

        import draz.rosette.rosettesms.data.messageAdapter;

public class MainActivity extends AppCompatActivity {

    private ListView lvMessages;
    private Adapter messageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMessages = (ListView) findViewById(R.id.lvMessages);
        messageAdapter = new messageAdapter(getBaseContext(), R.layout.message_item);
        lvMessages.setAdapter((ListAdapter) messageAdapter);



    }

}