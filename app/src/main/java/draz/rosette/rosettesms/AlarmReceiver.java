package draz.rosette.rosettesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.telephony.SmsManager;

public class AlarmReceiver extends WakefulBroadcastReceiver  {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

//this will update the UI with message
        AlarmActivity inst = AlarmActivity.instance();
        inst.setAlarmText("receive succefully");
        //Send the SMS//

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("0543460494", null, "sms message", null, null);

        throw new UnsupportedOperationException("Not yet implemented");
    }
}
