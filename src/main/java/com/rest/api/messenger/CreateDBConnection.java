package com.rest.api.messenger;

import java.sql.*;
import javax.naming.*;

public class CreateDBConnection{
    public static void main(String args[])
        throws SQLException{
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            javax.sql.DataSource dataSource = (javax.sql.DataSource) envContext.lookup("jdbc/myDB");
            
            Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            System.out.println(stmt);
            
        } catch (NamingException ne) {
            ne.printStackTrace();
        }

    }
}