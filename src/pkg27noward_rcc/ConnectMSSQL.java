/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg27noward_rcc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class ConnectMSSQL {
    
    
    public Connection connection;
    
    public void connectDB() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=27NoWord;selectMethod=cursor", "sa", "123456");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

