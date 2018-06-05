package DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBmanager {
    public static Connection getConnection() throws IOException {  // returns a connection

        Properties props = new Properties();
        props.load(new FileInputStream("MySQL.properties")); //This properties file has to be put in main menu, not src

        String user = props.getProperty("user");                   // read from MySQL.properties
        String password = props.getProperty("password");
        String dburl = props.getProperty("dburl");

        Connection connection = null;                              // initialize a connection
        try {
            //Class.forName("com.mysql.jdbc.Driver");              // seems that it works without this line
            connection = DriverManager.getConnection(dburl,user,password);  //set up connection
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<Database> getAllDatabases(Connection connection) throws Exception {
        List<Database> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("show databases");

            while (myRs.next()) {
                Database tempDatabase = convertRowToDatabase(myRs);
                list.add(tempDatabase);
                //System.out.println(tempDatabase);    // print every Database (toString is overided in Database)
            }

            return list;
        }
        finally {
            connection.close();
        }
    }

    private static Database convertRowToDatabase(ResultSet myRs) throws SQLException {
        String name = myRs.getString("Database");
        Database tempTable = new Database(name);
        return tempTable;
    }
}
