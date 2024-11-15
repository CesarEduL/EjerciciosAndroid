# Proyecto de App de Inicio de Sesión

![Logo del Proyecto](https://github.com/CesarEduL/EjerciciosAndroid/blob/main/app/src/main/res/drawable/logoempresa.png)

Este es un proyecto básico de una aplicación de inicio de sesión desarrollado en Android Studio durante mis primeros ciclos universitarios. La app utiliza **Shared Preferences** para almacenar la información del usuario de manera simple y accesible, lo cual puede ser útil para quienes se inician en el desarrollo de aplicaciones móviles.

## Descripción

La aplicación está diseñada para funcionar en dispositivos con Android 7.0 (SDK 24) o superior y está configurada para compilar con el SDK 33. Utiliza bibliotecas esenciales de Android para la interfaz y compatibilidad, como `AppCompat`, `Material Design`, y `ConstraintLayout`, junto con los servicios de Google Maps y ubicación. Además, incluye soporte para `CircleImageView`, permitiendo la integración de imágenes de perfil circulares en la interfaz de usuario.

## Características

- Registro de usuario con nombre de usuario y contraseña.
- Inicio de sesión persistente gracias a Shared Preferences.
- Mapa integrado y uso de la API de ubicación de Google.
- Interfaz sencilla y fácil de entender.

## Capturas de Pantalla

### Pantalla de Registro
![Pantalla de Registro](ruta/a/tu/imagen-registro.png)

### Pantalla de Inicio de Sesión
![Pantalla de Inicio de Sesión](ruta/a/tu/imagen-inicio-sesion.png)

### Pantalla Principal
![Pantalla Principal](ruta/a/tu/imagen-principal.png)

## Objetivo

Este proyecto puede servir como una guía para estudiantes o principiantes en desarrollo móvil que deseen aprender los conceptos básicos de almacenamiento de datos locales, manejo de formularios en Android y la integración de mapas y ubicación. Ideal para quienes están en las primeras etapas de su carrera y buscan entender la lógica de una app de inicio de sesión.

## Requisitos

- Android Studio Jellyfish
- SDK de Android

## Instalación y Ejecución

1. Clona el repositorio o descarga el código fuente.
2. Abre el proyecto en Android Studio.
3. Ejecuta la aplicación en un emulador o en un dispositivo físico conectado.

## Dependencias

El proyecto utiliza las siguientes dependencias:

- `androidx.appcompat:appcompat:1.6.1`
- `com.google.android.material:material:1.8.0`
- `androidx.constraintlayout:constraintlayout:2.1.4`
- `com.google.android.gms:play-services-maps:18.1.0`
- `com.google.android.gms:play-services-location:21.0.1`
- `de.hdodenhof:circleimageview:3.1.0`
- `junit:junit:4.13.2` (para pruebas)
- `androidx.test.ext:junit:1.1.5` (para pruebas)
- `androidx.test.espresso:espresso-core:3.5.1` (para pruebas)
