package jeadev.orolasa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class mainpayment extends Activity implements View.OnClickListener {
ListView _req_list_view;
    String  day="";
    String  hour="";
    Button btn_m,btn_t,btn_w,btn_th,btn_f,btn_s;
    Button btn_1,btn_2,btn_3,btn_4,btn_6,btn_7,btn_8,btn_9,btn_10,btn_submit;
    TextView lbl_days_hours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpayment);
        btn_m= (Button) findViewById(R.id.btn_m);
        btn_t=(Button)findViewById(R.id.btn_t);
        btn_w=(Button)findViewById(R.id.btn_w);
        btn_th=(Button)findViewById(R.id.btn_th);
        btn_f=(Button)findViewById(R.id.btn_f);
        btn_s=(Button)findViewById(R.id.btn_s);

        btn_1= (Button) findViewById(R.id.button1);
        btn_2=(Button)findViewById(R.id.button2);
        btn_3=(Button)findViewById(R.id.button3);
        btn_4=(Button)findViewById(R.id.button4);
        btn_6=(Button)findViewById(R.id.button6);
        btn_7=(Button)findViewById(R.id.button7);
        btn_8=(Button)findViewById(R.id.button8);
        btn_9=(Button)findViewById(R.id.button9);
        btn_10=(Button)findViewById(R.id.button10);

       // btn_submit=(Button)findViewById(R.id.btn_submit_final_payment);
/*
*


* */

        lbl_days_hours=(TextView)findViewById(R.id.lbl_days_hours);
        btn_s.setOnClickListener(this);
        btn_f.setOnClickListener(this);
        btn_th.setOnClickListener(this);
        btn_w.setOnClickListener(this);
        btn_t.setOnClickListener(this);
        btn_m.setOnClickListener(this);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);

        btn_4.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_10.setOnClickListener(this);


    }
     private  void LoadData(String param){
//        String url = Config.URL("select_hours")+"?source=1&days="+param;
//        JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
//                new Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        boolean isvalid = false;
//                        String []name;
//                        name=new String[response.length()];
//                        try {
//                            for(int i=0;i<response.length();i++){
//
//                                           JSONObject obj = (JSONObject) response.get(i);
//                                            name[i]=obj.getString("hours");
//                            }
//                            _req_list_view=(ListView)findViewById(R.id.List_view);
//                            ListAdapter listAdapter = new hourslist(mainpayment.this,name );
//                            _req_list_view.setAdapter(null);
//                            _req_list_view.setAdapter(listAdapter);
//                            _req_list_view.setOnItemClickListener(new itemlist());
//                        } catch (JSONException e) {
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("alfie",error.getMessage());
//            }
//        });
//        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
//        rq.add(jsObjRequest);
//        rq.start();

    }

    @Override
    public void onClick(View view) {
        if(view==btn_f){
            MakeMeRed(btn_f,true);
        }
        if(view==btn_s){
            MakeMeRed(btn_s,true);
        }
        if(view==btn_th){
            MakeMeRed(btn_th,true);
        }
        if(view==btn_w){
            MakeMeRed(btn_w,true);
        }
        if(view==btn_t){
            MakeMeRed(btn_t,true);
        }
        if(view==btn_m){
            MakeMeRed(btn_m,true);
        }

        if(view==btn_1){
            MakeMeRed(btn_1,false);
        }
        if(view==btn_2){
            MakeMeRed(btn_2,false);
        }
        if(view==btn_3){
            MakeMeRed(btn_3,false);
        }
        if(view==btn_4){
            MakeMeRed(btn_4,false);
        }

        if(view==btn_6){
            MakeMeRed(btn_6,false);
        }
        if(view==btn_7){
            MakeMeRed(btn_7,false);
        }
        if(view==btn_8){
            MakeMeRed(btn_8,false);
        }
        if(view==btn_9){
            MakeMeRed(btn_9,false);
        }
        if(view==btn_10){
            MakeMeRed(btn_10,false);
        }
        if(btn_submit==view){
            String url = Config.URL("insert_archive")+"?source=1&user_id="+Config.ID+"&token="+Config.Token+"&amount="+Config.Amount;

            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (response.optString("message").equals("S")) {
                                    Config.Message="Successfully Saved.";
                                }
                            } catch (Exception e) {
                                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                            Toast.makeText(getApplicationContext(), Config.Message, Toast.LENGTH_LONG).show();
                            //Toast.makeText("Response: " + response.toString(),);
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });
            RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
            rq.add(jsObjRequest);
            rq.start();
        }
    }
    private void MakeMeRed(Button button,boolean itsday){
        button.setBackgroundColor(Color.RED);
        button.setTextColor(Color.WHITE);

        if(itsday){
        switch (button.getText().toString()){
            case "F":
                day="Friday";
                break;
            case "TH":
                day="Thursday";
                break;
            case "W":
                day="Wednesday";
                break;
            case "T":
                day="Tuesday";
                break;
            case "M":
                day="Monday";
                break;
            case "S":
                day="Sunday";
                break;
        }}
        else{
            hour=button.getText().toString();
        }
        lbl_days_hours.setText(day+" : "+hour);
    }

    class  itemlist implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ViewGroup vg=(ViewGroup)view;
            TextView txt_hours =(TextView) vg.findViewById(R.id.txt_hours);
            lbl_days_hours.setText("Set Hour : "+txt_hours.getText());
            Toast.makeText(getApplicationContext(),Config.ID,Toast.LENGTH_LONG).show();
        }

    }

}
