package com.example.reciteword.classes;

import com.example.reciteword.R;
import com.example.reciteword.handle_word_logic.HandleClassFourWord;
import com.example.reciteword.handle_word_logic.HandleClassSixWord;
import com.example.reciteword.main.Main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ClassIelts extends Activity {
	 private TextView word;
     private TextView phoneticSymbols;//音标
     private TextView meanning;
     private TextView sentence;
     private Button play;
     private Button next;
     private Button before;
     private Button back;
     
     private TextView titleText;
 	private ImageButton titleLeft;
 	private ImageButton titleRight;
     private int id =1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.class_ielts);
		word =(TextView)findViewById(R.id.word);
		phoneticSymbols=(TextView)findViewById(R.id.phoneticSymbols);
		meanning = (TextView)findViewById(R.id.meanning);
		sentence = (TextView)findViewById(R.id.sentence);
		play = (Button)findViewById(R.id.play);
		next = (Button)findViewById(R.id.next);
		before = (Button)findViewById(R.id.before);
		back = (Button)findViewById(R.id.back);
		addClickListener();
		initTextView();
		initTitle();
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK){ 
	    	
	    }
	    return true;
	}
	
	/**
	 * 初始化标题栏
	 */
	private void initTitle() {
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
		titleText = (TextView) findViewById(R.id.title_text);
		titleLeft = (ImageButton) findViewById(R.id.title_left);
		titleRight = (ImageButton) findViewById(R.id.title_right);
		// 对imageButton的隐藏
		titleLeft.setVisibility(ImageButton.INVISIBLE);
		titleRight.setVisibility(ImageButton.INVISIBLE);
		// 设置标题文字
		titleText.setText(getString(R.string.class_ielts));
	}
	public void initTextView(){
		   HandleClassSixWord handleClassSixWord = new HandleClassSixWord(1);
		   word.setText(handleClassSixWord.getWord());
		   phoneticSymbols.setText(handleClassSixWord.getPhoneticSymbols());
		   meanning.setText(handleClassSixWord.getMeanning());
		   sentence.setText(handleClassSixWord.getSentence());
	}
	
	public void addClickListener(){
		   play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			       Toast.makeText(ClassIelts.this, "play", Toast.LENGTH_SHORT).show();
				
			}
		});
		   
		   next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HandleClassSixWord handleClassSixWord = new HandleClassSixWord(++id);
				   int max = handleClassSixWord.getWordNum();
				   if (id>max) {
					   --id;
				   Toast.makeText(ClassIelts.this,"最后一个单词",Toast.LENGTH_SHORT).show();
				}else{
				   word.setText(handleClassSixWord.getWord());
				   phoneticSymbols.setText(handleClassSixWord.getPhoneticSymbols());
				   meanning.setText(handleClassSixWord.getMeanning());
				   sentence.setText(handleClassSixWord.getSentence());
				}
			}
		});
		   before.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HandleClassFourWord handleWord = new HandleClassFourWord(--id);
				int min = 0;
				if (id<=min) {
					++id;
					Toast.makeText(ClassIelts.this,"第一个单词",Toast.LENGTH_SHORT).show();
				}else{
				   word.setText(handleWord.getWord());
				   phoneticSymbols.setText(handleWord.getPhoneticSymbols());
				   meanning.setText(handleWord.getMeanning());
				   sentence.setText(handleWord.getSentence());
				}
				
			}
		});
		   back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ClassIelts.this,Main.class);
				intent.putExtra("clasSixFlag", 11);
				startActivity(intent);
				finish();
				
			}
		});
	}
	
}
