package com.example.reciteword.main.word;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.reciteword.R;
import com.example.reciteword.classes.ClassFour;
import com.example.reciteword.classes.ClassIelts;
import com.example.reciteword.classes.ClassSix;
import com.example.reciteword.file_service.FileFlag;
import com.example.reciteword.main.Main;
import com.example.reciteword.main.setting.download.DownLoadPage;

import android.support.v4.app.Fragment;
import android.R.integer;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.AvoidXfermode.Mode;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class WordFragment extends Fragment{
	public ListView listWord;
    private int downLoadFlag=0;
    private Button downLoadButton;
    private AlertDialog.Builder diaFour;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.activity_word, container,false);
		 FileFlag flag = new FileFlag(WordFragment.this.getActivity());
		 
		
		 File file3 = new File("data/data/com.example.reciteword/files/flag3.txt");
		File file4 = new File("data/data/com.example.reciteword/files/flag4.txt");
		File file5 = new File("data/data/com.example.reciteword/files/flag5.txt");
		File file6 = new File("data/data/com.example.reciteword/files/flag6.txt");
		File file7 = new File("data/data/com.example.reciteword/files/flag7.txt");
		File file8 = new File("data/data/com.example.reciteword/files/flag8.txt");
		File file9 = new File("data/data/com.example.reciteword/files/flag9.txt");
		
		diaFour = new AlertDialog.Builder(this.getActivity());
		diaFour.setTitle("提示");
		diaFour.setIcon(R.drawable.ic_launcher);
		diaFour.setMessage("确定要下载吗?");
		diaFour.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int whitch) {
				        Intent intent = new Intent(WordFragment.this.getActivity(),DownLoadPage.class);
				        startActivity(intent);
				
			}
		});
		diaFour.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				   Toast.makeText(WordFragment.this.getActivity(),"取消下载", 1).show();
				
			}
		});
		 
		listWord = (ListView)root.findViewById(R.id.listWord);
		
			
		//	int t1 = Integer.parseInt(flag.readContentFromFile("flag1.txt"));
		//	if (t1==0) {
		//		flag.saveContentToFile("flag.txt",Context.MODE_PRIVATE,(0+"").getBytes());
				//int allflag=Integer.parseInt(flag.readContentFromFile("flag.txt"));
		//	}
			
//		    if (allflag!=0) {
//		    	flag.saveContentToFile("flag.txt",Context.MODE_PRIVATE,(1+"").getBytes());
//			    
//		    }
		//System.out.println(flag.readContentFromFile("flag.txt"));
		
		List<Map<String,String>>list = new ArrayList<Map<String,String>>();
		Map<String, String>map1 = new HashMap<String, String>();
		Map<String, String>map2 = new HashMap<String, String>();
		Map<String, String>map3 = new HashMap<String, String>();
		Map<String, String>map4 = new HashMap<String, String>();
		Map<String, String>map5 = new HashMap<String, String>();
		Map<String, String>map6 = new HashMap<String, String>();
		Map<String, String>map7 = new HashMap<String, String>();
		Map<String, String>map8 = new HashMap<String, String>();
			
			
			// int res= Integer.parseInt(flag.readContentFromFile("flag.txt"));
			    
					
				
					map1.put("itemRight","四级");
					map1.put("itemLeft","1000");
					map2.put("itemRight","六级");
					map2.put("itemLeft","1500");
					map3.put("itemRight","雅思");
					map3.put("itemLeft","2000");
					map4.put("itemRight","托福");
					map4.put("itemLeft","2500");
					map5.put("itemRight","考研词汇");
					map5.put("itemLeft","3000");
					map6.put("itemRight","专四");
					map6.put("itemLeft","3500");
					map7.put("itemRight","专八");
					map7.put("itemLeft","4000");
					map8.put("itemRight","高考");
					map8.put("itemLeft","4100");
					list.add(map1);
					list.add(map2);
					list.add(map3);
					list.add(map4);
					list.add(map5);
					list.add(map6);
					list.add(map7);
					list.add(map8);
				SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity().getApplicationContext(),
						list,
						R.layout.word_item,
						 new String[]{"itemRight","itemLeft"}, 
		                 new int[]{R.id.listWordItem1,R.id.listWordItem2});
				listWord.setAdapter(simpleAdapter);
				
				 listWord.setOnItemClickListener(new OnItemClickListener() {
					   
					    FileFlag flag = new FileFlag(WordFragment.this.getActivity());
					    //int allflag=Integer.parseInt(flag.readContentFromFile("flag.txt"));
						@Override
						public void onItemClick(AdapterView<?> parent, View view, int position,
								long id) {
							//Toast.makeText(Main.class,"-->>",Toast.LENGTH_SHORT).show();
							if (position==0) {
								File file1 = new File("data/data/com.example.reciteword/files/flag1.txt");
								    if (!file1.exists()) {
								    	diaFour.show();
									}else{
									Intent intent = new Intent(WordFragment.this.getActivity(),ClassFour.class);
								    startActivity(intent);
									}
							   
							}else if (position==1) {
								File file2 = new File("data/data/com.example.reciteword/files/flag2.txt");
								if (!file2.exists()) {
							    	diaFour.show();
								}else{
								   Intent intent = new Intent(WordFragment.this.getActivity(),ClassSix.class);
								   startActivity(intent);
								   }
							}else if (position==2) {
								File file3 = new File("data/data/com.example.reciteword/files/flag3.txt");
								if (!file3.exists()) {
							    	diaFour.show();
								}else{
								   Intent intent = new Intent(WordFragment.this.getActivity(),ClassIelts.class);
								   startActivity(intent);
								   }
							}
							
						}
					});
		return root;
	
	}
	
}
