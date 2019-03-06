package draz.rosette.rosettesms.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import draz.rosette.rosettesms.R;

public class Adapter extends ArrayAdapter <MyMessage> {

    public Adapter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            //    convertView=LayoutInflater.from(getContext()).inflate(R)
            MyMessage myMessage = getItem(position);
            TextView tvto = convertView.findViewById(R.id.tvto);
            TextView tvReciver = convertView.findViewById(R.id.tvReciver);
            TextView tvTimePicked = convertView.findViewById(R.id.tvTimePicked);
            TextView tvTime = convertView.findViewById(R.id.tvTime);
            Button ibtnEdit = convertView.findViewById(R.id.ibtnEdit);
            Button ibtnDelete = convertView.findViewById(R.id.ibtnDelete);


            tvto.setText(myMessage.getToTitle());
            tvTime.setText(myMessage.getOnTitle());
            tvTimePicked.setText(myMessage.getTime());
            tvReciver.setText(myMessage.getReciver());
            tvTimePicked.setText(myMessage.getTime());
           // ibtnEdit



        }


            return (convertView);
        }

}

