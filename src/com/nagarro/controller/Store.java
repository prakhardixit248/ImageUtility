package com.nagarro.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.nagarro.model.*;
import java.io.*;
import org.hibernate.Transaction;


@WebServlet("/store")
public class Store extends HttpServlet 
{
	RequestDispatcher rdObj = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
     Session session = sessionFactory.openSession();
     Transaction t=session.beginTransaction();
     Image image=new Image();
     image.setTitle(request.getParameter("description"));
     image.setImage(request.getParameter("img").getBytes());
     session.save(image);
     t.commit();
     session.close();
     rdObj=request.getRequestDispatcher("lists.jsp");	
     rdObj.forward(request, response);
}

}
