package DataBase;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DatabaseTabelModel extends AbstractTableModel {
    private static final int Database_COL = 0;
    private String[] columnName = {"Database"};
    private List<Database> databases;

    public DatabaseTabelModel(List<Database> theDatabases) {
        databases = theDatabases;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public int getRowCount() {
        return databases.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnName[col];
    }

    @Override
    public String getValueAt(int row, int col) {
        Database tempDatabase = databases.get(row);  // The databases list is there as the TableModel created.
        switch (col) {
            case Database_COL:
                return tempDatabase.getName();      // returns the name of database, e.g. newarkdata
            default:
                return tempDatabase.getName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
