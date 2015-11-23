package cl.softyc.dmoactividad16;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

public class InicioActivity extends AppCompatActivity {


    private boolean bt;
    private final int progreso=2000;
    private Handler PrtUso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        PrtUso= new Handler();
        PrtUso.postDelayed(new Runnable() {
                               @Override
                               public void run() {

                                   finish();

                                   if (!bt){

                                       Intent intent = new Intent(InicioActivity.this, LoginActivity.class);
                                       InicioActivity.this.startActivity(intent);
                                   }


                               }
                           },progreso);




    }

}
