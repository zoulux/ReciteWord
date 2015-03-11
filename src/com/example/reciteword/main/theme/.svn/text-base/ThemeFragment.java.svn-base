package com.example.reciteword.main.theme;

import java.util.ArrayList;
import java.util.List;

import com.example.reciteword.R;
import com.example.reciteword.R.color;
import com.example.reciteword.R.drawable;
import com.example.reciteword.main.Main;

import android.support.v4.app.Fragment;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ThemeFragment extends Fragment{
	private ListView listTheme;
	private ArrayAdapter<String>adapter;
	public int ThemePosition;
	private LinearLayout linearLayoutbg;
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		linearLayoutbg = (LinearLayout)this.getActivity().findViewById(R.id.backGroundID);
	}
  public List<String> getData(){
	  List<String>list = new ArrayList<String>();
	  
		list.add("Golden");
		list.add("Sky blue");
		list.add("mediumpurple");
		list.add("lightgreen");
		list.add("lime");
		list.add("black");
	  return list;
  }
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.activity_theme, container,false);
		listTheme = (ListView)root.findViewById(R.id.listTheme);
		//linearLayoutbg = (LinearLayout)root.findViewById(R.id.backGroundID);
		
		
		listTheme.setChoiceMode(listTheme.CHOICE_MODE_SINGLE);
		adapter = new ArrayAdapter<String>(ThemeFragment.this.getActivity(),android.R.layout.simple_list_item_single_choice
				, getData());
		listTheme.setAdapter(adapter);
		listTheme.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				  System.err.println(id);
				//ThemePosition = position;
				//System.out.println(position);
				if (position==0) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.gold));
				}else if (position==1) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.SkyBlue));
				}else if (position==2) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.mediumpurple));
				}
				else if (position==3) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.lightgreen));
				}
				else if (position==4) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.lime));
				}else if (position==5) {
					linearLayoutbg.setBackgroundColor(getResources().getColor(R.color.black));
				}
				//System.out.println(position);
				
				
				
			}
		});
		return root;
	}
}
