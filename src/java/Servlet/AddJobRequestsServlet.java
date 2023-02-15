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

@WebServlet(name = "Servlet/AddJobRequestsServlet", urlPatterns = {"/AddJobRequestsServlet"})
public class AddJobRequestsServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String Owners = request.getParameter("ownersadd");
            String City = request.getParameter("cityadd");

            
                boolean check = false;
                String url = "jdbc:mysql://127.0.0.1:3306/WorksPoland"; 
                String user = "java"; 
                String passwd = "java";  

                try {
                    Class.forName("com.mysql.jdbc.Driver");	              
                    Connection db = DriverManager.getConnection(url, user, passwd); 

                    db.setAutoCommit(true); 
                    Statement st = db.createStatement(); 

                    HttpSession session = request.getSession();  
                    String Username = (String) session.getAttribute("Username");
                    
                    st.executeUpdate("insert into jobrequests(worker, owners, companyname) values "
                            + "('"+Username+"', '"+Owners+"','"+City+"')");
                        st.close();
                        db.close(); 
                        response.sendRedirect("Home.jsp");            
                }
                catch(ClassNotFoundException wyjatek) { 
                    System.out.println("ClassNotFoundException: " + wyjatek.getMessage());
                }
                catch(SQLException wyjatek) { 
                    System.out.println("SQLException: " + wyjatek.getMessage());
                }
    }
}