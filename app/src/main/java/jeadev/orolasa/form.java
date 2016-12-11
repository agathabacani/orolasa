package jeadev.orolasa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
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

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class form extends Activity {
ImageButton btn_md,btn_el;Button btn_submit_form;
    EditText txt_presentAddress,txt_height,txt_weight;
    RadioButton rdn_ds;
    String  Message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
//        btn_el=(ImageButton)findViewById(R.id.btn_el);
//        btn_md=(ImageButton)findViewById(R.id.btn_md);
        btn_submit_form=(Button)findViewById(R.id.btn_submit_form);
        txt_weight=(EditText)findViewById(R.id.weight);
        txt_presentAddress=(EditText)findViewById(R.id.txt_presentAddress);
        txt_height=(EditText)findViewById(R.id.txt_height);
        rdn_ds=(RadioButton)findViewById(R.id.rdn_ds);
//
//        btn_md.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Bitmap bitmap = ((BitmapDrawable) btn_md.getDrawable()).getBitmap();
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//                byte[] imageInByte = baos.toByteArray();
//
//                String str = "";
//                try {
//                    str = new String(imageInByte, "UTF-8");
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//                String url = Config.URL("update_imgMedical")+"?source=1&licenseNumber="+Config.lincenseID+"&imgMedical='"+str+"'";
//                JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                        (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
//
//                            @Override
//                            public void onResponse(JSONObject response) {
//
//                                try {
//
//
//                                    if (response.optString("message").equals("S")) {
//
//                                        Config.Message="Successfully Updated.";
////----
//
//                                        String url = Config.URL("update_tag")+"?source=1&licenseNumber='"+Config.lincenseID+"'&isprocess=1";
//                                        JsonObjectRequest jsObjRequest = new JsonObjectRequest
//                                                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
//                                                    @Override
//                                                    public void onResponse(JSONObject response) {
//                                                        try {
//                                                        } catch (Exception e) {
//                                                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//                                                        }
//                                                        Toast.makeText(getApplicationContext(), Config.Message, Toast.LENGTH_LONG).show();
//                                                        //Toast.makeText("Response: " + response.toString(),);
//                                                    }
//                                                }, new Response.ErrorListener() {
//                                                    @Override
//                                                    public void onErrorResponse(VolleyError error) {
//
//                                                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
//                                                    }
//                                                });
//                                        RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
//                                        rq.add(jsObjRequest);
//                                        rq.start();
////----
//                                    }
//                                } catch (Exception e) {
//
//                                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
//                                }
//
//                                Toast.makeText(getApplicationContext(), Config.Message, Toast.LENGTH_LONG).show();
//                                //Toast.makeText("Response: " + response.toString(),);
//
//                            }
//                        }, new Response.ErrorListener() {
//
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//
//                                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
//
//                            }
//                        });
//                RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
//                rq.add(jsObjRequest);
//                rq.start();
//            }
//        });
//        btn_el.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        btn_submit_form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ischeck=rdn_ds.isChecked()?1:0;
                String url = Config.URL("update_form")+"?source=1&presentAddress='"+txt_presentAddress.getText().toString()+"'&height='"+txt_height.getText().toString()+"'&weight='"+txt_weight.getText().toString()+"'&dsa='"+ischeck+"'&licenseNumber='"+Config.lincenseID+"'";

                JsonObjectRequest jsObjRequest = new JsonObjectRequest
                        (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {

                                try {


                                    if (response.optString("message").equals("S")) {

                                              Config.Message="Successfully Updated.";

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
        });
    }
    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
}
