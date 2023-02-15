<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="Login.css">
</head>
<body>
<form action="RegistrationServlet" method="post">
    <section class="login-wrapper flex-center">
        <div class="login flex-center">
            <div class="login__body login__body-register flex-center">
                <div class="login-input">
                    <label for="first_name">Imię:</label>
                    <input id="first_name" type="text" name="first_name">
                </div>
                <div class="login-input">
                    <label for="second_name">Nazwisko:</label>
                    <input id="second_name" type="text" name="second_name">
                </div>
                <div class="login-input">
                    <label for="username">Username:</label>
                    <input id="username" type="text" name="username">
                </div>
                <div class="login-input">
                    <label for="password">Password:</label>
                    <input id="password" type="password" name="password">
                </div>
                <div>
                    <p style="color: red">Wypełnij wszystkie pola</p>
                </div>
                <div class="login-buttons">
                    <button><a href="index.jsp">Powrót</a></button>
                    <button type="submit">Zarejestrować się</button>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>


