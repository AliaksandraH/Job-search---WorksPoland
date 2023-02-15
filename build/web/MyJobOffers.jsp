<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Moje oferty pracy</title>
    <link rel="stylesheet" href="MyJobOffers.css">
</head>
<body>
<%@page import="java.util.ArrayList"%> 
<% ArrayList<String> copyCompanyName = (ArrayList<String>) request.getSession().getAttribute("CompanyNameMy"); %>
<% ArrayList<String> copySpecialization = (ArrayList<String>) request.getSession().getAttribute("SpecializationMy"); %>
<% ArrayList<String> copyPositionDescription = (ArrayList<String>) request.getSession().getAttribute("PositionDescriptionMy"); %>
<% ArrayList<String> copyCity = (ArrayList<String>) request.getSession().getAttribute("CityMy"); %>
<form action="RegistrationServlet" method="post">
    <section class="login-wrapper flex-center">
        <div class="login flex-center">
            <div class="login__body login__body-register flex-center" style="overflow-x: auto">
                <% for(int i = 0; i< copyCompanyName.size(); i++) { %>
                    <div class="login-input">
                        <p><span>Nazwa firmy:</span> <%= copyCompanyName.get(i)%></p>
                        <p><span>Miasto:</span> <%= copyCity.get(i)%></p>
                        <p><span>Specjalizacja:</span> <%= copySpecialization.get(i)%></p>
                        <p><span>Opis:</span> <%= copyPositionDescription.get(i)%></p>
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