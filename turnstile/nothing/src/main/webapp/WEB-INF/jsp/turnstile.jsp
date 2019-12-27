<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="Sign Out"/>
</form>
<h1>Turnstile</h1><br>
Status: <br>
<c:if test="${status != null}">${status}</c:if>
<br>
<hr>
<form action="/turnstileTry" method="post">
    Expiration date: ${card.getExpirationDate()}<br>
    Pass Count: ${card.getPassCount()}<br>
    <input type="submit" value="Try"/><br>
</form>
<hr>
<h2>Change Card</h2>
<form action="/turnstileChange" method="post">
    Expiration Date: <input type="date" name="expDate"/>
    Pass Count: <input type="number" name="passCount"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Change"/></div>
</form>
</body>
</html>