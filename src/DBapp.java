import DataBase.DBmanager;
import DataBase.Database;
import DataBase.DatabaseTabelModel;
import Table.Table;
import Table.TableManager;
import Table.TableTableModel;
import au.com.bytecode.opencsv.CSVReader;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.List;


public class DBapp {
    private JPanel backPanel;
    private JPanel DBpanel;
    private JPanel tablePanel;
    private JPanel DataPanel;
    private JLabel DBlabel;
    private JButton DBgoToBtn;
    private JButton initializationBtn;
    private JTable DBTable;
    private JScrollPane DBScrollPane;
    private JPanel DBwest;
    private JPanel DBsouth;
    private JPanel tableEast;
    private JPanel tableSouth;
    private JLabel tableLabel;
    private JButton tableGoToBtn;
    private JButton tableBtn2;
    private JTable tableTable;
    private JScrollPane tableJScrollPane;
    private JButton DataButton;
    private JPanel DataBtn;
    private JTable dataTable;
    private JScrollPane dataJScrollPane;
    private JButton createBtn;
    private JPanel uploadPane;
    private JButton attachBtn;
    private JPanel uploadSouthPane;
    private JTextField pathField;
    private JButton createTableBtn;
    private JButton nextToNewTableBackPanelBtn;
    private JButton backToTableRefreshTableBtn;
    private JButton dropTableBtn;
    private JPanel searchBackPanel;
    private JButton searchBtn;
    private JButton SearchDataBtn;
    private JPanel searchPanel;
    private JPanel searchBackSouthPanel;
    private JButton SearchGoBackToData;
    private JPanel resultPanel;
    private JButton backButton;
    private JPanel resultSouthPanel;
    private JTable resultTable;
    private JPanel newTableBackPanel;
    private JPanel newTableSouthPanel;
    private JButton nextToImportBtn;
    private JButton backToUploadPanelBtn;
    private JPanel newTablePanel;
    private JPanel finalImportPanel;
    private JTextField createTableNameTextField;
    private JPanel newTableNorthPanel;
    private JButton Final_ImportButton;
    private JButton backToRefreshedTableBtn;
    private JButton testUpload;

    // once the database has been selected, it will be assigned as selectedDatabase(used for tableGoToBtn )
    protected String selectedDatabase;
    protected String filePath;
    protected String selectedTable;
    protected List<JTextField> valuesToBeSearched;
    protected List<JLabel> columnsToBeSearched;
    protected List<String> columnList;
    protected List<JComboBox> dataTypeToBeCreated;
    protected List<JTextField> columnsToBeCreated;

    public DBapp() {
        DBgoToBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = DBTable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Please select a database");
                    return;
                }
                String databaseName = (String) DBTable.getValueAt(row, 0);
                selectedDatabase = databaseName;
                Connection connection = null;
                try {
                    List<Table> tables = null;         //  initialize the List(No dependency)
                    connection = TableManager.getConnection(databaseName);  //point the initialized connection to DB connection
                    if (connection != null) {
                        tables = TableManager.getAllTables(connection, databaseName);   // put DB list in to initialized list
                    }
                    TableTableModel model = new TableTableModel(tables); // Table model has constructor, tables list as input value
                    tableTable.setModel(model);
                    DBpanel.setVisible(false);
                    tablePanel.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });
        tableGoToBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableTable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Please select a table");
                    return;
                }
                String tableName = (String) tableTable.getValueAt(row, 0);   //fetch the selected table
                selectedTable = tableName; //used in other method. A protected String selectedTable was already set.
                Connection connection = null;
                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "select * from " + tableName;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                    }
                    dataTable.setModel(DbUtils.resultSetToTableModel(myRs));
                    tablePanel.setVisible(false);
                    DataPanel.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });
        DataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                DataPanel.setVisible(false);
            }
        });
        tableBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBpanel.setVisible(true);
                tablePanel.setVisible(false);
            }
        });
        initializationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;                // initialize the connection(No dependency)
                try {
                    List<Database> databases = null;         //  initialize the List(No dependency)
                    connection = DBmanager.getConnection();  //point the initialized connection to DB connection
                    if (connection != null) {
                        databases = DBmanager.getAllDatabases(connection);   // put DB list in to initialized list
                    }
                    DatabaseTabelModel model = new DatabaseTabelModel(databases); // Table model has constructor, databases list as input value
                    DBTable.setModel(model);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });

        createTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                uploadPane.setVisible(true);

            }
        });

        attachBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File file = chooser.getSelectedFile();
                filePath = file.getAbsolutePath();
                pathField.setText(filePath);

            }
        });

        backToTableRefreshTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    List<Table> tables = null;         //  initialize the List(No dependency)
                    connection = TableManager.getConnection(selectedDatabase);  //point the initialized connection to DB connection
                    if (connection != null) {
                        tables = TableManager.getAllTables(connection, selectedDatabase);   // put DB list in to initialized list
                    }
                    TableTableModel model = new TableTableModel(tables); // Table model has constructor, tables list as input value
                    tableTable.setModel(model);
                    uploadPane.setVisible(false);
                    tablePanel.setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });
        dropTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableTable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Please select a table to be dropped");
                    return;
                }
                String tableName = (String) tableTable.getValueAt(row, 0);   //fetch the selected table
                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    String SQL = "drop table if exists " + tableName;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.executeUpdate(SQL);
                        List<Table> tables = null;
                        if (connection != null) {
                            tables = TableManager.getAllTables(connection, selectedDatabase);   // put DB list in to initialized list
                        }
                        TableTableModel model = new TableTableModel(tables); // Table model has constructor, tables list as input value
                        tableTable.setModel(model);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
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
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                ResultSet myRs = null;
                List<String> columnNameList = new ArrayList<String>();
                List<JLabel> searchColumns = new ArrayList<JLabel>();
                List<JTextField> searchValues = new ArrayList<JTextField>();
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    DatabaseMetaData metaData = connection.getMetaData();
                    myRs = metaData.getColumns(null,null,selectedTable, null);
                    while (myRs.next()) {
                        columnNameList.add(myRs.getString("COLUMN_NAME"));
                    }
                    columnList = columnNameList;
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                GridBagConstraints c1 = new GridBagConstraints();
                GridBagConstraints c2 = new GridBagConstraints();
                for (int i = 0; i < columnNameList.size(); i++) {
                    c1.gridx = 0;
                    c1.gridy = i;
                    c2.gridx = 2;
                    c2.gridy = i;
                    JLabel column = new JLabel(columnNameList.get(i));
                    JTextField columnValue = new JTextField(25);
                    searchPanel.add(column, c1);
                    searchPanel.add(columnValue, c2);
                    searchColumns.add(column);
                    searchValues.add(columnValue);
                }
                columnsToBeSearched = searchColumns;  //pass the list value to it
                valuesToBeSearched = searchValues;    //pass the list value to it
                DataPanel.setVisible(false);
                searchBackPanel.setVisible(true);
            }
        });
        SearchGoBackToData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPanel.setVisible(true);
                searchBackPanel.setVisible(false);
                searchPanel.removeAll();
            }
        });
        SearchDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                Statement myStmt = null;
                ResultSet myRs = null;
                String tempSQL;

                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    String SQL = "select * from " + selectedTable + " where ";
                    tempSQL = SQL;
                    for (int i = 0; i < valuesToBeSearched.size(); i++) {
                        String tempValue = valuesToBeSearched.get(i).getText();
                        if (tempValue.length() != 0) {
                            SQL += columnList.get(i) + " = '" + tempValue + "'";
                            tempSQL = SQL;
                            SQL += " and ";
                        }

                    }
                    String finalSQL = tempSQL;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(finalSQL);
                        resultTable.setModel(DbUtils.resultSetToTableModel(myRs));
                        resultPanel.setVisible(true);
                        searchBackPanel.setVisible(false);
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPanel.setVisible(true);
                resultPanel.setVisible(false);
                resultTable.removeAll();
                searchPanel.removeAll();
            }
        });
        nextToNewTableBackPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pathField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please attach a csv file first");
                    return;
                }
                newTableBackPanel.setVisible(true);
                uploadPane.setVisible(false);

                List<String> dataTypeList = new ArrayList<String>();
                dataTypeList.add(null);
                dataTypeList.add("int");
                dataTypeList.add("text");
                dataTypeList.add("double");
                dataTypeList.add("bigint");
                dataTypeList.add("datetime");
                dataTypeList.add("binary");
                dataTypeList.add("geometry");
                dataTypeList.add("json");

                try {
                    CSVReader reader = new CSVReader(new FileReader(filePath));
                    List<String> nextLine = new ArrayList<>();
                    StringTokenizer st = null;
                    nextLine = Arrays.asList(reader.readNext());
                    List<JTextField> tempColumns = new ArrayList<JTextField>();
                    List<JComboBox> tempDataType = new ArrayList<JComboBox>();

                    GridBagConstraints c1 = new GridBagConstraints();
                    GridBagConstraints c2 = new GridBagConstraints();
                    for (int i = 0; i < nextLine.size(); i++) {
                        c1.gridx = 0;
                        c1.gridy = i;
                        c2.gridx = 2;
                        c2.gridy = i;
                        JTextField column = new JTextField(nextLine.get(i),15);

                        JComboBox comboBox = new JComboBox();
                        for (int j = 0; j < dataTypeList.size(); j++) {
                            comboBox.addItem(dataTypeList.get(j));
                        }

                        newTablePanel.add(column, c1);
                        newTablePanel.add(comboBox, c2);
                        tempColumns.add(column);
                        tempDataType.add(comboBox);
                        //do something with the column ArrayList
                        columnsToBeCreated = tempColumns;
                        dataTypeToBeCreated = tempDataType;
                    }
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        nextToImportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createTableNameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please input a table name");
                    return;
                }
                String tableName = createTableNameTextField.getText();
                List<String> columnNames = new ArrayList<>();
                List<String> dataTypes = new ArrayList<>();
                for (int i = 0; i < columnsToBeCreated.size(); i++) {
                    columnNames.add(columnsToBeCreated.get(i).getText());
                }
                for (int j = 0; j < dataTypeToBeCreated.size(); j++) {
                    dataTypes.add((String) dataTypeToBeCreated.get(j).getSelectedItem());
                }
                Connection connection = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    Statement myStmt = null;
                    String SQL = "create table " + tableName + " (";
                    int i = 0;
                    while ((i + 1) != (dataTypes.size())) {   //out of bound
                        SQL += "`" + columnNames.get(i) + "` " + dataTypes.get(i) + ",";
                        i++;
                    }
                    SQL += "`" + columnNames.get(i) + "` " + dataTypes.get(i) + ")";

                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.executeUpdate(SQL);
                    }
                    newTableBackPanel.setVisible(false);
                    finalImportPanel.setVisible(true);
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
        });
        backToUploadPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uploadPane.setVisible(true);
                newTableBackPanel.setVisible(false);
                newTablePanel.removeAll();
            }
        });

        Final_ImportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        CSVLoader loader = new CSVLoader(connection);
                        loader.loadCSV(filePath, createTableNameTextField.getText(), true);
                    }
                } catch (Exception ex) {
                     ex.printStackTrace();
                }finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Importing completed");
            }
        });
        backToRefreshedTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    List<Table> tables = null;         //  initialize the List(No dependency)
                    connection = TableManager.getConnection(selectedDatabase);  //point the initialized connection to DB connection
                    if (connection != null) {
                        tables = TableManager.getAllTables(connection, selectedDatabase);   // put DB list in to initialized list
                    }
                    TableTableModel model = new TableTableModel(tables); // Table model has constructor, tables list as input value
                    tableTable.setModel(model);
                    finalImportPanel.setVisible(false);
                    tablePanel.setVisible(true);
                    newTablePanel.removeAll();
                    pathField.setText("");
                    filePath = "";
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        });
    }

    public static void main (String[] args) throws Throwable{
        JFrame frame = new JFrame("MySQL database");
        frame.setContentPane(new DBapp().backPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
