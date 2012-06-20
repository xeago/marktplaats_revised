<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Markplaats Revised</title>
</head>
<body>
<div id="container">
<h1>Marktplaats Revised</h1>
<ul>
<c:forEach var="user" items="${Users}">
	<li><a href="users?id=${user.id}">  ${user.username}  </a><p>${user.email}</p></li></c:forEach>
</ul>
</div>
</body>
</html>