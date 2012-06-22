<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp" %>

<ul>
	<c:forEach var="user" items="${Users}">
		<li><a href="users?id=${user.id}"> ${user.username} </a>
			<p>${user.email}</p></li>
	</c:forEach>
</ul>

<%@include file="footer.jsp" %>
