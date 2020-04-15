<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.util.*,org.hibernate.Session,org.hibernate.SessionFactory,org.hibernate.cfg.Configuration
,java.io.*,org.hibernate.Transaction,com.nagarro.model.*"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.btn {
  background-color: LightGray;
  border: none;
  color: red;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}

.btn:hover {
  background-color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="border:solid black">
<h1 style="align:center ">Image Management Utility</h1>
</div>
<br/><br/>
<form style="border:solid black" action="store" method="post">
Please select an image file to upload(Max Size 1 MB)<br/>
<input type="text" name="description" id="description"/>
<input type="file" id="img" name="img" accept="image/*" onchange="Filevalidation()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="Submit"/>
<input type="reset" value="Cancel" />
<br/><br/>
<%
SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
Session hibsession = sessionFactory.openSession();
Transaction t=hibsession.beginTransaction();
List<Image> list=hibsession.createQuery("from Image").getResultList();
%>
<table>
<tr>
<th>S.No.</th>
<th>Name</th>
<th>Image</th>
<th>Size</th>
<th>Actions</th>
</tr>
<%
for(Image image :list)
{
%>
<tr>
<td><%out.print(image.getId());%></td>
<td><%out.print(image.getTitle()); %></td>
<td>
<td>
<% out.print(image.getImage()); %>
</td>
<td>
<button class="btn" type="submit" formmethod="post" name="id" formaction="edit.jsp" value=<%out.print(image.getId());%>><i class="fa fa-edit"></i></button>
<button class="btn" type="submit" formmethod="post" name="id" formaction="delete" value=<%out.print(image.getId());%>><i class="fa fa-close"></i></button>
</td>
</tr>
<%}%>
</table>
</form>
<script type="text/javascript">
    Filevalidation = () => 
    { 
        const fi = document.getElementById("img"); 
        // Check if any file is selected. 
        if (fi.files.length > 0)
        { 
            for (const i = 0; i <= fi.files.length - 1; i++)
            { 
                const fsize = fi.files.item(i).size; 
                const file = Math.round((fsize / 1024)); 
                // The size of the file. 
                if (file > 1024) 
                { 
                    alert( 
                      "File too Big, please select a file upto 1mb"); 
                }  
            } 
        } 
    } 
</script>
</body>
</html>