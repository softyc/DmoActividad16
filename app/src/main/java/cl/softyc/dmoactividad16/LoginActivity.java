package cl.softyc.dmoactividad16;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



       // int googleServiceStatus = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
       // Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(this,googleServiceStatus, 10);
       // if(dialog!=null){
        //    dialog.show();
       // }


// Insertar usuario de forma Manual
        Usuarios c = new Usuarios();

        String usuario="softyc";
        String nombre="Felipe Campos";
        String pass1="1234";
        c.setUsuario(usuario);
        c.setNombre(nombre);
        c.setPassword(pass1);
        helper.insertUsuarios(c);

        String usuario2="profesor";
        String nombre2="ANDRES MUÑOZ ORDENES";
        String pass3="1234";
        c.setUsuario(usuario2);
        c.setNombre(nombre2);
        c.setPassword(pass3);
        helper.insertUsuarios(c);



          ImageButton bt = (ImageButton)findViewById(R.id.BtnAcceder);
          bt.setOnClickListener(new View.OnClickListener() {

              @Override
              public void onClick(View v) {
                  if(v.getId() == R.id.BtnAcceder)
                  {
                      EditText user = (EditText)findViewById(R.id.txtuser);
                      String str_user = user.getText().toString();
                      EditText password = (EditText)findViewById(R.id.txtpassword);
                      String str_password = password.getText().toString();


                      String pass = helper.searchPass(str_user);
                      if(str_password.equals(pass))
                      {


                          Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                          i.putExtra("Usuario",str_user);
                          startActivity(i);
                      }
                      else
                      {
                          Toast temp = Toast.makeText(LoginActivity.this , "Usuario y Password no encontrados " , Toast.LENGTH_SHORT);
                          temp.show();
                          user.setText("");
                          password.setText("");
                      }



                  }


              }
          });







    }

}
