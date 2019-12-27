<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="/login" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="To Login"/></div>
</form>
<h1>Registration</h1>
<form action="/registration" method="post">
    <div><label> Login : <input type="text" name="login"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Sign Up"/></div>
</form>
</body>
</html>