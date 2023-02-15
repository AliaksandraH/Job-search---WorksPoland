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

@WebServlet(name = "Servlet/RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            String FirstName = request.getParameter("first_name");
            String SecondName = request.getParameter("second_name");
            String Username = request.getParameter("username");
            String Password = request.getParameter("password");

            if (FirstName != null && SecondName != null && Username != null && Password != null &&
                FirstName != "" && SecondName != "" && Username != "" && Password != "") {
           
                boolean check = false;
                String url = "jdbc:mysql://127.0.0.1:3306/WorksPoland"; 
                String user = "java"; 
                String passwd = "java";  

                try {
                    Class.forName("com.mysql.jdbc.Driver");	
              
                    Connection db = DriverManager.getConnection(url, user, passwd); 

                    db.setAutoCommit(true); 

                    Statement st = db.createStatement(); 

                    ResultSet rs = st.executeQuery("select * from registration");

                    while (rs.next())
                    { 
                            if (Username.equals(rs.getString(4))) 
                            { check=true; break;}
                    } 
                          
                    if(check==false){
                        st.executeUpdate("insert into registration(firstname, secondname, username, password) values "
                            + "('"+FirstName+"', '"+SecondName+"','"+Username+"','"+Password+"')");
                        st.close();
                        db.close(); 
                        rs.close();
                        response.sendRedirect("index.jsp");                                          
                    }
                    else {
                        rs.close(); 
                        st.close();
                        db.close(); 
                        request.setAttribute("error", true);
                        request.getRequestDispatcher("/Registration.jsp").forward(request, response);
                    }            
                }
                catch(ClassNotFoundException wyjatek) { 
                    System.out.println("ClassNotFoundException: " + wyjatek.getMessage());
                }
                catch(SQLException wyjatek) { 
                    System.out.println("SQLException: " + wyjatek.getMessage());
                }      
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("/Registration.jsp").forward(request, response);   
            }
    }
}