/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import mysqlconnectioin.ConnectionProvider;

/**
 *
 * @author sagar
 */
public class Login extends HttpServlet {

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
     response.setContentType("text/html");
     
        PrintWriter out=response.getWriter();
        
       
        String email=request.getParameter("email");
       
        String password=request.getParameter("password");
        try{
            
       
        Connection con=ConnectionProvider.getConnection();
       PreparedStatement ps= con.prepareStatement("select  * from register where email=? and  password=?");
       
       
        ps.setString(1, email);
       
        ps.setString(2,password);
        ResultSet i =ps.executeQuery();
        if(i.next())
        {
            
           
//            
//            response.sendRedirect("login.html");//to redirect to specific page
//            
        
            RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
            rd.forward(request,response);
        }
        else
        {
            out.println("invalid email and password entered");
             RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.include(request,response);
            
            
           
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        
       
            /* TODO output your page here. You may use following sample code. */
            
        
    }

   
    
    }

   
    
}
