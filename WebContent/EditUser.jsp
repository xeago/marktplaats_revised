<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp"%>

<a class="terugLink" href="users">Terug</a>
<h1>${User}</h1>
<form action="adminUser" method="POST">
	<input type="hidden" name="save_id" value="${User.id}" /> <input
		type="hidden" name="save_username" value="${User.username}" />
	<div class="FormRow">
		<div class="FormColumn1">E-mail adres</div>
		<div class="FormColumn2">
			<input name="Email" class="CommonTextXXL" class="CommonTextM"
				type="text" value="${User.email}" />
		</div>
	</div>
	<div class="FormRow">
		<div class="FormColumn1">Woonplaats</div>
		<div class="FormColumn2">
			<input name="Woonplaats" class="CommonTextXXL" class="CommonTextM"
				type="text" value="${User.woonplaats}" />
		</div>
	</div>
	<div class="FormRow">
		<div class="FormColumn1">Wachtwoord</div>
		<div class="FormColumn2">
			<input class="CommonTextM" name="Password" type="password"
				value="${User.password}">
		</div>
	</div>
	<input type="submit" value="Opslaan">
</form>

<form action="adminUser" method="POST">
	<input type="hidden" name="delete_id" value="${User.id}" /> <input
		type="hidden" name="delete_username" value="${User.username}" /> <input
		type="submit" value="Verwijderen">
</form>

<%@include file="footer.jsp"%>