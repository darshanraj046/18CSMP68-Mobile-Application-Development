package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
	EditText edt;
	Button btn;
	TextToSpeech textToSpeech;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(this);
		edt = (EditText) findViewById(R.id.edtTxt);

		textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			@Override
			public void onInit(int i) {
				if(i!=textToSpeech.ERROR) {
					textToSpeech.setLanguage(Locale.ENGLISH);
				}
			}
		});
	}

	@Override
	public void onClick(View view) {
		textToSpeech.speak(edt.getText().toString(), textToSpeech.QUEUE_FLUSH, null);
	}
}