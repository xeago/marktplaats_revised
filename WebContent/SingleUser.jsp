<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<h1>${User.username}</h1>
<p>${User.woonplaats} - ${User.email}</p>
<ul>
	<c:forEach var="advertisement" items="${Advertisements}">
		<li><a href="advertisements?id=${advertisement.id}">
				${advertisement.title} - ${advertisement.title}</a>
		<p>${advertisement.description}</p></li>
	</c:forEach>
</ul>

<%@include file="footer.jsp"%>