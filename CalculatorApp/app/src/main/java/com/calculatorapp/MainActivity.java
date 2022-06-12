package com.calculatorapp;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
	boolean isEmpty = true;
	String numOld = "";
	String op = "+";
	EditText edt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edt = findViewById(R.id.editText);
	}
	public void numberEvent(View view) {
		if(isEmpty)
			edt.setText("");
		isEmpty = false;
		String number = edt.getText().toString();
		switch (view.getId()){
			case R.id.butDot:number+=".";break;
			case R.id.but0:number+="0";break;
			case R.id.but1:number+="1";break;
			case R.id.but2:number+="2";break;
			case R.id.but3:number+="3";break;
			case R.id.but4:number+="4";break;
			case R.id.but5:number+="5";break;
			case R.id.but6:number+="6";break;
			case R.id.but7:number+="7";break;
			case R.id.but8:number+="8";break;
			case R.id.but9:number+="9";break;
			case R.id.butPlusMinus:number="-"+number;break;
		}
		edt.setText(number);
	}
	public void operatorEvent(View view) {
		isEmpty = true;
		numOld = edt.getText().toString();
		switch (view.getId()){
			case R.id.butDivide:op = "/"; break;
			case R.id.butMultiply:op = "*"; break;
			case R.id.butPlus:op = "+"; break;
			case R.id.butMinus:op = "-"; break;
		}
	}
	public void equalEvent(View view) {
		String numNew = edt.getText().toString();
		double result = 0.0;
		switch (op){
			case "+":
				result=Double.parseDouble(numOld)+Double.parseDouble(numNew);
				break;
			case "-":
				result=Double.parseDouble(numOld)-
						Double.parseDouble(numNew);
				break;
			case "*":
				result=Double.parseDouble(numOld)*Double.parseDouble(numNew);
				break;
			case "/":
				result=Double.parseDouble(numOld)/Double.parseDouble(numNew);
				break;
		}
		edt.setText(result+"");
	}
	public void clearEvent(View view) {
		edt.setText("0");
		isEmpty = true;
	}
	public void moduloEvent(View view) {
		double num = Double.parseDouble(edt.getText().toString())/100;
		edt.setText(num+"");
		isEmpty=true;
	}
}