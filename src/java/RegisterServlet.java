/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.sql.*;
import mysqlconnectioin.ConnectionProvider;

/**
 *
 * @author sagar
 */
public class RegisterServlet extends HttpServlet {
      
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String mobile=request.getParameter("mobile");
        String password=request.getParameter("password");
        try{
            
       
        Connection con=ConnectionProvider.getConnection();
       PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, mobile);
        ps.setString(4,password);
        int i=ps.executeUpdate();
        if(i>0)
        {
            out.println("register success");
           
//            
//            response.sendRedirect("login.html");//to redirect to specific page
//            
        
            RequestDispatcher rd=request.getRequestDispatcher("login.html");
            rd.forward(request,response);
        }
        else
        {
            out.println("register failed");
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        
       
            /* TODO output your page here. You may use following sample code. */
            
        
    }

   
    
    }
}
