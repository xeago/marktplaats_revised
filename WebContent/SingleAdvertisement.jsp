<%@page import="org.apache.jasper.tagplugins.jstl.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<h1>${Advertisement.title} - ${Advertisement.price}</h1>

<p>Verkochtstatus: 
<c:choose>
	<c:when test="${Advertisement.status} == 1"><b>Verkocht</b></c:when>
	<c:otherwise><b>Niet verkocht</b></c:otherwise>
</c:choose>

<p>
Adverteerder: 
${Advertisement.advertiser.username},
${Advertisement.advertiser.email},
${Advertisement.advertiser.woonplaats}
</p>

<p>${Advertisement.description}</p>


<a href="mailto:${Advertisement.advertiser.email}?subject=Reactie via marktplaats_revised op '${Advertisement.title}'&body=Artikellocatie: http://127.0.0.1:8080/marktplaats_revised/advertisements?id=${Advertisement.id}">Neem contact op</a>
<%@ include file="footer.jsp" %>