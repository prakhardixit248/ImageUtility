package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Image;

@WebServlet("/delete")
public class Delete extends HttpServlet 
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
     long id=Long.parseLong(request.getParameter("id"));
     Image image=session.get(Image.class, id);
     session.delete(image);
     t.commit();
     session.close();
     rdObj=request.getRequestDispatcher("lists.jsp");	
     rdObj.forward(request, response);
}
}
