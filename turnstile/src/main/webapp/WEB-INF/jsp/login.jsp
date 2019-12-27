<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/registration" method="get">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="To Registration"/></div>
</form>
<h1>Login</h1>
<form action="/login" method="post">
    <div><label> Login : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>