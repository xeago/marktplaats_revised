<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>
<h1>${Advertisement.title} - ${Advertisement.price}</h1>

Adverteerder: 
${Advertisement.advertiser.username},
${Advertisement.advertiser.email},
${Advertisement.advertiser.woonplaats}.

<p>${Advertisement.description}</p>

<a href="mailto:${Advertisement.advertiser.email}?subject=Reactie via marktplaats_revised op '${Advertisement.title}'">Neem contact op</a>
</div>
</body>
</html>