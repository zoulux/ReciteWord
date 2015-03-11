package com.example.reciteword.initialize;

import java.util.Timer;
import java.util.TimerTask;

import com.example.reciteword.R;
import com.example.reciteword.classes.ClassFour;
import com.example.reciteword.main.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Initialize extends Activity {
	private TimerTask timerTask;
	private Timer timer;
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initialize);
		timerTask = new TimerTask() {
			
			@Override
			public void run() {
				Intent intent = new Intent(Initialize.this,Main.class);
				startActivity(intent);
				finish();
				
			}
		};
		timer = new Timer();
		timer.schedule(timerTask, 2000);
	}
	
}
