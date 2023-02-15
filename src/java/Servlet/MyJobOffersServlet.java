package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

@WebServlet(name = "Servlet/MyJobOffersServlet", urlPatterns = {"/MyJobOffersServlet"})
public class MyJobOffersServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String url = "jdbc:mysql://127.0.0.1:3306/WorksPoland"; 
                String user = "java"; 
                String passwd = "java";
                HttpSession session = request.getSession();  
                String Username = (String) session.getAttribute("Username");
                try{
                    Class.forName("com.mysql.jdbc.Driver");	               
                    Connection db = DriverManager.getConnection(url, user, passwd); 
                    db.setAutoCommit(true); 
                    Statement st = db.createStatement();
                    ResultSet rs = st.executeQuery("select * from Work where username='"+Username+"'"); 
                    
                    ArrayList<String> CompanyNameMy = new ArrayList<>(); 
                    ArrayList<String> SpecializationMy = new ArrayList<>(); 
                    ArrayList<String> PositionDescriptionMy = new ArrayList<>(); 
                    ArrayList<String> CityMy = new ArrayList<>(); 
                    
                    while (rs.next())
                    {
                        CompanyNameMy.add(rs.getString(2));
                        SpecializationMy.add(rs.getString(3));
                        PositionDescriptionMy.add(rs.getString(4));
                        CityMy.add(rs.getString(5));
                    } 
                    session.setAttribute("CompanyNameMy",CompanyNameMy);
                    session.setAttribute("SpecializationMy",SpecializationMy);
                    session.setAttribute("PositionDescriptionMy",PositionDescriptionMy);
                    session.setAttribute("CityMy",CityMy);

                    st.close();
                    db.close();
                    response.sendRedirect("MyJobOffers.jsp");
                }
                catch(ClassNotFoundException wyjatek) { 
                    System.out.println("ClassNotFoundException: " + wyjatek.getMessage());
                }
                catch(SQLException wyjatek) { 
                    System.out.println("SQLException: " + wyjatek.getMessage());
                }     
    }
}