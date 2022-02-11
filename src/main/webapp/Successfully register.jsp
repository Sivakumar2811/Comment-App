<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<fieldset>
<legend><b>Your given Data :</b></legend>
   
   <% 
      String email = request.getParameter("email");
      String password = request.getParameter("password");
      String secret = request.getParameter("secret");
      
      out.print("<blockquote>Email = "+email+"<br>Password = "+password+"<br>Secret= "+secret+"</blockquote>");
      
      out.print("Your entry is sucessfully register");
   %>
   
</fieldset>
<b>If you want to go back to sign-in page</b>
<a href="Sign In.html"><button>Sign-in</button></a>

</body>
</html>