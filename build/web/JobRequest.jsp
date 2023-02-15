<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Odpowiedź na moje oferty pracy</title>
    <link rel="stylesheet" href="MyJobOffers.css">
</head>
<body>
<%@page import="java.util.ArrayList"%>
<% ArrayList<String> Worker = (ArrayList<String>) request.getSession().getAttribute("Worker"); %>
<% ArrayList<String> CompanyNameJR = (ArrayList<String>) request.getSession().getAttribute("CompanyNameJR"); %>
<% ArrayList<String> CityJR = (ArrayList<String>) request.getSession().getAttribute("CityJR"); %>
<% ArrayList<String> SpecializationJR = (ArrayList<String>) request.getSession().getAttribute("SpecializationJR"); %>

<form action="RegistrationServlet" method="post">
    <section class="login-wrapper flex-center">
        <div class="login flex-center">
            <div class="login__body login__body-register flex-center" style="overflow-x: auto">
                <% for(int i = 0; i< Worker.size(); i++) { %>
                    <div class="login-input">
                        <p><span>Username:</span> <%= Worker.get(i)%></p>
                        <p><span>Nazwa firmy:</span> <%= CompanyNameJR.get(i)%></p>
                        <p><span>Miasto:</span> <%= CityJR.get(i)%></p>
                        <p><span>Specjalizacja:</span> <%= SpecializationJR.get(i)%></p>
                        <p><span>________________________________________________________</span></p>
                    </div>
                <% } %> 
                <div class="login-buttons">
                    <button><a href="Settings.jsp">Wróć do poprzedniej strony</a></button>
                </div>
            </div>
        </div>
    </section>
</form>
</body>
</html>