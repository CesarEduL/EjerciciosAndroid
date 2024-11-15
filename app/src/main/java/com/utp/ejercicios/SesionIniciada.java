package com.utp.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.utp.ejercicios.GridViewParameters.AdapterNegocio;
import com.utp.ejercicios.GridViewParameters.Negocio;

import java.util.ArrayList;

public class SesionIniciada extends AppCompatActivity {
    TextView v_respuesta;
    GridView v_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion_iniciada);
        v_respuesta = (TextView) findViewById(R.id.tv_respuesta);

        // Verificar si se enviaron datos desde la actividad Registrarse
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("Usuario", "");
        if (!username.isEmpty()) {
            // Mostrar los datos en la vista
            String[] nombres = username.split(" ");
            String primerNombre = nombres[0];
            String segundoNombre = "";
            if (nombres.length > 1) {
                segundoNombre = nombres[1];
            }
            String texto = primerNombre + " " + segundoNombre;
            v_respuesta.setText(texto);
        }
        v_grid = findViewById(R.id.gridView);

        ArrayList<Negocio> valores = new ArrayList<>();
        valores.add(new Negocio("Toyota Agya", R.drawable.carrito_de_compras, R.drawable.a01));
        valores.add(new Negocio("Toyota Raize", R.drawable.carrito_de_compras, R.drawable.a02));
        valores.add(new Negocio("Toyota Corolla", R.drawable.carrito_de_compras, R.drawable.a03));
        valores.add(new Negocio("Toyota Etios", R.drawable.carrito_de_compras, R.drawable.a04));
        valores.add(new Negocio("Toyota Corolla Cross", R.drawable.carrito_de_compras, R.drawable.a05));
        valores.add(new Negocio("Toyota Fortuner", R.drawable.carrito_de_compras, R.drawable.a06));
        valores.add(new Negocio("Toyota Hiace", R.drawable.carrito_de_compras, R.drawable.a07));

        AdapterNegocio adapter = new AdapterNegocio(this, valores);
        v_grid.setAdapter(adapter);

        LinearLayout buttonContainer = findViewById(R.id.buttonContainer);
        buttonContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad Ubicacion
                Intent intent = new Intent(SesionIniciada.this, Ubicacion.class);
                startActivity(intent);
            }
        });
    }
}
