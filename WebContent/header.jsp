<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="/marktplaats_revised/" />
<title>Markplaats Revised</title>
</head>
<body>
	<div id="header">
		<a href="/marktplaats_revised">Voorpagina</a>
		<c:choose>
			<c:when test="${not empty pageContext.request.userPrincipal}">
				<a href="logout">Uitloggen</a>
				<a href="adminUser?id=${pageContext.request.userPrincipal}">${pageContext.request.userPrincipal}</a>
			</c:when>
			<c:otherwise>
				<a href="signup.jsp">Sign up</a>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="container">
		<h1>Marktplaats Revised</h1>