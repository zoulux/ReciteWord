package com.example.reciteword.main.setting.download;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.example.reciteword.R;
import com.example.reciteword.classes.ClassFour;
import com.example.reciteword.classes.ClassSix;
import com.example.reciteword.file_service.FileFlag;
import com.example.reciteword.main.Main;
import com.example.reciteword.main.word.WordFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DownLoadPage extends Activity {
    private ListView downLoadPageList;
    private ArrayAdapter<String>adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.download_page);
		downLoadPageList = (ListView)findViewById(R.id.downLoadPageList);
		adapter=new ArrayAdapter<String>(DownLoadPage.this,
				android.R.layout.simple_list_item_checked,getDataSource());
		downLoadPageList.setAdapter(adapter);
		downLoadPageList.setOnItemClickListener(new OnItemClickListener() {
			FileFlag flag = new FileFlag(DownLoadPage.this);
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				switch (position) {
				case 0:
					File file1 = new File("data/data/com.example.reciteword/files/flag1.txt");
				    if (!file1.exists()) {
				    	flag.saveContentToFile("flag1.txt",Context.MODE_PRIVATE,(1+"").getBytes());
				    	//Toast.makeText(WordFragment.this.getActivity(),"no", 1).show();
				    	Toast.makeText(DownLoadPage.this,"下载四级", 1).show();
						Intent intent = new Intent(DownLoadPage.this,Main.class);
						startActivity(intent);
					}else{
						Toast.makeText(DownLoadPage.this,"四级已下载", 1).show();
					}
					break;
                case 1:
                	File file2 = new File("data/data/com.example.reciteword/files/flag2.txt");
					if (!file2.exists()) {
				    	//Toast.makeText(WordFragment.this.getActivity(),"no", 1).show();
				    	flag.saveContentToFile("flag2.txt",Context.MODE_PRIVATE,(1+"").getBytes());
				    	
				    	Intent intent = new Intent(DownLoadPage.this,Main.class);
						   startActivity(intent);
					}else{
						Toast.makeText(DownLoadPage.this,"六级已下载", 1).show();
					   }
					break;
                case 2:
                	File file3 = new File("data/data/com.example.reciteword/files/flag3.txt");
					if (!file3.exists()) {
				    	//Toast.makeText(WordFragment.this.getActivity(),"no", 1).show();
				    	flag.saveContentToFile("flag3.txt",Context.MODE_PRIVATE,(1+"").getBytes());
				    	
				    	Intent intent = new Intent(DownLoadPage.this,Main.class);
						   startActivity(intent);
					}else{
						Toast.makeText(DownLoadPage.this,"雅思已下载", 1).show();
					   }
	                break;
                case 3:
	
	                break;

				default:
					break;
				}
				
				
			}
		});
	}
	
	public List<String> getDataSource() {
		List<String> list = new ArrayList<String>();
		
			list.add("四级下载");
			list.add("六级下载");
			list.add("雅思下载");
			list.add("托福下载");
			list.add("考研下载");
			list.add("专四下载");
			list.add("专八下载");
			list.add("高考下载");
			list.add("中考下载");
			
		
		return list;
	}

}
