<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Bank Login</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Enter User Id and Password</h1>
        <p><i>${message}</i></p>
        <form action="login" method="post">
            <input type="hidden" name="option" value="login">
            <label class="pad_top">User ID:</label>
            <input type="text" name="userID" value="" required>
            <label class="pad_top">Password:</label>
            <input type="password" name="password" value="" required>
            <br>
            <label>&nbsp;</label>
            <input type="submit" value="Login" class="margin_left">
        </form>
    </body>
</html>
