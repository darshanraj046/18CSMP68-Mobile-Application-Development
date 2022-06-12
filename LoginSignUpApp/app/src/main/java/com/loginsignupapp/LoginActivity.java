package com.loginsignupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

	EditText userName, password;
	Button btn;
	int counter = 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		userName = findViewById(R.id.login_username);
		password = findViewById(R.id.login_password);
		btn = findViewById(R.id.btn_login);
	}

	public void LoginEvent(View view) {
		String uName = userName.getText().toString();
		String pwd = password.getText().toString();
		String regUserName = getIntent().getStringExtra("userName");
		String regPwd = getIntent().getStringExtra("pwd");
		if (regUserName.equals(uName) && regPwd.equals(pwd)){
			Intent it = new Intent(LoginActivity.this, LoginSuccessful.class);
			startActivity(it);
		} else {
			Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
			counter--;
		}
		if (counter == 0) {
			Toast.makeText(getBaseContext(), "Failed Login Attempts", Toast.LENGTH_SHORT).show();
			btn.setEnabled(false);
		}
	}
}