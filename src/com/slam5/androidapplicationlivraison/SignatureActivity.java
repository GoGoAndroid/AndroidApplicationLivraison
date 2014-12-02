package com.slam5.androidapplicationlivraison;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SignatureActivity extends Activity{
	DrawView maSignature;
	
	protected void onCreate(Bundle savedInstanceState)
	{			
		super.onCreate(savedInstanceState);
		setContentView(R.layout.saisie_signature);
		LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
		maSignature = new DrawView(this);
				
		mainLayout.addView(maSignature);
		
		Button effacer = (Button) findViewById(R.id.button1); 
		effacer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				maSignature.points.clear();	
				maSignature.refresh();
			}
			});
	}
}
