<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodawanie Pracy</title>
    <link rel="stylesheet" href="Login.css">
    <link rel="stylesheet" href="Home.css">
</head>
<body>
<form action="AddServlet" method="post">
    <section class="login-wrapper flex-center">
        <div class="login flex-center">
            <div class="login__body login__body-register flex-center">
                <div class="login-input">
                    <label for="first_name">Nazwa firmy:</label>
                    <input id="first_name" type="text" name="nazwa_firmy">
                </div>
                <div class="filtres_specjalizacja">
                    <label for="second_name">Specjalizacja:</label>
                    <select name="specjalizacja" id="second_name">
                        <option>Inzynieria</option>
                        <option>Ochrona srodowiska</option>
                        <option>Ekonomia</option>
                        <option>IT - Administracja</option>
                        <option>Marketing</option>
                        <option>Media</option>
                        <option>Sprzedaz</option>
                    </select>
                </div>
                <div class="login-input">
                    <label for="username">Opis stanowiska:</label>
                    <input id="username" type="text" name="opis_stanowiska">
                </div>
                <div class="filtres_specjalizacja">
                    <label for="city">Miasto:</label>
                    <select name="city" id="city">
                        <option>Lodz</option>
                        <option>Warszawa</option>
                        <option>Krakow</option>
                        <option>Wroclaw</option>
                        <option>Poznan</option>
                        <option>Gdansk</option>
                        <option>Szczecin</option>
                        <option>Bydgoszcz</option>
                        <option>Lublin</option>
                        <option>Bialystok</option>
                    </select>
                </div>
                <div class="login-buttons">
                    <button><a href="Settings.jsp">Powrót</a></button>
                    <button type="submit">Dodać</button>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>