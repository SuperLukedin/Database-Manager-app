import Table.TableManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetMetaColumns {

    public GetMetaColumns() {
    }

    public List<String> getColumnsHeader(String dataBase, String table) {
        Connection connection = null;
        ResultSet myRs = null;
        List<String> columnHeaderList = new ArrayList<String>();
        int columnNumbersFromSelectedTable = 0;
        try {
            connection = TableManager.getConnection(dataBase);
            DatabaseMetaData metaData = connection.getMetaData();
            myRs = metaData.getColumns(null,null, table, null);
            while (myRs.next()) {
                //This is the result of all column names in a List Array
                columnHeaderList.add(myRs.getString("COLUMN_NAME"));
            }
            columnNumbersFromSelectedTable = columnHeaderList.size();
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
        return columnHeaderList;
    }
}
