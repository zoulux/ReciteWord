package com.example.reciteword.handle_word_logic;

import java.io.FileReader;
import java.io.IOException;

import com.example.reciteword.file_service.FileService;

import android.R.integer;

public class HandleClassSixWord {
      
       private int id;
       private final int CLASS_SIX_WORD_NUM=6;
       private final String CLASS_FOUR_WORD_PATH="mnt/sdcard/txt/aa.txt";
       public HandleClassSixWord(int id){
    	   this.id=id;
       }
       public int getWordNum(){
    	   
    	   return CLASS_SIX_WORD_NUM;
       }
       public String getWord(){
    	   FileService service = new FileService(CLASS_FOUR_WORD_PATH);
    	   String[] s1= new String[1001]; 
    	   try {
			s1 = service.readContextLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   int tot=0;
    	   for (int i = 1; i <id; i++) {
			    tot+=3;
		   }
    	   return s4[(id+2)+tot];
    	   
       }
	
	
}
