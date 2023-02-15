<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Works Poland</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
<form action="LoginServlet" method="post">
    <section class="login-wrapper flex-center">
        <div class="login flex-center">
            <h2 class="login__title">Works Poland</h2>
            <div class="login__body flex-center">
                <div class="login-input">
                    <label for="username1">Username:</label>
                    <input id="username1" type="text" name="username">
                </div>
                <div class="login-input">
                    <label for="password">Password:</label>
                    <input id="password" type="password" name="password">
                </div>
                <div>
                    <p style="color: red">Wypełnij wszystkie pola</p>
                </div>
                <div class="login-buttons">
                    <button><a href="Registration.jsp">Rejestracja</a></button>
                    <button type="submit">Zaloguj się</button>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>

