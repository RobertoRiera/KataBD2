
package kataoracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.OracleDriver;


public class KataBD2 {
    private static final String URL = "jdbc:oracle:thin:@";
    private static final String  USERNAME = "system";
    private static final String  PASSWORD = "orcl";
    private static final String  SERVER = "localhost:1521:orcl";
    
    public static void main(String[] args) throws SQLException {

        DriverManager.registerDriver(new OracleDriver());
         //jdbc:oracle:thin:@server,username,password
        Connection connection = DriverManager.getConnection(URL+SERVER,USERNAME,PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from CAMBIO_EUR_A");
        while(resultSet.next()){
            printRegister(resultSet);
        }
        connection.close();
    }

    private static void printRegister(ResultSet set) throws SQLException {
        System.out.print(set.getString("DIVISA")+" ");
        System.out.println(set.getBigDecimal("CAMBIO"));
    }
}