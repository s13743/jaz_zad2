<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="signUp" method="get">
		<label>Username:<input type="text" id="username" name="username"/></label><br />
		<label>password:<input type="text" id="password" name="password"/></label><br />
		<label>Confirm password:<input type="text" id="confirmPassword" name="confirmPassword"/></label><br />
		<label>Email:<input type="text" id="email" name="email"/></label><br />
		<input type="submit" value="Sign Up"/>
	</form>
	</br><a href="index.jsp">Return to home page.</a>
</body>
</html>