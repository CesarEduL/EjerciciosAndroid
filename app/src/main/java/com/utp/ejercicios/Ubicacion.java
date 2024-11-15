package com.utp.ejercicios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ubicacion extends AppCompatActivity implements
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMapLongClickListener,
        OnMapReadyCallback {

    EditText v_latitud, v_longitud;
    TextView v_respuesta_ubicacion;
    GoogleMap v_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        v_latitud = findViewById(R.id.edt_latidud);
        v_longitud = findViewById(R.id.edt_longitud);

        v_latitud.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                actualizarMapa();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        v_longitud.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                actualizarMapa();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

        v_respuesta_ubicacion = (TextView) findViewById(R.id.tv_respuesta_ubicacion);

        // Verificar si se enviaron datos desde la actividad Registrarse
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("Usuario", "");
        String email = sharedPreferences.getString("Correo", "");
        String password = sharedPreferences.getString("Contraseña", "");
        if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
            // Mostrar los datos en la vista
            String texto = username;
            v_respuesta_ubicacion.setText(texto);

            /*
            // Borrar los datos almacenados en SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            */
        }
    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        v_latitud.setText(String.valueOf(latLng.latitude));
        v_longitud.setText(String.valueOf(latLng.longitude));
        actualizarMapa();
    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        v_map = googleMap;
        v_map.setOnMapClickListener(this);
        v_map.setOnMapLongClickListener(this);

        // Ajustar el mapa para que muestre toda la ciudad de Piura
        LatLngBounds piuraBounds = new LatLngBounds(
                new LatLng(-5.2315, -80.6901), // Southwest bound
                new LatLng(-5.1661, -80.6033)  // Northeast bound
        );
        v_map.setLatLngBoundsForCameraTarget(piuraBounds);

        LatLng piura = new LatLng(-5.1825837, -80.6533602);
        v_map.addMarker(new MarkerOptions().position(piura).title("Peru, Piura"));
        v_map.moveCamera(CameraUpdateFactory.newLatLngZoom(piura, 12.0f)); // Ajustar el nivel de zoom según sea necesario
    }

    private void actualizarMapa() {
        String latitudStr = v_latitud.getText().toString();
        String longitudStr = v_longitud.getText().toString();

        if (!latitudStr.isEmpty() && !longitudStr.isEmpty()) {
            double latitud = Double.parseDouble(latitudStr);
            double longitud = Double.parseDouble(longitudStr);

            LatLng local = new LatLng(latitud, longitud);
            v_map.clear();
            v_map.addMarker(new MarkerOptions().position(local));
            v_map.moveCamera(CameraUpdateFactory.newLatLng(local));
        } else {
            LatLng piura = new LatLng(-5.1825837, -80.6533602);
            v_map.clear();
            v_map.addMarker(new MarkerOptions().position(piura).title("Peru, Piura"));
            v_map.moveCamera(CameraUpdateFactory.newLatLng(piura));
        }
    }
}