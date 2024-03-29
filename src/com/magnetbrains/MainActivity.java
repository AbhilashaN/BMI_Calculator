package com.magnetbrains;

import com.magnetbrains.R;

import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText e1 = (EditText) findViewById(R.id.et1);
		final EditText e2 = (EditText) findViewById(R.id.et2);
		final TextView tv4 = (TextView) findViewById(R.id.tv4);
		Button b1 =(Button)findViewById(R.id.ib1);
		//when button clicked
         b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String str1 = e1.getText().toString();
				String str2 = e2.getText().toString();
				//display error message if no text entered
				if(TextUtils.isEmpty(str1)){
					e1.setError("Please enter your weight");
					e1.requestFocus();
					return;
				}
				
				if(TextUtils.isEmpty(str2)){
					e2.setError("Please enter your height");
					e2.requestFocus();
					return;
				}
				
				float weight = Float.parseFloat(str1);
				float height = Float.parseFloat(str2)/100;
				
				  float bmiValue = calculateBMI(weight, height);
				  
				  String bmiInterpretation = interpretBMI(bmiValue);
				tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
	
			}
		});

	}
	
	 private float calculateBMI (float weight, float height) {
		//calculate BMI
	     return (float) (weight / (height * height));
	    }

	// interpret what BMI means
	    private String interpretBMI(float bmiValue) {

	     if (bmiValue < 16) {
	      return "Severely underweight";
	     } else if (bmiValue < 18.5) {

	      return "Underweight";
	     } else if (bmiValue < 25) {

	      return "Normal";
	     } else if (bmiValue < 30) {

	      return "Overweight";
	     } else {
	      return "Obese";
	     }

	    }
	
}
