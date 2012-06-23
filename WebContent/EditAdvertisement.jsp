<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="header.jsp" %>
		
		<a class="terugLink" href="advertisements">Terug</a>
		<form action="advertisements" method="POST">
			<input type="hidden" name="save_id" value="${Advertisement.id}" />
			<div class="FormRow">
				<div class="FormColumn1">Titel</div>
				<div class="FormColumn2">
					<input name="Title" class="CommonTextXL" type="text"
						value="${Advertisement.title}" />
				</div>
			</div>
			<div class="FormRow">
				<div class="FormColumn1">Prijs</div>
				<div class="FormColumn2">
					<input name="Price" class="CommonTextM" type="text"
						value="${Advertisement.price}" />
				</div>
			</div>
			<div class="FormRowTxt">
				<div class="FormColumn1">Beschrijving</div>
				<div class="FormColumn2">
					<textarea class="CommonTextTxt" name="Description">${Advertisement.description}</textarea>
				</div>
			</div>
			<input type="submit" value="Opslaan">
		</form>

		<form action="advertisements" method="POST">
			<input type="hidden" name="delete_id" value="${Advertisement.id}" />
			<input type="submit" value="Verwijderen">
		</form>
		<form action="advertisements" method="POST">
			<input type="hidden" name="sold_id" value="${Advertisement.id}" /> <input
				type="submit" value="Markeren als verkocht">
		</form>
		
<%@include file="footer.jsp" %>