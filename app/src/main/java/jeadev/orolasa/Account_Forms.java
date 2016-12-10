package jeadev.orolasa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;

public class Account_Forms extends AppCompatActivity {
    Button btn_renew_now;
    TextView lbl_full_name,lbl_address,lbl_date,lbl_license_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account__forms);
        lbl_address=(TextView)findViewById(R.id.lbl_address);
        lbl_date=(TextView)findViewById(R.id.lbl_date);
        lbl_license_number=(TextView)findViewById(R.id.lbl_platenumber);
        lbl_full_name=(TextView)findViewById(R.id.lbl_username);
        btn_renew_now=(Button)findViewById(R.id.btn_renew_now);
        btn_renew_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(btn_renew_now.getText().toString().equals("Check Status!")){


                    String url = Config.URL("select_user")+"?source=1&licenseNumber='"+Config.lincenseID+"'";
                    JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                            new Response.Listener<JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    boolean isvalid = false;
                                    try {

                                        JSONObject obj = (JSONObject) response.get(0);

                                        if(obj.getString("isvalid").equals("1")){
                                            Intent startmainactivity=new Intent(getApplicationContext(),ticket.class);
                                            startActivity(startmainactivity);
                                            btn_renew_now.setText("Renew Now!");
                                        }
                                        else{Toast.makeText(Account_Forms.this, "Your Request is on Process...", Toast.LENGTH_SHORT).show();}
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
                }else{
                Intent startmainactivity=new Intent(getApplicationContext(),form.class);
                startActivity(startmainactivity);}
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();



        String url = Config.URL("select_user")+"?source=1&licenseNumber='"+Config.lincenseID+"'";
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        boolean isvalid = false;
                        try {

                                JSONObject obj = (JSONObject) response.get(0);
                                lbl_address.setText(obj.getString("presentAddress"));
                                  lbl_full_name.setText(obj.getString("fullname"));
                                  lbl_date.setText(obj.getString("birthdate"));
                                  lbl_license_number.setText(Config.lincenseID);
                                    if(obj.getString("isprocess").equals("1")){
                                        btn_renew_now.setText("Check Status!");
                                    }
                            Config.ID=obj.getString("id");

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
