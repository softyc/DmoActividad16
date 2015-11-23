package cl.softyc.dmoactividad16;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {


    public String user_m;
    public double x,x1,x2,y,y1,y2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        user_m = getIntent().getStringExtra("Usuario_MAP");




    }


    @Override
    public void onMapReady(GoogleMap map) {

        switch (user_m){

            case "softyc" :
                            x = -36.608950;
                            y = -72.102484;
                            x1= -36.609686;
                            y1= -72.099718;
                            x2= -36.604122;
                            y2= -72.105772;
                            break;
            case "profesor":
                            x = -33.432023;
                            y = -70.601724;
                            x1= -33.431821;
                            y1= -70.609588;
                            x2= -33.427810;
                            y2= -70.607766;
                            break;




        }

        LatLng chillan = new LatLng(x, y);
        map.addMarker(new MarkerOptions().position(chillan).title("local de Cliente 1"));
        map.moveCamera(CameraUpdateFactory.newLatLng(chillan));

        LatLng chillan2 = new LatLng(x1, y1);
        map.addMarker(new MarkerOptions().position(chillan2).title("Local de  Cliente 2"));
        map.moveCamera(CameraUpdateFactory.newLatLng(chillan2));

        LatLng chillan3 = new LatLng(x2, y2);
        map.addMarker(new MarkerOptions().position(chillan3).title("Local de  Cliente 3"));
        map.moveCamera(CameraUpdateFactory.newLatLng(chillan3));



    }


}