<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <link rel="stylesheet" href="Home.css">
</head>
<body>
<%@page import="java.util.ArrayList"%> 
<% ArrayList<String> copyCompanyName = (ArrayList<String>) request.getSession().getAttribute("CompanyName"); %>
<% ArrayList<String> copySpecialization = (ArrayList<String>) request.getSession().getAttribute("Specialization"); %>
<% ArrayList<String> copyPositionDescription = (ArrayList<String>) request.getSession().getAttribute("PositionDescription"); %>
<% ArrayList<String> copyCity = (ArrayList<String>) request.getSession().getAttribute("City"); %>
<% ArrayList<String> Owners = (ArrayList<String>) request.getSession().getAttribute("Owners"); %>

<div class="main">
    <div class="title"><h1>Works Poland</h1></div>
    <div class="center">
        <form action="HomeServlet" method="post">
        <div class="top">
            <div class="search">
                <input type="text" placeholder="Nazwa Firmy" name="namecompany">
                <button type="submit"><img src="icons8-search-26.png"></button>
            </div>
            <div class="for_img">
                <a href="Settings.jsp"><img src="icons8-businesswoman-100.png"></a>
            </div>
        </div>
        <div class="filtres">
            <select name="specialization" id="Specialization">
                <option>Specjalizacja</option>
                <option>Inzynieria</option>
                <option>Ochrona srodowiska</option>
                <option>Ekonomia</option>
                <option>IT - Administracja</option>
                <option>Marketing</option>
                <option>Media</option>
                <option>Sprzedaz</option>
            </select>
            <select name="city" id="City">              
                <option>Miasto</option>
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
            <button type="submit"><img src="icons8-checked-checkbox-48.png"></button>
        </div>
        </form>
        <% for(int i = 0; i< copyCompanyName.size(); i++) { %>
            <form action="AddJobRequestsServlet" method="post">
                <div class="data">
                    <div class="information">
                        <div class="photo"><img src="istockphoto-587799996-170667a.jpg"></div>
                        <div class="text">
                            <div class="company_name"><h2><%= copyCompanyName.get(i)%></h2></div>
                            <h2><%= copySpecialization.get(i) %> - <%= copyCity.get(i) %></h2>
                            <p><%= copyPositionDescription.get(i) %></p>
                            
                            <input value="<%= copyCompanyName.get(i) %>" hidden name="cityadd">
                            <input value="<%= Owners.get(i) %>" hidden name="ownersadd">
                            
                            <div>
                                <button class="button_aplikowac" type="submit">Aplikować</button>
                            </div>
                        </div>
                    </div>
                </div>  
            </form>
        <% } %>           
    </div>
</div>
</body>
</html>