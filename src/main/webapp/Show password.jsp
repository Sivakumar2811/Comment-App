<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show passeord</title>
</head>
<body>

<fieldset style="background-color:gainsboro">
<legend><b>Your password</b></legend>

      <%
      String email = request.getParameter("email");
      String password = (String) session.getAttribute("password");
      out.print("<blockquote>Email = "+email+"<br>Password = "+password+"</blockquote>");
      
      out.print("This is your password note it.");
      %>

<br>
<br>           
<b>Click to go sign-in page</b>
<a href="Sign In.html"><button>Sign in</button></a>

</fieldset>

</body>
</html>