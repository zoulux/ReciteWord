package com.example.reciteword.handle_word_logic;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import com.example.reciteword.R;
import com.example.reciteword.file_service.FileService;

import android.R.integer;
import android.app.Activity;

public class HandleClassFourWord extends Activity{
	
       private int id;
       private final int CLASS_FOUR_WORD_NUM=4;
       private final String CLASS_FOUR_WORD_PATH="mnt/sdcard/txt/aa.txt";
       public HandleClassFourWord(int id){
    	   this.id=id;
       }
       public int getWordNum(){
    	   
    	   return CLASS_FOUR_WORD_NUM;
       }
       public String getWord(){
    	 //  InputStream inputStream = getResources().openRawResource(R.raw.down_load_flag);
    	   FileService service = new FileService(CLASS_FOUR_WORD_PATH);
    	   String[] s1= new String[1001]; 
    	   try {
			s1 = service.readContextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		   //s1=service.readFileInLine(inputStream);
		   //s1=service.readUserAgreementFromAsset(CLASS_FOUR_WORD_PATH);
    	   int tot=0;
    	   for (int i = 1; i <id; i++) {
			    tot+=3;
		   }
    	   return s1[(id-1)+tot];
       }
       public String getPhoneticSymbols(){
    	   FileService service = new FileService(CLASS_FOUR_WORD_PATH);
    	   String[] s2= new String[1001];
    	  
			try {
				s2 = service.readContextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	   //s2=service.readUserAgreementFromAsset(CLASS_FOUR_WORD_PATH);
    	   int tot=0;
    	   for (int i = 1; i <id; i++) {
			    tot+=3;
		   }
    	   return s2[id+tot];
       }
       public String getMeanning(){
    	   FileService service = new FileService(CLASS_FOUR_WORD_PATH);
    	   String[] s3= new String[1001];
    	 
			try {
				s3 = service.readContextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	   //s3=service.readUserAgreementFromAsset(CLASS_FOUR_WORD_PATH);
    	   int tot=0;
    	   for (int i = 1; i <id; i++) {
			    tot+=3;
		   }
    	   return s3[(id+1)+tot];
       }
       public String getSentence(){
    	   FileService service = new FileService(CLASS_FOUR_WORD_PATH);
    	   String[] s4= new String[1001]; 
    	   
			try {
				s4 = service.readContextLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	  // s4=service.readUserAgreementFromAsset(CLASS_FOUR_WORD_PATH);
    	   int tot=0;
    	   for (int i = 1; i <id; i++) {
			    tot+=3;
		   }
    	   return s4[(id+2)+tot];
    	   
       }
	
	
}
