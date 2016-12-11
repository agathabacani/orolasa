package jeadev.orolasa;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ticket extends Activity {
    TextView txt_data,lbl_code;
    Button btn_payment;
    String Total_penalty=" Year Failed to Pay : ";
    String Amount="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        txt_data=(TextView)findViewById(R.id.txt_data);
        lbl_code=(TextView)findViewById(R.id.lbl_code);
        btn_payment=(Button)findViewById(R.id.btn_payment);
        btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startmainactivity=new Intent(getApplicationContext(),mainpayment.class);
                startActivity(startmainactivity);
//                new AlertDialog.Builder(getApplicationContext())
//                        .setTitle("CONFIRMATION")
//                        .setMessage("D")
//                        .setIcon(R.color.colorPrimary)
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//
//                            public void onClick(DialogInterface dialog, int whichButton) {
//
//                            }})
//                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//
//                            }
//                        }).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();


        String url = Config.URL("select_balanceinfo")+"?source=1&user_id='"+Config.ID+"'";
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        boolean isvalid = false;
                        try {

                            JSONObject obj = (JSONObject) response.get(0);
                            if(Integer.parseInt(obj.getString("year_gap"))==0){

                            }
                            else{
                                 switch (Integer.parseInt(obj.getString("year_gap"))){
                                     case 1:
                                         Total_penalty+="75.00 php ";
                                         Config.Amount="75.00";

                                         break;
                                     case 2:
                                         Total_penalty+="150.00 php ";
                                         Config. Amount="150.00";
                                         break;
                                     default:
                                         Total_penalty+="225.00 php ";
                                         Config.Amount="225.00";
                                         break;
                                 }
                            }
txt_data.setText("Last Date Paid : "+obj.getString("date_paid")+"\nYear Failed to Pay : "+obj.getString("year_gap")+"\n"+Total_penalty);
                            lbl_code.setText(obj.getString("ticker_number"));
                            Config.Token=obj.getString("ticker_number");
                        } catch (JSONException e) {
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
        rq.add(jsObjRequest);

        rq.start();

    }
}
