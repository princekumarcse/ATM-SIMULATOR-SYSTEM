package atmsimulatorsystem;

import java.sql.*;

public class Conn{
    
    Connection c;
    Statement s;
    public Conn() {
        try {
             Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///atmsimulatorsystem","root","2002");    
            s =c.createStatement(); 
           
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}