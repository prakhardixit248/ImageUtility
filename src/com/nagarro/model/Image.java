package com.nagarro.model;

import javax.persistence.JoinColumn;

import org.hibernate.annotations.Table;

import com.mysql.cj.jdbc.Blob;

public class Image 
{
	long id;
	
	private String title;

	private byte[] image;
	
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public String getTitle() {
		return title;
	}
	

	public long getId() {
		return id;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	
}
