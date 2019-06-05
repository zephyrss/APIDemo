package com.lawstar.Pojo;

public class SearchPojo {
	private String title; //标题
	private String content; //正文
	private int cp; //页数
	private int pagesize; //每页显示的数量
	
	private  String ssort;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public String getSsort() {
		return ssort;
	}
	public void setSsort(String ssort) {
		this.ssort = ssort;
	}
	
	
}
