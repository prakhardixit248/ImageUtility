<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.cfg.Configuration
,java.io.*,org.hibernate.Transaction,com.nagarro.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session hibsession = sessionFactory.openSession();
Transaction t=hibsession.beginTransaction();
Image image=hibsession.get(Image.class, Long.parseLong(request.getParameter("id")));
%>
<form action="edit" method="post">
<input type="hidden" name="id" value=<%out.print(image.getId()); %>>
<input type="text" name="title" value=<%out.print(image.getTitle());%>>
<img src="data:image/*;<%out.print(image.getImage().toString());%>" width="40" height="30"/>
<input type="submit"/>
</form>
</body>
</html>