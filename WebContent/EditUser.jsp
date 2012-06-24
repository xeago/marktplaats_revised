<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="header.jsp" %>

		<a class="terugLink" href="users">Terug</a>
		<form action="users" method="POST">
			<input type="hidden" name="save_id" value="${User.id}" />
			<div class="FormRow">
				<div class="FormColumn1">Gebruikersnaam</div>
				<div class="FormColumn2">
					<input name="Title" class="CommonTextXL" type="text"
						value="${User.username}" />
				</div>
			</div>
			<div class="FormRow">
				<div class="FormColumn1">E-mail adres</div>
				<div class="FormColumn2">
					<input name="Email" class="CommonTextXXL" class="CommonTextM"
						type="text" value="${User.email}" />
				</div>
			</div>
			<div class="FormRowTxt">
				<div class="FormColumn1">Oud Wachtwoord</div>
				<div class="FormColumn2">
					<input class="CommonTextM" name="oldpassword" type="password"
						value="" />
				</div>
			</div>
			<div class="FormRow">
				<div class="FormColumn1">Nieuw Wachtwoord</div>
				<div class="FormColumn2">
					<input class="CommonTextM" name="newpassword" type="password"
						value="${User.password}">
				</div>
			</div>
			<input type="submit" value="Opslaan">
		</form>

		<form action="users" method="POST">
			<input type="hidden" name="delete_id" value="${User.id}" /> <input
				type="submit" value="Verwijderen">
		</form>
<%@include file="footer.jsp" %>