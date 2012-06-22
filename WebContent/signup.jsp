<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="signupServlet" method=POST>
    <p><strong>Please Enter Your User Name: </strong>
    <input type="text" name="u_username" size="25">
    <p><p><strong>Please Enter Your Password: </strong>
    <input type="password" size="15" name="u_email">
    <p><p><strong>Please Enter Your Email: </strong>
    <input type="text" size="15" name="u_email"><p><p>
    <p><p><strong>Please Enter Your Home location: </strong>
    <input type="text" size="15" name="u_home"><p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>