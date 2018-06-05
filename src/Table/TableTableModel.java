package Table;

import DataBase.Database;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableTableModel extends AbstractTableModel {
    private static final int Table_COL = 0;
    private String[] columnName = {"Table"};
    private List<Table> Tables;

    public TableTableModel(List<Table> theTables) {
        Tables = theTables;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public int getRowCount() {
        return Tables.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnName[col];
    }

    @Override
    public String getValueAt(int row, int col) {
        Table tempTable = Tables.get(row);  // The databases list is there as the TableModel created.
        switch (col) {
            case Table_COL:
                return tempTable.getName();      // returns the name of database, e.g. newarkdata
            default:
                return tempTable.getName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}
