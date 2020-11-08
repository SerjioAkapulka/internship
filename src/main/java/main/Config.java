package main;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {
    public static void initDB() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            String mysqlUrl = "jbdc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(mysqlUrl,"root","Bubbavoltric80");
            System.out.println("Connection established");
        } catch (Exception e) {

        }
    }
}
