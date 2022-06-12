package com.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	TextView txtView;
	int count = 0;
	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtView = findViewById(R.id.txtCounter);
	}

	public void startCounting(View view) {
		count = 0;
		handler.postDelayed(countThread, 500);
	}

	private Runnable countThread = new Runnable() {
		@Override
		public void run() {
			txtView.setText(""+count);
			count++;
			handler.postDelayed(countThread, 500);
		}
	};

	public void stopCounting(View view) {
		handler.removeCallbacks(countThread);
	}
}