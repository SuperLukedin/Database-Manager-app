import Table.TableManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddLatLngColumns {
    public AddLatLngColumns() {
    }

    protected void addLatLngColumns(String table, String database) {
        String addColumnLatituteSQL = "ALTER TABLE ";
        addColumnLatituteSQL += table;
        addColumnLatituteSQL += " ADD COLUMN ";
        addColumnLatituteSQL += "Latitute DOUBLE";

        String addColumnLongituteSQL = "ALTER TABLE ";
        addColumnLongituteSQL += table;
        addColumnLongituteSQL += " ADD COLUMN ";
        addColumnLongituteSQL += "Longitute DOUBLE";

        Connection connection = null;
        Statement myStmt = null;
        Statement myStmt2 = null;
        try {
            connection = TableManager.getConnection(database);
            if (connection != null) {
                myStmt = connection.createStatement();
                myStmt2 = connection.createStatement();

                myStmt.executeUpdate(addColumnLatituteSQL);
                myStmt2.executeUpdate(addColumnLongituteSQL);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
