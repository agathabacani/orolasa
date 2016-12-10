package jeadev.orolasa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
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

public class MainActivity extends AppCompatActivity {
    Button btn_submit;
    TextView txt_license_number,txt_maiden_name,txt_birdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_submit=(Button)findViewById(R.id.btn_submit);
        txt_license_number=(TextView)findViewById(R.id.txt_license_number);
        txt_maiden_name=(TextView)findViewById(R.id.txt_maiden_name);
        txt_birdate=(TextView)findViewById(R.id.txt_birthdate);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Config.lincenseID=txt_license_number.getText().toString();
                String url = Config.URL("validateuser")+"?source=1&maidenName='"+txt_maiden_name.getText().toString()+"'&birthDate='"+txt_birdate.getText().toString()+"'&licenseNumber='"+txt_license_number.getText().toString()+"'";
                JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                boolean isvalid = false;
                                try {
                                        JSONObject obj = (JSONObject) response.get(0);
                                        if(!obj.getString("cnt").equals("0")){
                                            Intent startmainactivity=new Intent(getApplicationContext(),Account_Forms.class);
                                            startActivity(startmainactivity);
                                        }
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
        });
    }
}
