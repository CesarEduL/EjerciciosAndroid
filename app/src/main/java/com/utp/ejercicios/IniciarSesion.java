package com.utp.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {
    EditText v_contraseña_iniciar_sesion,v_correo_iniciar_sesion;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        v_correo_iniciar_sesion=(EditText) findViewById(R.id.edt_email_iniciar_sesion);
        v_contraseña_iniciar_sesion=(EditText) findViewById(R.id.edt_contraseña_iniciar_sesion);

        // Obtener el objeto SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void irARegistrarse(View view) {
        Intent i = new Intent(this, Registrarse.class);
        startActivity(i);
    }

    public void irASesionIniciada(View view) {
        // Obtener los valores ingresados por el usuario
        String email = v_correo_iniciar_sesion.getText().toString().trim();
        String password = v_contraseña_iniciar_sesion.getText().toString().trim();

        // Verificar que los campos no estén vacíos
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Ingrese su correo y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        // Obtener los valores almacenados en SharedPreferences
        String storedEmail = sharedPreferences.getString("Correo", "");
        String storedPassword = sharedPreferences.getString("Contraseña", "");

        // Verificar si el usuario está registrado
        if (storedEmail.isEmpty() || storedPassword.isEmpty()) {
            // El usuario no está registrado, mostrar un mensaje de error
            Toast.makeText(this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar que las credenciales coincidan
        if (email.equals(storedEmail) && password.equals(storedPassword)) {
            // Las credenciales son correctas, iniciar la sesión
            Intent intent = new Intent(this, SesionIniciada.class);
            intent.putExtra("correo", email);
            intent.putExtra("contraseña", password);
            startActivity(intent);
        } else {
            // Las credenciales son incorrectas, mostrar un mensaje de error
            Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show();
        }
    }
}