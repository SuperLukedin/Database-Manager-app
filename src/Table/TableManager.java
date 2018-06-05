package Table;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TableManager {
    // --getConnection have to put database name on this, database name comes from
    // --DBTable.getValueAt(row, 0), returns a String name.
    public static Connection getConnection(String DatabaseName) throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("MySQL.properties")); //This properties file has to be put in main menu, not src
        String user = props.getProperty("user");                   // read from MySQL.properties
        String password = props.getProperty("password");
        String tempDburl = props.getProperty("dburl");
        String dburl = tempDburl + DatabaseName;
        Connection connection = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dburl,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static List<Table> getAllTables(Connection connection, String DatabaseName) throws Exception {
        List<Table> list = new ArrayList<>();    // initialize a list

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = connection.createStatement();
            myRs = myStmt.executeQuery("show tables");

            while (myRs.next()) {
                Table tempTable= convertRowToTable(myRs, DatabaseName);
                list.add(tempTable);
                //System.out.println(tempTables);
            }

            return list;
        }
        finally {
            connection.close();
        }
    }

    private static Table convertRowToTable(ResultSet myRs, String DatabaseName) throws SQLException {
        String columnNameAfterQuery = "Tables_in_" + DatabaseName; //e.g. Tables_in_newarkdata
        String name = myRs.getString(columnNameAfterQuery);
        Table tempTable = new Table(name);
        return tempTable;
    }


}
