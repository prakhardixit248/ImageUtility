package com.nagarro.controller;

import java.io.*;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myuser")
public class MyUser extends HttpServlet 
{
	InputStream inputStream;
	
	Properties prop;
	
	RequestDispatcher rdObj = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		prop=new Properties();
		
		String propFileName="user.properties";
		
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		 
		if (inputStream != null) 
		{
			prop.load(inputStream);
		} 
		else 
		{
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		
		String name=prop.getProperty("name") , password=prop.getProperty("password") ,rname=request.getParameter("name") , rpassword=request.getParameter("password");
		
		if(name.equals(rname) && password.equals(rpassword))
		{
			rdObj=request.getRequestDispatcher("lists.jsp");
			
			rdObj.forward(request, response);
			
		}
	}

}
