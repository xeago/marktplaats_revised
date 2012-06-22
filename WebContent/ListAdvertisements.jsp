<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

<a href="AddAdvertisement.jsp">Voeg een advertentie toe</a>

<ul>
	<c:forEach var="advertisement" items="${Advertisements}">
		<li><a href="advertisements?id=${advertisement.id}">
				${advertisement.title} </a>
		<p>${advertisement.description}</p></li>
	</c:forEach>
</ul>


<%@include file="footer.jsp"%>