package cl.softyc.dmoactividad16;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
public String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        user = getIntent().getStringExtra("Usuario");
        final TextView usuario_log = (TextView) findViewById(R.id.txtusuario);
        usuario_log.setText(user);


        Button bt = (Button) findViewById(R.id.btnmapa);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(MenuActivity.this, MapsActivity.class);
                i.putExtra("Usuario_MAP", user);
                startActivity(i);


            }

        });


        findViewById(R.id.btnsalir).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, LoginActivity.class));
            }
        });
    }

}
