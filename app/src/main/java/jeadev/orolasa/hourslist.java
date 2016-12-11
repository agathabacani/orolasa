package jeadev.orolasa;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class hourslist  extends ArrayAdapter<String> {
    String[] hours;
    RelativeLayout linearLayout;
    public hourslist(Context context, String[] hours) {
        super(context,R.layout.activity_hourslist, hours);
        this.hours=hours;
    }

    public View getView(int position, View contentView, ViewGroup parent){
        LayoutInflater layoutInflater=LayoutInflater.from(getContext());
        View CustomView=layoutInflater.inflate(R.layout.activity_hourslist,parent,false);
        TextView txt_hours=(TextView)CustomView.findViewById(R.id.txt_hours);
        txt_hours.setText(hours[position]);
        linearLayout=(RelativeLayout) CustomView.findViewById(R.id.req_list);
        if((position%2)==0){
            linearLayout.setBackgroundColor(Color.rgb(220,220,220));
        }
        else{
            linearLayout.setBackgroundColor(Color.rgb(245,245,245));
        }
        return  CustomView;
    }

}
