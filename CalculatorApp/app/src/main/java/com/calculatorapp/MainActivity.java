package com.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

	Button button0, button1, button2, button3, button4, button5, button6,
			button7, button8, button9, button10, buttonAdd, buttonSub, buttonDivision,
			buttonMul, buttonC, buttonEqual;
	EditText editText;

	float valOne, valTwo;

	boolean add, sub, mul, div;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button0 = (Button) findViewById(R.id.button11);
		button1 = (Button) findViewById(R.id.button7);
		button2 = (Button) findViewById(R.id.button8);
		button3 = (Button) findViewById(R.id.button9);
		button4 = (Button) findViewById(R.id.button4);
		button5 = (Button) findViewById(R.id.button5);
		button6 = (Button) findViewById(R.id.button6);
		button7 = (Button) findViewById(R.id.button1);
		button8 = (Button) findViewById(R.id.button2);
		button9 = (Button) findViewById(R.id.button3);
		button10 = (Button) findViewById(R.id.button10);
		buttonAdd = (Button) findViewById(R.id.button14);
		buttonSub = (Button) findViewById(R.id.button15);
		buttonMul = (Button) findViewById(R.id.button16);
		buttonDivision = (Button) findViewById(R.id.button17);
		buttonC = (Button) findViewById(R.id.button13);
		buttonEqual = (Button) findViewById(R.id.button12);
		editText = (EditText) findViewById(R.id.edt1);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "1");
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "2");
			}
		});

		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "3");
			}
		});

		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "4");
			}
		});

		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "5");
			}
		});

		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "6");
			}
		});

		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "7");
			}
		});

		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "8");
			}
		});

		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "9");
			}
		});

		button0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + "0");
			}
		});

		buttonAdd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (editText == null) {
					editText.setText("");
				} else {
					valOne = Float.parseFloat(editText.getText() + "");
					add = true;
					editText.setText(null);
				}
			}
		});

		buttonSub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				valOne = Float.parseFloat(editText.getText() + "");
				sub = true;
				editText.setText(null);
			}
		});

		buttonMul.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				valOne = Float.parseFloat(editText.getText() + "");
				mul = true;
				editText.setText(null);
			}
		});

		buttonDivision.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				valOne = Float.parseFloat(editText.getText() + "");
				div = true;
				editText.setText(null);
			}
		});

		buttonEqual.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("SetTextI18n")
			@Override
			public void onClick(View v) {
				valTwo = Float.parseFloat(editText.getText() + "");
				if (add) {
					editText.setText(valOne + valTwo + "");
					add = false;
				}

				if (sub) {
					editText.setText(valOne - valTwo + "");
					sub = false;
				}

				if (mul) {
					editText.setText(valOne * valTwo + "");
					mul = false;
				}

				if (div) {
					editText.setText(valOne / valTwo + "");
					div = false;
				}
			}
		});

		buttonC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText("");
			}
		});

		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				editText.setText(editText.getText() + ".");
			}
		});
	}
}