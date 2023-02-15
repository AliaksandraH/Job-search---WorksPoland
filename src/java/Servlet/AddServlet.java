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

@WebServlet(name = "Servlet/AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
            String CompanyName = request.getParameter("nazwa_firmy");
            String Specialization = request.getParameter("specjalizacja");
            String PositionDescription = request.getParameter("opis_stanowiska");
            String City = request.getParameter("city");

            if (CompanyName != null && Specialization != null && PositionDescription != null && City != null &&
                CompanyName != "" && Specialization != "" && PositionDescription != "" && City != "") {
           
                boolean check = false;
                String url = "jdbc:mysql://127.0.0.1:3306/WorksPoland"; 
                String user = "java"; 
                String passwd = "java";  

                try {
                    Class.forName("com.mysql.jdbc.Driver");	              
                    Connection db = DriverManager.getConnection(url, user, passwd); 

                    db.setAutoCommit(true); 
                    Statement st = db.createStatement(); 

                    ResultSet rs = st.executeQuery("select * from Work");
                    while (rs.next())
                    { 
                            if (CompanyName.equals(rs.getString(2))) 
                            { check=true; break;}
                    } 
                    HttpSession session = request.getSession();  
                    String Username = (String) session.getAttribute("Username");
                    
                    if(check==false && Username!=null){
                        st.executeUpdate("insert into Work(companyname, specialization, positiondescription, city, username) values "
                            + "('"+CompanyName+"', '"+Specialization+"','"+PositionDescription+"', '"+City+"', '"+Username+"')");
                        st.close();
                        db.close(); 
                        rs.close();
                        response.sendRedirect("Settings.jsp");                                          
                    }
                    else {
                        rs.close(); 
                        st.close();
                        db.close(); 
                        request.setAttribute("error", true);
                        request.getRequestDispatcher("/AddJob.jsp").forward(request, response);
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
                request.getRequestDispatcher("/AddJob.jsp").forward(request, response);   
            }
    }
}