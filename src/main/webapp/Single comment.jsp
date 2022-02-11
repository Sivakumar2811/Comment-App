<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<fieldset>
<h><b>Comments</h>

<p align="right">
<a href="Show comments.jsp"><input type="button" value="Back"></a>
</p>

<fieldset>
<%
try{
    Class.forName("com.mysql.jdbc.Driver");

    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/comment","root","7558");

    String q = "select * from login where Email=?";
    
	PreparedStatement ps = c.prepareStatement(q);
	ps.setString(1, (String) session.getAttribute("email"));
	ResultSet rs = ps.executeQuery();
	if (rs.next())
	{
		%>
		<table style="border:1px solid black">
		<tr><%=rs.getString("Email")%>
		<td><%=rs.getString("Comment")%></td></tr>
		</table>
		<br>
		<%
	}
}catch (Exception e) {
	e.getStackTrace();
} 
%>
</fieldset>

</fieldset>

</body>
</html>