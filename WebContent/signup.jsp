<%@include file="header.jsp"%>

<form action="signupServlet" method=POST>
    <p><strong>Please Enter Your User Name: </strong>
    <input type="text" name="u_username" size="25">
    <p><p><strong>Please Enter Your Password: </strong>
    <input type="password" size="15" name="u_email">
    <p><p><strong>Please Enter Your Email: </strong>
    <input type="text" size="15" name="u_email"><p><p>
    <p><p><strong>Please Enter Your Home location: </strong>
    <input type="text" size="15" name="u_home"><p><p>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>

<%@include file="footer.jsp"%>