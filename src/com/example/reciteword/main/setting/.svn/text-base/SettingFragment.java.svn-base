package com.example.reciteword.main.setting;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract.Root;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.example.reciteword.R;
import com.example.reciteword.main.Main;
import com.example.reciteword.main.setting.download.DownLoadPage;

public class SettingFragment extends Fragment implements OnClickListener{

	private CheckBox isAutoPro;//自动发音
	private CheckBox isLearnToRemind;//学习提醒
    private Button delete;	
    private Notification.Builder builder;
    private NotificationManager manager;
    private AlertDialog.Builder dialog;
    private Button downLoadButton;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View root = inflater.inflate(R.layout.activity_setting,container,false);
		downLoadButton = (Button)root.findViewById(R.id.downLoadButton);
		//final int time = calendar.get(Calendar.SECOND);
		// 获得系统的通知服务
		manager = (NotificationManager)this.getActivity().getSystemService(this.getActivity().NOTIFICATION_SERVICE);
				// 设置通知的属性:至少包含一个小图标，标题，内容
				builder = new Notification.Builder(this.getActivity());
				builder.setTicker("有短信来了");
				builder.setSmallIcon(R.drawable.ic_launcher);
				builder.setContentTitle("晚上有时间吗？");
				builder.setContentText("老地方见!!");
				builder.setAutoCancel(true);
				builder.setVibrate(new long[]{10,10000});
				builder.setDefaults(Notification.DEFAULT_SOUND
						| Notification.DEFAULT_VIBRATE);
				//对话框设置
				dialog =new AlertDialog.Builder(this.getActivity());
				dialog.setTitle("警告框");
				dialog.setIcon(R.drawable.setting);
				dialog.setMessage("您确定要删除吗？");
				dialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int whitch) {
						   Toast.makeText(SettingFragment.this.getActivity(),"确定删除",Toast.LENGTH_SHORT).show();
					}
				});
	            dialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int whitch) {
						   Toast.makeText(SettingFragment.this.getActivity(),"取消删除",Toast.LENGTH_SHORT).show();
					}
				});
		delete = (Button)root.findViewById(R.id.delete);
		isAutoPro = (CheckBox)root.findViewById(R.id.CheckBox1);
		isLearnToRemind = (CheckBox)root.findViewById(R.id.CheckBox2);
		delete.setOnClickListener(this);
		isAutoPro.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean  isChecked) {
				if (isChecked) {
					Toast.makeText(SettingFragment.this.getActivity(),"自动发音已开启",1).show();
				}else{
					Toast.makeText(SettingFragment.this.getActivity(),"自动发音已关闭",1).show();
					
				}
			}
		});
		isLearnToRemind.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean  isChecked) {
				//Thread timer = new Thread();
				
				if (isChecked) {
					new Thread(new Runnable() {
						
						@Override
						public void run() {
							
							try {
								Thread.sleep(2000);
								Intent intent = new Intent(SettingFragment.this.getActivity(),
										Main.class);
								PendingIntent pendingIntent = PendingIntent.getActivity(
										SettingFragment.this.getActivity(), 1, intent,
										PendingIntent.FLAG_ONE_SHOT);
								builder.setContentIntent(pendingIntent);
								manager.notify((int) System.currentTimeMillis(),
										builder.build());
								
							} catch (Exception e) {
								e.printStackTrace();
							}
							
							
						}
					}).start();
					
					}
				else {
					
				}
				
			}	
		});
	downLoadButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(SettingFragment.this.getActivity(),DownLoadPage.class);
	        startActivity(intent);
			
		}
	});
		
        return root;
	}
   //delete操作
	@Override
	public void onClick(View v) {
		dialog.show();
		
	}
	
	

}
