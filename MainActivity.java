package sim.hecmundo.sendmail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.buttonSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"jayrosp@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Calificaciones SIM");
                EditText body = (EditText) findViewById(R.id.mailBody);
                String msj = body.getText().toString();
                emailIntent.putExtra(Intent.EXTRA_TEXT,msj);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent, "Choose email client..."));
            }
        });
    }
}
