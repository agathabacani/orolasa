package jeadev.orolasa;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ticket_mainBody extends Activity {
TextView lbl_fname, lbl_add, lbl_birthdate, lbl_number, lbl_ticketNumber, lbl_appointment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_main_body);
        lbl_fname=(TextView)findViewById(R.id.lbl_fname);
        lbl_add=(TextView)findViewById(R.id.lbl_address);
        lbl_birthdate=(TextView)findViewById(R.id.lbl_birthdate);
        lbl_number=(TextView)findViewById(R.id.lbl_number);
        lbl_ticketNumber=(TextView)findViewById(R.id.lbl_ticketNumber);
        lbl_appointment=(TextView)findViewById(R.id.lbl_appointment);
    }
}
