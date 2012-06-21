<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<div id="container">
<h1>Marktplaats Revised</h1>
<a class="terugLink" href="users">Terug</a>
	<form action="users" method="POST">
	   <input type="hidden" name="save_id" value="${User.id}" />
		<div class="FormRow">
			<div class="FormColumn1">Gebruikersnaam</div> 
			<div class="FormColumn2"><input name="Title" class="CommonTextXL" type="text" value="${User.username}"/></div>
		</div>
		<div class="FormRow">
					<div class="FormColumn1">E-mail adres</div> 
					<div class="FormColumn2"><input name="Email" class="CommonTextXXL" class="CommonTextM" type="text" value="${User.email}" /></div>
		</div>
		<div class="FormRowTxt">
        		<div class="FormColumn1">Oud Wachtwoord</div>  
        		<div class="FormColumn2"><input class="CommonTextM" name="oldpassword" type="password" value="" /></div>
        </div>
        <div class="FormRow">
        		<div class="FormColumn1">Nieuw Wachtwoord</div>  
        		<div class="FormColumn2"><input class="CommonTextM" name="newpassword" type="password" value="${User.password}"></div>
        </div>
	<div class="buttons">
		<input type="submit" value="Opslaan">
	</form>

	<form action="users" method="POST">
		<input type="hidden" name="delete_id" value="${User.id}" />
		<input type="submit" value="Verwijderen">
	</form>
	</div>
</div>
</body>
</html>