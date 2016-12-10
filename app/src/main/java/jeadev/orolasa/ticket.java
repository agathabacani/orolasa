package jeadev.orolasa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ticket extends AppCompatActivity {
    TextView txt_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        txt_data=(TextView)findViewById(R.id.txt_data);
    }
    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    @Override
    protected void onStart() {
        super.onStart();


        String url = Config.URL("select_archieve")+"?source=1&user_id='"+Config.lincenseID+"'";
        JsonArrayRequest jsObjRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        boolean isvalid = false;
                        try {

                            JSONObject obj = (JSONObject) response.get(0);
                            Config.Last_year=obj.getString("date_paid");
                            Date date;

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
