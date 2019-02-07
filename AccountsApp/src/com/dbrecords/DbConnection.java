package com.dbrecords;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
	private static final String DB_NAME="accountsdb";
    private static final String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String username="admin";
    private static final String password="admin123456789";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";		
    		
    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            //Start connection
            System.out.println("Start database connection");
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(DB_URL,username,password);
            System.out.println("Database connected");
//            System.out.println("=============================");
            
            } catch (SQLException e) {
            	e.printStackTrace();
            }
        	catch (ClassNotFoundException e) {
        		e.printStackTrace();
            }
        
        
        return connection;
    }
    
    public static void closeConnection(Connection connection)  {
        
        try {
            connection.close();
            } catch (SQLException e) {
			e.printStackTrace();
                    }
//        System.out.println("End of Program");
    }
}
