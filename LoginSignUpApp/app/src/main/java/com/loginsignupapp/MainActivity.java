package com.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
	EditText username, password;
	Button btn;
	int counter = 3;

	Pattern lowercase = Pattern.compile("^.*[a-z].*$");
	Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
	Pattern numbers = Pattern.compile("^.*[0-9].*$");
	Pattern specialChar = Pattern.compile("^.*[^a-zA-Z0-9].*$");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = findViewById(R.id.txt_username);
		password = findViewById(R.id.txt_password);
	}

	public void SignUpEvent(View view) {
		String uName = username.getText().toString();
		String pwd = password.getText().toString();

		if (isValidPassword(pwd)){
			Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
			return;
		}
		Intent it = new Intent(MainActivity.this, LoginActivity.class);
		it.putExtra("userName", uName);
		it.putExtra("pwd", pwd);
		startActivity(it);
	}

	private boolean isValidPassword(String pwd) {
		if (pwd.length() < 8)
			return false;
		if (!lowercase.matcher(pwd).matches())
			return false;
		if (!uppercase.matcher(pwd).matches())
			return false;
		if (!numbers.matcher(pwd).matches())
			return false;
		if (!specialChar.matcher(pwd).matches())
			return false;
		return true;
	}
}