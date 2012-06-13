<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<form action="AdvertisementServlet" method="POST">
	   <input type="hidden" name="save_id" value="${Advertisement.id}" />
		Titel: <input name="Title" type="text" value="${Advertisement.title}"/>
		Prijs: <input name="Price" type="text" value="${Advertisement.price}" />
        Beschrijving: <textarea name="Description">${Advertisement.description}</textarea>
		<input type="submit" value="Save">
	</form>
	<form action="AdvertisementServlet" method="POST">
		<input type="hidden" name="delete_id" value="${Advertisement.id}" />
		<input type="submit" value="Delete">
	</form>
	<form action="AdvertisementServlet" method="POST">
		<input type="hidden" name="sold_id" value="${Advertisement.id}" />
		<input type="submit" value="Markeren als verkocht">
	</form>
</body>
</html>