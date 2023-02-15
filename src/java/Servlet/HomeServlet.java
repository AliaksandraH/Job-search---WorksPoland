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

@WebServlet(name = "Servlet/HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String url = "jdbc:mysql://127.0.0.1:3306/WorksPoland"; 
                String user = "java"; 
                String passwd = "java";
                
                String post_CompanyName = request.getParameter("namecompany");
                String post_Specialization = request.getParameter("specialization");
                String post_City = request.getParameter("city");
              
                try{
                    Class.forName("com.mysql.jdbc.Driver");	               
                    Connection db = DriverManager.getConnection(url, user, passwd); 
                    db.setAutoCommit(true); 
                    Statement st = db.createStatement();
                    ResultSet rs;

                    if(!post_Specialization.equals("Specjalizacja") && post_City.equals("Miasto") && post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where specialization='"+post_Specialization+"'");                        
                    } else if(post_Specialization.equals("Specjalizacja") && !post_City.equals("Miasto") && post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where city='"+post_City+"'");
                    } else if (!post_Specialization.equals("Specjalizacja") && !post_City.equals("Miasto") && post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where city='"+post_City+"' and specialization='"+post_Specialization+"'");
                    } else if (post_Specialization.equals("Specjalizacja") && post_City.equals("Miasto") && !post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where companyname='"+post_CompanyName+"'");
                    } else if (post_Specialization.equals("Specjalizacja") && !post_City.equals("Miasto") && !post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where companyname='"+post_CompanyName+"' and city='"+post_City+"'");
                    } else if (!post_Specialization.equals("Specjalizacja") && post_City.equals("Miasto") && !post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where companyname='"+post_CompanyName+"' and specialization='"+post_Specialization+"'");
                    } else if (!post_Specialization.equals("Specjalizacja") && !post_City.equals("Miasto") && !post_CompanyName.equals("")){
                        rs = st.executeQuery("select * from Work where companyname = '"+post_CompanyName+"' and specialization='"+post_Specialization+"'"
                                + "and city='"+post_City+"'");
                    } else { rs = st.executeQuery("select * from Work");} 
                    
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
                    HttpSession session=request.getSession();
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
}