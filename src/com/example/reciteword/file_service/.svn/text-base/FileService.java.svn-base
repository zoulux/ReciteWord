package com.example.reciteword.file_service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.util.EncodingUtils;

import com.example.reciteword.R;

import android.R.integer;
import android.app.Activity;
import android.os.Environment;
import android.text.InputFilter.LengthFilter;
import android.widget.Toast;

public class FileService extends Activity {
	  private String foldPath;
	  public FileService(String foldPath){
		   this.foldPath=foldPath;
	   }
	   public String[] readContextLine() throws IOException {
		   
    	   File file=new File(foldPath);
    	   BufferedReader br = null;
    	   StringBuilder sb = new StringBuilder("");
    	   FileReader fr = new FileReader(file);
    	   String [] ss = new String[1001];
    	   int t=0;
		try {
			br=new BufferedReader(fr);
	    	   String temp=null;
	    	   String s="";
	    	   while((temp=br.readLine())!=null){
	    		   ss[t]=temp;
	    	    t++;
	    	   }
	    	   //String ss[]= s.split("\n");
	    	//   for (int i = 0; i < t; i++) {
			//	ss[i]=EncodingUtils.getString(sb.toString().getBytes(), "UTF-8");
			//}
	    	   return ss;
		} catch (FileNotFoundException e) {
			Toast.makeText(FileService.this,"读取文件出错",1).show();
			e.printStackTrace();
		}finally{
			if (br!=null) {
				try {
					br.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		}
		   return null;
	   }
	   public String readContextFromSdcard(String fileName) {

			File root = Environment.getExternalStorageDirectory();
			FileInputStream inputStream = null;
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			if (Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) {
				File file = new File(root.getAbsolutePath() + "/txt/");
				File file2 = new File(file, fileName);
				int len = 0;
				byte[] data = new byte[1024];
				if (file2.exists()) {
					try {
						inputStream = new FileInputStream(file2);
						while ((len = inputStream.read(data)) != -1) {
							outputStream.write(data, 0, len);
						}
						for (int i = 0; i < data.length; i++) {
							
						}
						return new String(outputStream.toByteArray());
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} finally {
						if (inputStream != null) {
							try {
								inputStream.close();
							} catch (Exception e2) {
								e2.printStackTrace();
							}
						}

					}

				}
			}
			return null;
		}
	   
	
	 
}
