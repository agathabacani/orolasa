package jeadev.orolasa;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Banking extends Activity {
    Button button12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking);
        button12=(Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Banking.this, "Successfully Paid the bill.", Toast.LENGTH_SHORT).show();
                Intent startmainactivity=new Intent(getApplicationContext(),Ticket_mainBody.class);
                startActivity(startmainactivity);
            }
        });
    }
}
