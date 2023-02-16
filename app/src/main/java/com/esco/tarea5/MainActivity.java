package com.esco.tarea5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	ImageButton mettatonButton;
	static AnimationDrawable viewAnimation;
	// Objeto que gestiona la reproducción de música
	static MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Asignación del ImageButton
		mettatonButton = findViewById(R.id.imageButton);
		// Creación del controlador de la animación
		viewAnimation = (AnimationDrawable) mettatonButton.getDrawable();
		// Creación del controlador de la música añadiendo el archivo guardado en el directorio raw
		mediaPlayer = MediaPlayer.create(getApplicationContext(),
				R.raw.undertale_mettaton_ex_theme_death_by_glamour);
		// Asignamos la música para reproducirse en bucle
		mediaPlayer.setLooping(true);

		// Añadimos el listener
		mettatonButton.setOnClickListener(MainActivity::mettatonOnClick);

		// Asignación del ImageView superior
		ImageView demonGodView = findViewById(R.id.demonGod);
		// Creación del controlador de la animación
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.rotate_demon_god);
		// Inicialización de la animación
		demonGodView.startAnimation(animation);

		// Asignación del TextView inferior
		TextView textView = findViewById(R.id.textView);
		// Creación del controlador de la animación
		animation = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.moving_snail);
		// Inicialización de la animación
		textView.startAnimation(animation);

		// Declaración del ImageView que muestra la imagen vectorial
		ImageView noteView = findViewById(R.id.noteImage);

		// Creación de la animación vectorial a partir del sistema de archivos
		AnimatedVectorDrawable animatedVectorDrawable = (AnimatedVectorDrawable) AppCompatResources.getDrawable(getApplicationContext(),
				R.drawable.note_animation);
		// Establecimiento de la animación al ImageView.
		noteView.setImageDrawable(animatedVectorDrawable);
		// Inicialización de la animación en caso de que no sea null
		if (animatedVectorDrawable != null)
			animatedVectorDrawable.start();
	}

	// Evento de clicado del ImageButton, inicializa o detiene tanto la animación como la música
	static void mettatonOnClick(View view) {

		if (!viewAnimation.isRunning()) {
			viewAnimation.start();
			mediaPlayer.start();
		} else {
			viewAnimation.stop();
			mediaPlayer.pause();
		}
	}
}
