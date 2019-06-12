package draz.rosette.rosettesms;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsManager;
import android.util.Log;

public class AlarmService extends IntentService  {
    public AlarmService() {
        super("AlarmService");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected void onHandleIntent (Intent intent) {

        //Send the SMS//
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("0543460494", null, "sms message", null, null);

    }
}
