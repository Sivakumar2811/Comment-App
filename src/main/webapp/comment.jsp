<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
</head>
<body>

<fieldset style="background-color:gainsboro">
<p>What would you like to share with world?</p>

<form action="Comment" method="post">
<textarea name="comment" rows="10" cols="80"  placeholder="Enter text here..."></textarea>
<p align="center">
<input type="submit" value="Submit">
</p>
</form>
<br>
<iframe src="Show comments.jsp" title="Comments" height="250" width="1000" style="background-color:white">
</iframe>

</fieldset>

</body>
</html>