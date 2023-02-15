<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Konto osobiste</title>
  <link rel="stylesheet" href="Settings.css">
</head>
<body>
<div class="main">
  <div class="center">
    <div class="for_img"><img src="icons8-businesswoman-100.png"></div>
    <button><a href="AddJob.jsp">Dodać pracę</a></button>   
    <form action="MyJobOffersServlet" method="post">
        <button type="submit">Moje oferty pracy</button>
    </form>
    <form action="JobRequestServlet" method="post">
        <button type="submit">Odpowiedź na moje oferty pracy</button>
    </form>
    <button><a href="Home.jsp">Wróć do strony głównej</a></button>
    <button><a href="index.jsp">Wyloguj się</a></button>
  </div>
</div>
</body>
</html>
