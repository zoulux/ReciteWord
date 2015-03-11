package com.example.reciteword.main;

import java.util.ArrayList;

import com.example.reciteword.R;
import com.example.reciteword.classes.ClassSix;
import com.example.reciteword.handle_word_logic.HandleClassFourWord;
import com.example.reciteword.main.about.AboutFragment;
import com.example.reciteword.main.setting.SettingFragment;
import com.example.reciteword.main.theme.ThemeFragment;
import com.example.reciteword.main.word.WordFragment;

import android.R.integer;
import android.R.string;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends FragmentActivity{
	private ViewPager viewPager;
	private ArrayList<PagerItem> pagerItems;
	private MainAdapter adapter;
	private RadioGroup radioGroup;
	private int position;
    private long exitTime = 0;
    public TextView yourClass;
    private TextView wordNumber;
    private TextView alreadyLearn;
    private TextView alreadyMaster;
    
    private TextView titleText;
	private ImageButton titleLeft;
	private ImageButton titleRight;
    private final int CLASS_FOUR_WORD_NUM=4;
    private final int CLASS_SIX_WORD_NUM=6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.main);
		findMainId();
		initTitle();
		initializeYourResult();
		showYourResult();
		initPageItem();
		initPageList();
		initRadioGroup();
		
	}
	public void findMainId(){
		yourClass=(TextView)findViewById(R.id.yourClass);
	    wordNumber=(TextView)findViewById(R.id.wordNum);
        alreadyLearn=(TextView)findViewById(R.id.alreadyLearnNum);
        alreadyMaster=(TextView)findViewById(R.id.alreadyMasterNum);
	}
	public void initializeYourResult(){
		yourClass.setText("零级");
		wordNumber.setText("0");
		alreadyLearn.setText("0");
		alreadyMaster.setText("0");
		   
	}
    public void showYourResult(){
    	  Intent intent=getIntent();
    	  int classFourFlag = intent.getIntExtra("classFourFlag",0);
    	  int classSixFlag = intent.getIntExtra("clasSixFlag",0);
    	  if (classFourFlag==11) {
    		  yourClass.setText("四级");
    		  
    		  wordNumber.setText(CLASS_FOUR_WORD_NUM+"");
		  }
    	  if (classSixFlag==11) {
    		  yourClass.setText("六级");
    		  
    		  wordNumber.setText(CLASS_SIX_WORD_NUM+"");
		  }

    }
   
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){   
	        if((System.currentTimeMillis()-exitTime) > 2000){  
	            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
	            exitTime = System.currentTimeMillis();   
	        } else {
	        	System.getSecurityManager().getThreadGroup().stop();
	        }
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
		titleText.setText(getString(R.string.main_title));
	}
	private void initPageItem() {
		pagerItems = new ArrayList<PagerItem>();
		pagerItems.add(new PagerItem((RadioButton) findViewById(R.id.word),
				new WordFragment()));
		pagerItems.add(new PagerItem((RadioButton) findViewById(R.id.setting),
				new SettingFragment()));
		pagerItems.add(new PagerItem((RadioButton) findViewById(R.id.theme),
				new ThemeFragment()));
		pagerItems.add(new PagerItem((RadioButton) findViewById(R.id.about),
				new AboutFragment()));
		ThemeFragment themeFragment = new ThemeFragment();
		position=themeFragment.ThemePosition;

	}

	private void initRadioGroup() {
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int checkedId) {
				for (int i = 0; i < pagerItems.size(); i++) {
					if (pagerItems.get(i).radioButton.getId() == checkedId) {
						viewPager.setCurrentItem(i);
						break;
					}
				}

			}
		});
	}

	public void initPageList() {
		viewPager = (ViewPager) findViewById(R.id.viewPage);
		adapter = new MainAdapter(getSupportFragmentManager());
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				int i = 0;
				for (PagerItem items : pagerItems) {
					if (i == arg0) {
						pagerItems.get(i).radioButton.setChecked(true);
					} else {
						pagerItems.get(i).radioButton.setChecked(false);
					}
					i++;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
                        
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});

	}

	public class MainAdapter extends FragmentPagerAdapter {
           
		public MainAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public android.support.v4.app.Fragment getItem(int arg0) {
			position=arg0;
			return pagerItems.get(arg0).fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return pagerItems.size();
		}

	}
  
	public class PagerItem {
		public RadioButton radioButton;
		public android.support.v4.app.Fragment fragment;

		public PagerItem(RadioButton radioButton,android.support.v4.app.Fragment fragment) {
			this.radioButton = radioButton;
			this.fragment = fragment;
		}
	}

	

}
