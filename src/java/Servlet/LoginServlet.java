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

@WebServlet(name = "Servlet/LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String Username = request.getParameter("username");
            String Password = request.getParameter("password");

            if (Username != null && Password != null && Username != "" && Password != "") {
           
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
                            if (Username.equals(rs.getString(4))&& Password.equals(rs.getString(5))) 
                            { check=true; break;}
                    }    
                    st.close();
                    db.close(); 
                    rs.close();
                }
                catch(ClassNotFoundException wyjatek) { 
                    System.out.println("ClassNotFoundException: " + wyjatek.getMessage());
                }
                catch(SQLException wyjatek) { 
                    System.out.println("SQLException: " + wyjatek.getMessage());
                }
                
                    if(check==true){
                        HttpSession session=request.getSession();
                        session.setAttribute("Username",Username);            
                        try{
                            Class.forName("com.mysql.jdbc.Driver");	               
                            Connection db = DriverManager.getConnection(url, user, passwd); 
                            db.setAutoCommit(true); 
                            Statement st = db.createStatement();

                            ResultSet rs = st.executeQuery("select * from Work");

                            ArrayList<String> CompanyName = new ArrayList<>(); 
                            ArrayList<String> Specialization = new ArrayList<>(); 
                            ArrayList<String> PositionDescription = new ArrayList<>(); 
                            ArrayList<String> City = new ArrayList<>(); 
                            ArrayList<String> Owners = new ArrayList<>();
                            while (rs.next())
                            {
                                CompanyName.add(rs.getString(2));
                                Specialization.add(rs.getString(3));
                                PositionDescription.add(rs.getString(4));
                                City.add(rs.getString(5));
                                Owners.add(rs.getString(6));
                            }
                            session.setAttribute("CompanyName",CompanyName);
                            session.setAttribute("Specialization",Specialization);
                            session.setAttribute("PositionDescription",PositionDescription);
                            session.setAttribute("City",City);
                            session.setAttribute("Owners",Owners);
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
                    else {
                        request.setAttribute("error", true);
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    } 
            } else {
                request.setAttribute("error", true);
                request.getRequestDispatcher("/index.jsp").forward(request, response);   
            }
    }
}