package DataSet;

import DataBase.Database;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DataSetTableModel extends AbstractTableModel {
    private static final int Database_COL = 0;
    private String[] columnName = {"Database"};
    private List<DataSet> dataSets;

    public DataSetTableModel(List<DataSet> theDataSet) {
        dataSets = theDataSet;
    }

    @Override
    public int getColumnCount() {
        return columnName.length;
    }

    @Override
    public int getRowCount() {
        return dataSets.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnName[col];
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    @Override
    public Object getValueAt(int row, int col) {
        DataSet tempDataSet = dataSets.get(row);
        switch (col) {
            case Database_COL:
                return tempDataSet.getName();
            default:
                return tempDataSet.getName();
        }
    }
}
