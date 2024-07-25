/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysqlconnectioin;

import java.sql.*;
import org.eclipse.jdt.internal.compiler.batch.Main;

/**
 *
 * @author sagar
 *///make class final so that noone can inherit.
public final class ConnectionProvider {
   static Connection con;
    
    private ConnectionProvider()//made private constructor so that noone can make object of the class.
    {
        
    }
    
    
    public static Connection getConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginregister", "st-chhetri", "dunno");
             return con;

        } catch (Exception ex) {
           ex.printStackTrace();
        }
        return null;
    }
    
}
