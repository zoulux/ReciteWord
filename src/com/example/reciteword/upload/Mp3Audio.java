package com.example.reciteword.upload;

import cn.bmob.v3.BmobObject;

public class Mp3Audio extends BmobObject {
	private int id;
	private String pathName;
	private String realName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPathName() {
		return pathName;
	}
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}



	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Mp3Audio() {
		// TODO Auto-generated constructor stub
	}

}
