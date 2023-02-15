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

@WebServlet(name = "Servlet/JobRequestServlet", urlPatterns = {"/JobRequestServlet"})
public class JobRequestServlet extends HttpServlet {  
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
                    Statement sjr = db.createStatement();
                    ResultSet rs = st.executeQuery("select * from jobrequests where owners='"+Username+"'"); 
                    
                    ArrayList<String> Worker = new ArrayList<>(); 
                    ArrayList<String> CompanyNameJR = new ArrayList<>(); 
                    
                    ArrayList<String> CityJR = new ArrayList<>(); 
                    ArrayList<String> SpecializationJR = new ArrayList<>(); 
                    
                    while (rs.next()) {
                        Worker.add(rs.getString(2));
                        CompanyNameJR.add(rs.getString(4));
                        ResultSet jr = sjr.executeQuery("select * from Work where companyname='"+rs.getString(4)+"'");
                        while (jr.next()) {
                            CityJR.add(jr.getString(5));
                            SpecializationJR.add(jr.getString(3));
                        }                        
                    } 
                    session.setAttribute("Worker",Worker);
                    session.setAttribute("CompanyNameJR",CompanyNameJR);
                    
                    session.setAttribute("CityJR",CityJR);
                    session.setAttribute("SpecializationJR",SpecializationJR);

                    st.close();
                    db.close();
                    response.sendRedirect("JobRequest.jsp");
                }
                catch(ClassNotFoundException wyjatek) { 
                    System.out.println("ClassNotFoundException: " + wyjatek.getMessage());
                }
                catch(SQLException wyjatek) { 
                    System.out.println("SQLException: " + wyjatek.getMessage());
                }     
    }
}