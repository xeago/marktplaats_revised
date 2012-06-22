<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add Advertisement</title>
</head>
<body>
	<div id="container">
		<h1>Marktplaats Revised</h1>
		<a class="terugLink" href="advertisements">Terug</a>
		<form action="AddAdvertisementServlet" method="POST">
			<div class="FormRow">
				<div class="FormColumn1">Titel</div>
				<div class="FormColumn2">
					<input name="Title" class="CommonTextXL" type="text"
						value="" />
				</div>
			</div>
			<div class="FormRow">
				<div class="FormColumn1">Prijs</div>
				<div class="FormColumn2">
					<input name="Price" class="CommonTextM" type="text"
						value="" />
				</div>
			</div>
			<div class="FormRowTxt">
				<div class="FormColumn1">Beschrijving</div>
				<div class="FormColumn2">
					<textarea class="CommonTextTxt" name="Description"></textarea>
				</div>
			</div>
			<input type="submit" name="AddAdvertisement" value="Opslaan" />
		</form>
	</div>
</body>
</html>