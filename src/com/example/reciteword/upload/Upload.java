package com.example.reciteword.upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import com.bmob.BmobConfiguration;
import com.bmob.BmobPro;
import com.bmob.BmobProFile;
import com.bmob.btp.callback.DownloadListener;
import com.bmob.btp.callback.UploadBatchListener;
import com.bmob.btp.callback.UploadListener;
import com.example.reciteword.R;

public class Upload extends Activity {
	private EditText editTextPath,editTextWord ;
	private TextView showTV;
	private List<String> list;
	private Vector<String> downPathVector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload);
		Bmob.initialize(this, "c6d37f5caefc8bd3b8d40c4cae9de289");
		editTextPath = (EditText) findViewById(R.id.EditTextpath);
		editTextWord=(EditText) findViewById(R.id.selectWord);
		BmobConfiguration config = new BmobConfiguration.Builder(Upload.this)
				.customExternalCacheDir("ClassFour").build();
		BmobPro.getInstance(Upload.this).initConfig(config);

		list = new ArrayList<String>();
		showTV = (TextView) findViewById(R.id.textViewShowName);
		downPathVector = new Vector<String>();
	}

	public void upload(View view) {
		String folder = editTextPath.getText().toString();
		String fileName[] = new String[11];
		String txt = folder + "/data4.txt";
		for (int i = 0; i < 10; i++) {
			int t = i + 1;
			fileName[i] = folder + "/m" + t + ".mp3";
			//System.out.println(fileName[i]);
		}
		BmobProFile.getInstance(Upload.this).upload(txt, new UploadListener() {

			@Override
			public void onError(int arg0, String arg1) {
				Toast.makeText(Upload.this, "文本上传失败" + arg1, 1).show();
			}

			@Override
			public void onProgress(int arg0) {
				System.out.println("onProgress" + arg0);

			}

			@Override
			public void onSuccess(String arg0, String arg1) {
				Toast.makeText(Upload.this, "文本上传成功", 1).show();
			}
		});

		BmobProFile.getInstance(Upload.this).uploadBatch(fileName,
				new UploadBatchListener() {

					@Override
					public void onError(int arg0, String arg1) {
						Toast.makeText(Upload.this, "声音上传失败", 1).show();
					}

					@Override
					public void onSuccess(boolean arg0, String[] arg1,
							String[] arg2) {
						Toast.makeText(Upload.this, "声音上传成功", 1).show();
						list = Arrays.asList(arg1);
					}

					@Override
					public void onProgress(int arg0, int arg1, int arg2,
							int arg3) {
						// TODO Auto-generated method stub

					}
				});
	}

	public void getSource(String click) {
//		if (click.equals("click4")) {
//
//		}
	//	downPathVector.clear();
		// int dt;
		for (int dt = 0; dt < 10; dt++) {
		//	 ThreadSleep();
			// int t=dt%10;
			BmobQuery<Mp3Audio> query = new BmobQuery<Mp3Audio>();
			query.addWhereEqualTo("id", dt+1);
			Log.i("dt", dt+"");
			query.findObjects(Upload.this, new FindListener<Mp3Audio>() {

				@Override
				public void onSuccess(List<Mp3Audio> Mp3Audios) {
					String path = Mp3Audios.get(0).getPathName();
					//downPathVector.add(path);
					// downPathList.
					download(path);
					// Toast.makeText(Upload.this, ""+path, 1).show();
				//	 Log.i("index", downPathVector.get(0));
				 Log.i("path", path);
				 

				}

				@Override
				public void onError(int arg0, String arg1) {
					Log.i("erro", arg1);
				}
			});

		}
//		Log.i("path1", downPathVector.size() + "");
		Log.i("tset", ">>>>>>>");
		// System.out.println(">>>>>>>>>>>>");
	//	download(downPathVector);
		// return null;

	}

	private void ThreadSleep() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
		
//		
//		new Thread() {
//			public void run() {
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			};
//		}.start();
	}
public void playMusic(String musicPath) {
	MediaPlayer player=MediaPlayer.create(Upload.this, Uri.parse(musicPath));
//	try {
//		player.prepare();
//	} catch (IllegalStateException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	player.start();
//	player.release();
}
	
	
	public void download(String downPaths) {
		BmobProFile BPF = BmobProFile.getInstance(Upload.this);


			BPF.download(downPaths, new DownloadListener() {
				@Override
				public void onSuccess(String fullPath) {
					// TODO Auto-generated method stub
				//	Toast.makeText(Upload.this, "下载成功:" + fullPath, 1).show();
					// System.out.println(fullPath);
					playMusic(fullPath);
				//	Log.i("tag", fullPath);
				}

				@Override
				public void onProgress(String localPath, int percent) {
					// TODO Auto-generated method stub
					// BmobLog.i("MainActivity -download-->onProgress :"+percent);

				}

				@Override
				public void onError(int statuscode, String errormsg) {
					// TODO Auto-generated method stub

					Toast.makeText(Upload.this, "下载出错" + errormsg, 1).show();
				}
			});

		

	}

	public void click4(View view) {

	//	getSource("click4");
		
		
		
		
		BmobQuery<Mp3Audio> query = new BmobQuery<Mp3Audio>();
		query.addWhereEqualTo("realName","absorb");
		query.findObjects(Upload.this, new FindListener<Mp3Audio>() {

			@Override
			public void onSuccess(List<Mp3Audio> ClassFourMp3s) {
				String path = ClassFourMp3s.get(0).getPathName();
				//downPathVector.add(path);
				// downPathList.
				download(path);
				Toast.makeText(Upload.this, ""+path, 1).show();
			//	 Log.i("index", downPathVector.get(0));
			 Log.i("path", path);
			}

			@Override
			public void onError(int arg0, String arg1) {
				Log.i("erro", arg1);
			}
		});
	
		//MediaPlayer.create(Upload.this, Uri.parse(uriString))
	}
		
		
		
		
		
		
		
		
		
	
		
		
		
	public void selectThis(View view) {
		
		String word	=editTextWord.getText().toString();
		BmobQuery<Mp3Audio> query = new BmobQuery<Mp3Audio>();
		query.addWhereEqualTo("realName",word);
	
		query.findObjects(Upload.this, new FindListener<Mp3Audio>() {

			@Override
			public void onSuccess(List<Mp3Audio> ClassFourMp3s) {
				String path = ClassFourMp3s.get(0).getPathName();
				//downPathVector.add(path);
				// downPathList.
				download(path);
				Toast.makeText(Upload.this, ""+ClassFourMp3s.get(0).getRealName(), 1).show();
				Log.i("realName", ClassFourMp3s.get(0).getRealName());
				Log.i("pathName", ClassFourMp3s.get(0).getPathName());
			// Log.i("path", path);
			}

			@Override
			public void onError(int arg0, String arg1) {
				Log.i("erro", arg1);
			}
		});

		
	}
	


	public void showName(View view) {
		showTV.setText(list.toString());
	}

	public void addSQL(View view) {
		Mp3Audio CFMP3 = new Mp3Audio();

		for (int i = 1; i < 11; i++) {
			CFMP3.setId(i);
		
			CFMP3.setPathName(list.get(i - 1));

			CFMP3.save(Upload.this, new SaveListener() {

				@Override
				public void onFailure(int arg0, String arg1) {
					// TODO Auto-generated method stub
					Toast.makeText(Upload.this, "提交数据库成功", 1).show();
				}

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub
					Toast.makeText(Upload.this, "提交数据库失败", 1).show();
				}
			});

		}

	}
}