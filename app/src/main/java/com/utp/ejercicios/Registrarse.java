package com.utp.ejercicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registrarse extends AppCompatActivity {
    EditText v_contraseña, v_nombre, v_correo,v_confirmar_contraseña;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        v_nombre = (EditText) findViewById(R.id.edt_IngreseNombre);
        v_correo = (EditText) findViewById(R.id.edt_EmailAddress);
        v_contraseña = (EditText) findViewById(R.id.edt_Contraseña);
        v_confirmar_contraseña = (EditText) findViewById(R.id.edt_ConfirmarContraseña);

        // Obtener el objeto SharedPreferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void irAIniciarSesion(View view) {
        Intent i = new Intent(this, IniciarSesion.class);
        startActivity(i);
    }

    public void enviarDatos(View view) {
        // Obtener los valores ingresados por el usuario
        String username = v_nombre.getText().toString().trim();
        String email = v_correo.getText().toString().trim();
        String password = v_contraseña.getText().toString().trim();
        String confirmPassword = v_confirmar_contraseña.getText().toString().trim();

        // Verificar que los campos estén llenos
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Por favor llene todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificar que las contraseñas coinciden
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Almacenar los valores en SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Usuario", username);
        editor.putString("Correo", email);
        editor.putString("Contraseña", password);
        editor.apply();

        // Mostrar mensaje de éxito
        Toast.makeText(this, "Registrado con éxito", Toast.LENGTH_SHORT).show();

        // Iniciar la actividad IniciarSesion
        Intent intent = new Intent(this, IniciarSesion.class);
        startActivity(intent);
    }
}