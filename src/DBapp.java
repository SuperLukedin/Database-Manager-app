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
    private JPanel DataSouthPanel;
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
    private JButton visualizeBtn;
    private JButton relationshipsBtn;
    private JButton JoinBtn;
    private JPanel joinPanel;
    private JPanel joinSouthPanel;
    private JTable joinSelectTableTable;
    private JButton joinTablesNextToColumnsButton;
    private JButton joinPanelBackBtn;
    private JPanel joinColumnsPanel;
    private JPanel joinColumnsSouthPanel;
    private JPanel joinColumnsGridBagPanel;
    private JButton backToJoinPanel;
    private JPanel joinColumnsNorthPanel;
    private JButton nextToSelectJoinTypeBtn;
    private JPanel selectJoinTypePanel;
    private JPanel selectJoinTypeNorthPanel;
    private JPanel selectJoinTypeSouthPanel;
    private JButton backToJoinColumnsPanelBtn;
    private JPanel selectJoinTypeGridBagPanel;
    private JButton finalJoinBtn;
    private JPanel checkSQLPanel;
    private JPanel checkSQLPanelSouthPanel;
    private JButton backToSelectJoinTypeBtn;
    private JPanel checkSQLPanelNorthPanel;
    private JTextArea checkSQLJtextArea;
    private JButton checkSQLFinishButton;
    private JPanel joinResultPanel;
    private JPanel joinResultSouthPanel;
    private JButton backToTableFromJoinResult;
    private JTable joinResultShowTable;
    private JButton addColumnBtn;
    private JPanel addColumnPanel;
    private JPanel addColumnSouthPanel;
    private JButton backFromAddColumnToDataPanel;
    private JPanel addColumnNorthPanel;
    private JPanel addColumnCentralPanel;
    private JButton finishAddColumnBtn;
    private JPanel relationships1stPanel;
    private JPanel relationships1stSouthPanel;
    private JButton backToDataPanelFromRelation1stPanelBtn;
    private JPanel relationships1stNorthPanel;
    private JTable showReferencesTable;
    private JButton addRelationshipButton;
    private JPanel relationships2ndPanel;
    private JPanel relationships2ndSouthPanel;
    private JButton backTo1stRelationFrom2ndBtn;
    private JPanel relationships2ndNorthPanel;
    private JTable relatnSelectReferenceTableTable;
    private JButton nextTo3rdRelatnPanel;
    private JPanel relationships3rdPanel;
    private JPanel relationships3rdSouthPanel;
    private JPanel relationships3rdNorthPanel;
    private JPanel relationships3rdCentralPanel;
    private JButton finishRelatnBtn;
    private JButton backTo2ndRelatnBtn;
    private JButton addForeignWhileCreatingTableBtn;
    private JPanel addForeignKeyCreateTable1stPanel;
    private JPanel addForeignKeyCreateTable1stSouthPanel;
    private JButton backToCreateTableFromForeignKey1stPanelBtn;
    private JPanel addForeignKeyCreateTable1stNorthPanel;
    private JTable foreignKeyCreatingTableSelectRefTableTable;
    private JPanel addForeignKeyCreateTable2ndPanel;
    private JPanel addForeignKeyCreateTable2ndSouthPanel;
    private JPanel addForeignKeyCreateTable2ndNorthPanel;
    private JPanel addForeignKeyCreateTable2ndCentralPanel;
    private JButton nextToPickRefColumnPanelBtn;
    private JButton finalSelectForeignWhileCreatingTableBtn;
    private JButton TranslateBtn;
    private JPanel addLatLng1stPanel;
    private JPanel addLatLng1stSouthPanel;
    private JButton addLatLngOkButton;
    private JPanel addLatLngGridBagPanel;
    private JButton backToDataPanelFromLatLngPanelBtn;
    private JButton searchResultVisualizeBtn;
    private JButton joinResultVisualizeBtn;
    private JTextField nameJoinRsTextField;
    private JLabel nameJoinRsLabel;
    private JTextField nameSearchRsTextField;
    private JLabel nameSearchRsLabel;
    private JButton dropViewButton;
    private JButton visualizeJoinResultBtn;
    private JButton testUpload;

    // once the database has been selected, it will be assigned as selectedDatabase(used for tableGoToBtn )
    protected String selectedDatabase;
    protected String filePath;
    protected String selectedTable;
    protected List<JTextField> valuesToBeSearched;
    protected List<JLabel> columnsToBeSearched;
    protected List<JComboBox> andOrComboboxList;
    protected List<String> columnList;
    protected List<JComboBox> dataTypeToBeCreated;
    protected List<JTextField> columnsToBeCreated;
    protected int[] selectedTablesToBeJoinedRowsNumber;
    protected JComboBox JoinFomWherecomboBox = new JComboBox();
    protected List<JList> schemasJList;
    protected String joinSQL;
    protected int joinTimes;
    protected List<JComboBox> joinTypeComboBoxList = new ArrayList<>();
    protected List<JList> mainTableJList = new ArrayList<>();
    protected List<JList> secondTableJList = new ArrayList<>();
    protected List<String> secondTableNameToBeJoinedList;
    protected JComboBox addingColumnDataTypeComboBox;
    protected JTextField addingColumnNameTextField;
    protected JList selectedTableRelatnList;
    protected JList referencedTableRelatnList;
    protected String referencedTableName;
    protected JTextField contraintTextField;
    protected JList firstTableNameToBeCreatedJList;
    protected JList secondTableNameToBeReferencedJList;
    protected String appendSQLOfForeignKey = "";
    private JList addLatLngFromColumns;
    protected String searchQuerySQLforExport;
    protected ResultSet myRsForExport;
    protected JTextField getNameJoinRsTextField;
    protected JTextField getNameSearchRsTextField;

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
                List<JComboBox> tempAndOrComboBoxList = new ArrayList<>();
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
                GridBagConstraints c3 = new GridBagConstraints();
                for (int i = 0; i < columnNameList.size(); i++) {
                    c1.gridx = 1;
                    c1.gridy = i;
                    c2.gridx = 3;
                    c2.gridy = i;
                    JLabel column = new JLabel(columnNameList.get(i));
                    JTextField columnValue = new JTextField(25);
                    searchPanel.add(column, c1);
                    searchPanel.add(columnValue, c2);

                    if (i >=1 && i < columnNameList.size()) {
                        c3.gridx = 0;
                        c3.gridy = i;
                        JComboBox andOrCombobox = new JComboBox();
                        // keep 1st Item empty
                        andOrCombobox.addItem("");
                        andOrCombobox.addItem(" and ");
                        andOrCombobox.addItem(" or ");
                        searchPanel.add(andOrCombobox, c3);
                        tempAndOrComboBoxList.add(andOrCombobox);
                    }
                    searchColumns.add(column);
                    searchValues.add(columnValue);

                }
                andOrComboboxList = tempAndOrComboBoxList; // pas the list value to it
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
                List<String> andOrListFromComboBox = new ArrayList<>();
                andOrListFromComboBox.add(""); // keep 1st String is empty
                for (int m = 0; m < andOrComboboxList.size(); m++) {
                    andOrListFromComboBox.add((String) andOrComboboxList.get(m).getSelectedItem());
                }

                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    String SQL = "select * from " + selectedTable + " where ";
                    tempSQL = SQL;
                    for (int i = 0; i < valuesToBeSearched.size(); i++) {
                        String tempValue = valuesToBeSearched.get(i).getText();
                        String[] parts = tempValue.split(" ");
                        if (tempValue.length() != 0) {
                            SQL += andOrListFromComboBox.get(i);
                            if (!parts[0].equals(">")
                                    && !parts[0].equals("<")
                                    && !parts[0].equals("<=")
                                    && !parts[0].equals(">=")
                                    && !parts[0].equals("<>")
                                    && !parts[0].equals("!=")
                                    && !parts[0].equals("LIKE")
                                    && !parts[0].equals("like")
                                    && !parts[0].equals("NOT")
                                    && !parts[0].equals("not")) {
                                SQL += columnList.get(i) + " = '" + tempValue + "'";
                                tempSQL = SQL;
//                                if (i < andOrListFromComboBox.size()) {
//                                    SQL += andOrListFromComboBox.get(i);
//                                }
                                //SQL += " and ";
                            } else {
                                if (parts[0].equals("NOT") || parts[0].equals("not")) {
                                    String temp = "";
                                    String fullTextAfterOperation = temp;
                                    for (int j = 2; j < parts.length; j++) {
                                        temp += parts[j];
                                        fullTextAfterOperation = temp;
                                        temp += " ";
                                    }
                                    SQL += columnList.get(i) + " " + parts[0] + " " + parts[1]
                                            + " '" + fullTextAfterOperation + "'";
                                    tempSQL = SQL;
//                                    if (i < andOrListFromComboBox.size()) {
//                                        SQL += andOrListFromComboBox.get(i);
//                                    }
                                    //SQL += " and ";
                                } else {
                                    String temp = "";
                                    String fullTextAfterOperation = temp;
                                    for (int j = 1; j < parts.length; j++) {
                                        temp += parts[j];
                                        fullTextAfterOperation = temp;
                                        temp += " ";
                                    }
                                    SQL += columnList.get(i) + " " + parts[0] + " '" + fullTextAfterOperation + "'";
                                    tempSQL = SQL;
                                    //SQL += " and ";
//                                    if (i < andOrListFromComboBox.size()) {
//                                        SQL += andOrListFromComboBox.get(i);
//                                    }
                                }
                            }
                        }

                    }
                    String finalSQL = tempSQL;
                    searchQuerySQLforExport = finalSQL;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(finalSQL);
                        resultTable.setModel(DbUtils.resultSetToTableModel(myRs));
                        nameSearchRsTextField.setColumns(15);
                        getNameSearchRsTextField = nameSearchRsTextField;
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
                nameSearchRsTextField.removeAll();
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
                    List<String> finalNextLine = new ArrayList<>();
                    finalNextLine.add("id");
                    nextLine = Arrays.asList(reader.readNext());
                    for (int i = 0; i < nextLine.size(); i++) {
                        finalNextLine.add(nextLine.get(i));
                    }

                    List<JTextField> tempColumns = new ArrayList<JTextField>();
                    List<JComboBox> tempDataType = new ArrayList<JComboBox>();

                    GridBagConstraints c1 = new GridBagConstraints();
                    GridBagConstraints c2 = new GridBagConstraints();
                    for (int i = 0; i < finalNextLine.size(); i++) {
                        c1.gridx = 0;
                        c1.gridy = i;
                        c2.gridx = 2;
                        c2.gridy = i;
                        JTextField column = new JTextField(finalNextLine.get(i),15);

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
                    String SQL = "create table " + tableName;
                    SQL += " (" + columnNames.get(0) + " " + dataTypes.get(0) + " NOT NULL AUTO_INCREMENT, ";
                    int i = 1;
                    while ((i + 1) != (dataTypes.size())) {   //out of bound
                        SQL += "`" + columnNames.get(i) + "` " + dataTypes.get(i) + ",";
                        i++;
                    }
                    SQL += "`" + columnNames.get(i) + "` " + dataTypes.get(i) + ", ";
                    if (appendSQLOfForeignKey.length() == 0) {
                        SQL += "PRIMARY KEY (" + columnNames.get(0) + "))";
                    } else {
                        SQL += "PRIMARY KEY (" + columnNames.get(0) + "), " + appendSQLOfForeignKey + ")";
                    }
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
                appendSQLOfForeignKey = "";
                foreignKeyCreatingTableSelectRefTableTable.removeAll();
                addForeignKeyCreateTable2ndCentralPanel.removeAll();
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
        visualizeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                String url = null;
//                switch (selectedTable) {
//                    case "abandoned_properties":
//                        url = new Abandoned_properties().getUrl();
//                        break;
//                    case "open_complaints":
//                        url = new Open_complaints().getUrl();
//                        break;
//                    case "newark_housing":
//                        url = new Newark_housing().getUrl();
//                        break;
//                    default:
//                        url = null;
//                }
//                if (url != null) {
//                    try {
//                        Desktop.getDesktop().browse(java.net.URI.create(url));
//                    } catch (IOException e1) {
//                        e1.printStackTrace();
//                    }
//                } else {
                    try {
                        Process process = Runtime.getRuntime().exec("C:\\Program Files\\Tableau\\Tableau 2018.1\\bin\\tableau.exe");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
//                }
            }
        });
        JoinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "SHOW TABLES";
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                    }
                    joinSelectTableTable.setModel(DbUtils.resultSetToTableModel(myRs));
                    tablePanel.setVisible(false);
                    joinPanel.setVisible(true);
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
                joinSelectTableTable.setRowSelectionAllowed(true);
                joinSelectTableTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            }
        });
        joinPanelBackBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                joinPanel.setVisible(false);
            }
        });
        joinTablesNextToColumnsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int columnLength = 0;
                selectedTablesToBeJoinedRowsNumber = joinSelectTableTable.getSelectedRows();
                GridBagConstraints c1 = new GridBagConstraints();
                GridBagConstraints c2 = new GridBagConstraints();

                List<String> selectedTablesForComboBox = new ArrayList<>();
                List<JList> tempSchemasJList = new ArrayList<>();
                for (int i = 0; i < selectedTablesToBeJoinedRowsNumber.length; i++) {
                    c1.insets = new Insets(10,10,10,10);
                    c1.gridx = i;
                    c1.gridy = 0;
                    String currentTableName = joinSelectTableTable.getValueAt(selectedTablesToBeJoinedRowsNumber[i],0).toString();
                    JLabel tableNamesInLabel = new JLabel(currentTableName);
                    joinColumnsGridBagPanel.add(tableNamesInLabel, c1);
                    selectedTablesForComboBox.add(currentTableName);
                    // get schemas from selected tables
                    Connection connection = null;
                    ResultSet myRs = null;
                    List<String> tempColumnNameListInArray = new ArrayList<String>();
                    try {
                        connection = TableManager.getConnection(selectedDatabase);
                        DatabaseMetaData metaData = connection.getMetaData();
                        myRs = metaData.getColumns(null,null,currentTableName, null);
                        while (myRs.next()) {
                            //This is the result of all column names in a List Array
                            tempColumnNameListInArray.add(myRs.getString("COLUMN_NAME"));
                        }
                        //tempColumnNameListInArray.add("*");
                        // save the schemas length, later used in String[] columnNamesStringList
                        columnLength = tempColumnNameListInArray.size();
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
                    // finish get schemas from selected tables

                    c2.gridx = i;
                    c2.gridy = 1;
                    String[] columnNamesStringList = new String[columnLength]; // pass the column numbers to this string list

                    //ArrayList convert to String[]
                    for (int j = 0; j < columnLength; j++) {
                        columnNamesStringList[j] = currentTableName + "." + tempColumnNameListInArray.get(j);
                    }
                    JList columnNamesJlist = new JList(columnNamesStringList);
                    columnNamesJlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                    tempSchemasJList.add(columnNamesJlist); // save in a List<JList>
                    JScrollPane listScoller = new JScrollPane(columnNamesJlist);
                    joinColumnsGridBagPanel.add(listScoller,c2);
                }
                schemasJList = tempSchemasJList; // schemasJList initiallized in the beginning

                for (int i = 0; i < selectedTablesForComboBox.size(); i++) {
                    //JoinFomWherecomboBox is initiallized at beginning as protected
                    JoinFomWherecomboBox.addItem(selectedTablesForComboBox.get(i));
                }
                JLabel fromWhereLabel = new JLabel("From: ");
                joinColumnsNorthPanel.add(fromWhereLabel);
                joinColumnsNorthPanel.add(JoinFomWherecomboBox);

                // starting get text from JCombobox and JList
                //get text from JList

                joinPanel.setVisible(false);
                joinColumnsPanel.setVisible(true);
            }
        });
        backToJoinPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinPanel.setVisible(true);
                joinColumnsPanel.setVisible(false);
                joinColumnsGridBagPanel.removeAll();
            }
        });
        nextToSelectJoinTypeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> schemasWasSelected = new ArrayList<>();
                // Fetch all columns that selected from each JList to a single String list schemasWasSelected.
                for (int i = 0; i < schemasJList.size(); i++) {
                    int[] selectedIndices = schemasJList.get(i).getSelectedIndices();
                        for (int j = 0; j < selectedIndices.length; j++) {
                            schemasWasSelected.add((String) schemasJList.get(i).getModel().getElementAt(selectedIndices[j]));
                        }
                }
                // Fetch the main table that selected from JoinFomWherecomboBox as a single String fromWhere
                String fromWhere = (String) JoinFomWherecomboBox.getSelectedItem();
                String SQL = "SELECT ";
                int i;
                // Add the selected columns (schemasWasSelected) to SQL
                for (i = 0; i < schemasWasSelected.size() - 1; i++) {
                    SQL += schemasWasSelected.get(i);
                    String tempAlias = schemasWasSelected.get(i).replace(".","_");
                    SQL += " AS " + tempAlias;
                    SQL += ", ";
                }
                String lastAlias = schemasWasSelected.get(i).replace(".", "_");
                SQL += schemasWasSelected.get(i) + " AS " + lastAlias + " ";
                SQL += "FROM " + fromWhere + " ";
                joinSQL = SQL; // joinSQL is defined at the beginning. protected String joinSQL
                JTextArea SQLtextArea = new JTextArea(SQL);
                SQLtextArea.setLineWrap(true);
                SQLtextArea.setEditable(false);
                SQLtextArea.setOpaque(false);
                selectJoinTypeNorthPanel.add(SQLtextArea);


                // Setting Labels for selected tables to be joined
                GridBagConstraints c1 = new GridBagConstraints();
                GridBagConstraints c2 = new GridBagConstraints();
                GridBagConstraints c3 = new GridBagConstraints();
                GridBagConstraints c4 = new GridBagConstraints();
                GridBagConstraints c5 = new GridBagConstraints();

                //remove the selected main table "fromWhere" in int[] selectedTablesToBeJoinedRowsNumber
                int[] modifiedSelectedTablesToBeJoinedRowsNumber = new int[selectedTablesToBeJoinedRowsNumber.length];
                for (int q = 0; q < modifiedSelectedTablesToBeJoinedRowsNumber.length; q++) {
                    modifiedSelectedTablesToBeJoinedRowsNumber[q] = selectedTablesToBeJoinedRowsNumber[q];
                }
                int n = modifiedSelectedTablesToBeJoinedRowsNumber.length;
                int columnLength = 0;
                int k;
                for (k = 0; k < n; k++) {
                    if (joinSelectTableTable.getValueAt(modifiedSelectedTablesToBeJoinedRowsNumber[k], 0).toString()
                            == fromWhere) {
                        break;
                    }
                }
                if (k < n) {
                    n = n - 1;
                    for (int m = k; m < n; m++) {
                        modifiedSelectedTablesToBeJoinedRowsNumber[m] = modifiedSelectedTablesToBeJoinedRowsNumber[m + 1];
                    }
                }
                joinTimes = n;// joinTimes is defined at the beginning protected int joinTimes
                // finish removing selected main table "fromWhere" in int[] selectedTablesToBeJoinedRowsNumber

                // Right now k selectedTablesToBeJoinedRowsNumber[k] is the selected main table (fromWhere)
                // the component aligned vertically, positionCounter place the components one by one,
                // e.g. c1.gridy =0,1,2,3...
                int positionCounter = 0;
                int positionCounter2 = 0;
                List<JComboBox> tempjoinTypeComboBoxList = new ArrayList<>();
                List<String> tempSecondTableNameToBeJoinedList = new ArrayList<>();
                List<JList> tempMainTableJList = new ArrayList<>();
                List<JList> tempSecondTableColumnNamesJlist = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    c1.insets = new Insets(10, 10, 10, 10);
                    c1.gridx = 0;
                    c1.gridy = positionCounter;
                    positionCounter++;
                    String currentTableName = joinSelectTableTable.getValueAt(selectedTablesToBeJoinedRowsNumber[k], 0).toString();
                    JLabel tableNamesInLabel = new JLabel(currentTableName);
                    selectJoinTypeGridBagPanel.add(tableNamesInLabel, c1);
                    Connection connection = null;
                    ResultSet myRs = null;
                    List<String> tempColumnNameListInArray = new ArrayList<String>();
                    try {
                        connection = TableManager.getConnection(selectedDatabase);
                        DatabaseMetaData metaData = connection.getMetaData();
                        myRs = metaData.getColumns(null,null,currentTableName, null);
                        while (myRs.next()) {
                            //This is the result of all column names in a List Array
                            tempColumnNameListInArray.add(myRs.getString("COLUMN_NAME"));
                        }
                        // save the schemas length, later used in String[] columnNamesStringList
                        columnLength = tempColumnNameListInArray.size();
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
                    // finish get schemas from selected tables

                    // Add schemas to the JList
                    c2.gridx = 0;
                    c2.gridy = positionCounter;
                    positionCounter++;
                    String[] columnNamesStringList = new String[columnLength]; // pass the column numbers to this string list
                    //ArrayList convert to String[]
                    for (int z = 0; z < columnLength; z++) {
                        columnNamesStringList[z] = currentTableName + "." + tempColumnNameListInArray.get(z);
                    }
                    JList mainTableColumnNamesJlist = new JList(columnNamesStringList);
                    mainTableColumnNamesJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    tempMainTableJList.add(mainTableColumnNamesJlist);

                    JScrollPane listScoller = new JScrollPane(mainTableColumnNamesJlist);
                    selectJoinTypeGridBagPanel.add(listScoller,c2);
                    // Finish adding schemas to the JList

                    // Add join type to the combobox
                    JComboBox joinTypeComboBox = new JComboBox();
                    joinTypeComboBox.addItem("INNER JOIN");
                    joinTypeComboBox.addItem("LEFT JOIN");
                    joinTypeComboBox.addItem("RIGHT JOIN");
                    c3.gridx = 3;
                    c3.gridy = positionCounter - 1;
                    c3.insets = new Insets(10, 10, 10, 10);

                    tempjoinTypeComboBoxList.add(joinTypeComboBox);


                    selectJoinTypeGridBagPanel.add(joinTypeComboBox, c3);


                    c4.insets = new Insets(10, 10, 10, 10);
                    c4.gridx = 5;
                    c4.gridy = positionCounter2;
                    positionCounter2++;
                    String secondTableNameToBeJoined = joinSelectTableTable.getValueAt(modifiedSelectedTablesToBeJoinedRowsNumber[j], 0).toString();

                    tempSecondTableNameToBeJoinedList.add(secondTableNameToBeJoined);
                    secondTableNameToBeJoinedList = tempSecondTableNameToBeJoinedList;
                    JLabel tableNamesInLabel2 = new JLabel(secondTableNameToBeJoined);
                    selectJoinTypeGridBagPanel.add(tableNamesInLabel2, c4);

                    List<String> tempColumnNameListInArray2 = new ArrayList<String>();
                    try {
                        connection = TableManager.getConnection(selectedDatabase);
                        DatabaseMetaData metaData = connection.getMetaData();
                        myRs = metaData.getColumns(null,null,secondTableNameToBeJoined, null);
                        while (myRs.next()) {
                            //This is the result of all column names in a List Array
                            tempColumnNameListInArray2.add(myRs.getString("COLUMN_NAME"));
                        }
                        // save the schemas length, later used in String[] columnNamesStringList
                        columnLength = tempColumnNameListInArray2.size();
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
                    // finish get schemas from selected tables

                    // Add schemas to the JList
                    c5.gridx = 5;
                    c5.gridy = positionCounter2;
                    positionCounter2++;
                    String[] columnNamesStringList2 = new String[columnLength]; // pass the column numbers to this string list
                    //ArrayList convert to String[]
                    for (int z = 0; z < columnLength; z++) {
                        columnNamesStringList2[z] = secondTableNameToBeJoined + "." + tempColumnNameListInArray2.get(z);
                    }
                    JList secondTableColumnNamesJlist = new JList(columnNamesStringList2);
                    secondTableColumnNamesJlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    tempSecondTableColumnNamesJlist.add(secondTableColumnNamesJlist);

                    JScrollPane listScoller2 = new JScrollPane(secondTableColumnNamesJlist);
                    selectJoinTypeGridBagPanel.add(listScoller2,c5);
                    // Finish adding schemas to the JList
                }
                mainTableJList = tempMainTableJList;
                secondTableJList = tempSecondTableColumnNamesJlist;
                secondTableNameToBeJoinedList = tempSecondTableNameToBeJoinedList;
                joinTypeComboBoxList = tempjoinTypeComboBoxList;
                selectJoinTypePanel.setVisible(true);
                joinColumnsPanel.setVisible(false);
            }
        });
        backToJoinColumnsPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                joinColumnsPanel.setVisible(true);
                selectJoinTypePanel.setVisible(false);
            }
        });
        finalJoinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> joinTypeStringListForSQL = new ArrayList<>();
                for (int p = 0; p < joinTypeComboBoxList.size(); p++) {
                    joinTypeStringListForSQL.add((String) joinTypeComboBoxList.get(p).getSelectedItem());
                }
                for (int i = 0; i < joinTimes; i++) {
                    joinSQL += joinTypeStringListForSQL.get(i) + " ";
                    joinSQL += secondTableNameToBeJoinedList.get(i) + " ";
                    joinSQL += "ON ";

                    int indexFromMainTable = mainTableJList.get(i).getSelectedIndex();
                    String finalMainTableName = (String) mainTableJList.get(i).getModel().getElementAt(indexFromMainTable);

                    joinSQL += finalMainTableName;
                    joinSQL += " = ";

                    int indexFromSecondTable = secondTableJList.get(i).getSelectedIndex();
                    String finalSecondTableName = (String) secondTableJList.get(i).getModel().getElementAt(indexFromSecondTable);

                    joinSQL += finalSecondTableName;
                    joinSQL += " ";
                }


                checkSQLJtextArea.append(joinSQL);
                checkSQLJtextArea.setLineWrap(true);
                checkSQLJtextArea.setEditable(false);
                checkSQLJtextArea.setOpaque(false);
                selectJoinTypePanel.setVisible(false);
                checkSQLPanel.setVisible(true);
            }
        });
        backToSelectJoinTypeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectJoinTypePanel.setVisible(true);
                checkSQLPanel.setVisible(false);
            }
        });
        checkSQLFinishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                Statement myStmt = null;
                ResultSet myRs = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(joinSQL);
                        myRsForExport = myRs;
                        joinResultShowTable.setModel(DbUtils.resultSetToTableModel(myRs));
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
//                JTextField nameJoinRsTextField = new JTextField(25);
//                joinResultSouthPanel.add(nameJoinRsTextField);
                nameJoinRsTextField.setColumns(15);
                getNameJoinRsTextField = nameJoinRsTextField;
                joinResultPanel.setVisible(true);
                checkSQLPanel.setVisible(false);
            }
        });
        backToTableFromJoinResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                        List<Table> tables = null;
                        if (connection != null) {
                            tables = TableManager.getAllTables(connection, selectedDatabase);   // put DB list in to initialized list
                        }
                        TableTableModel model = new TableTableModel(tables); // Table model has constructor, tables list as input value
                        tableTable.setModel(model);
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

                joinSelectTableTable.removeAll();
                joinColumnsGridBagPanel.removeAll();
                selectJoinTypeGridBagPanel.removeAll();
                checkSQLJtextArea.removeAll();
                joinResultShowTable.removeAll();
                joinColumnsNorthPanel.removeAll();
                selectJoinTypeNorthPanel.removeAll();
                JoinFomWherecomboBox.removeAllItems();
                nameJoinRsTextField.removeAll();

                joinResultPanel.setVisible(false);
                tablePanel.setVisible(true);
            }
        });
        addColumnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                GridBagConstraints c1 = new GridBagConstraints();
                c1.gridx = 0;
                c1.gridy = 0;
                JLabel editColumnNameHintLabel = new JLabel("Input a column name");
                addColumnCentralPanel.add(editColumnNameHintLabel, c1);

                GridBagConstraints c2 = new GridBagConstraints();
                c2.gridx = 0;
                c2.gridy = 1;
                JTextField addColumnNameTextField = new JTextField(25);
                addColumnCentralPanel.add(addColumnNameTextField, c2);
                addingColumnNameTextField = addColumnNameTextField;

                GridBagConstraints c3 = new GridBagConstraints();
                c3.gridx = 1;
                c3.gridy = 0;
                JLabel editDataTypeHintLabel = new JLabel("Select a data type");
                addColumnCentralPanel.add(editDataTypeHintLabel, c3);

                GridBagConstraints c4 = new GridBagConstraints();
                c4.gridx = 1;
                c4.gridy = 1;
                JComboBox dataTypeAddingColumnComboBox = new JComboBox();
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
                for (int j = 0; j < dataTypeList.size(); j++) {
                    dataTypeAddingColumnComboBox.addItem(dataTypeList.get(j));
                }
                addColumnCentralPanel.add(dataTypeAddingColumnComboBox, c4);

                addingColumnDataTypeComboBox = dataTypeAddingColumnComboBox;
                DataPanel.setVisible(false);
                addColumnPanel.setVisible(true);
            }
        });
        backFromAddColumnToDataPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPanel.setVisible(true);
                addColumnPanel.setVisible(false);
            }
        });
        finishAddColumnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addColumnSQL = "ALTER TABLE ";
                addColumnSQL += selectedTable;
                addColumnSQL += " add column ";
                addColumnSQL += addingColumnNameTextField.getText() + " ";
                addColumnSQL += (String) addingColumnDataTypeComboBox.getSelectedItem();

                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.executeUpdate(addColumnSQL);
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

                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmtRefreshTheTable = null;
                    String SQL = "select * from " + selectedTable;
                    if (connection != null) {
                        myStmtRefreshTheTable = connection.createStatement();
                        myRs = myStmtRefreshTheTable.executeQuery(SQL);
                    }
                    dataTable.setModel(DbUtils.resultSetToTableModel(myRs));
                    DataPanel.setVisible(true);
                    addColumnPanel.setVisible(false);

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
                addColumnCentralPanel.removeAll();
            }
        });
        backToDataPanelFromRelation1stPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPanel.setVisible(true);
                relationships1stPanel.setVisible(false);
            }
        });
        relationshipsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;

                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    String referencesSQL = "select TABLE_NAME" +
                            ", COLUMN_NAME" +
                            ", CONSTRAINT_NAME" +
                            ", REFERENCED_TABLE_NAME" +
                            ", REFERENCED_COLUMN_NAME" +
                            " FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE" +
                            " WHERE REFERENCED_TABLE_NAME = '" +
                            selectedTable +
                            "'";
                    Statement mystmt = null;
                    ResultSet myRs = null;
                    if (connection != null) {
                        mystmt = connection.createStatement();
                        myRs = mystmt.executeQuery(referencesSQL);
                    }
                    showReferencesTable.setModel(DbUtils.resultSetToTableModel(myRs));
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

                DataPanel.setVisible(false);
                relationships1stPanel.setVisible(true);
            }
        });
        backTo1stRelationFrom2ndBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationships2ndNorthPanel.removeAll();
                relationships1stPanel.setVisible(true);
                relationships2ndPanel.setVisible(false);
            }
        });
        addRelationshipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Connection connection = null;
                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "SHOW TABLES";
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                    }
                    relatnSelectReferenceTableTable.setModel(DbUtils.resultSetToTableModel(myRs));
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
                relatnSelectReferenceTableTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                relationships1stPanel.setVisible(false);
                relationships2ndPanel.setVisible(true);
            }
        });
        backTo2ndRelatnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                relationships3rdNorthPanel.removeAll();
                relationships3rdCentralPanel.removeAll();
                relationships2ndPanel.setVisible(true);
                relationships3rdPanel.setVisible(false);
            }
        });
        nextTo3rdRelatnPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = relatnSelectReferenceTableTable.getSelectedRow();
                String tempTableToBeReferenced = (String) relatnSelectReferenceTableTable.getValueAt(selectedRow, 0);
                String selectedTableToBeReferenced = tempTableToBeReferenced;
                referencedTableName = selectedTableToBeReferenced;
                Connection connection = null;
                ResultSet myRs = null;
                List<String> tempColumnNameListInArrayFromSelectedTable = new ArrayList<String>();
                int columnNumbersFromSelectedTable = 0;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    DatabaseMetaData metaData = connection.getMetaData();
                    myRs = metaData.getColumns(null,null, selectedTable, null);
                    while (myRs.next()) {
                        //This is the result of all column names in a List Array
                        tempColumnNameListInArrayFromSelectedTable.add(myRs.getString("COLUMN_NAME"));
                    }
                    columnNumbersFromSelectedTable = tempColumnNameListInArrayFromSelectedTable.size();
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
                String[] stringListFromselectedTable = new String[columnNumbersFromSelectedTable];
                for (int j = 0; j < columnNumbersFromSelectedTable; j++) {
                    stringListFromselectedTable[j] = tempColumnNameListInArrayFromSelectedTable.get(j);
                }
                JList listOfSelectedTable = new JList(stringListFromselectedTable);
                listOfSelectedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane listScoller = new JScrollPane(listOfSelectedTable);
                GridBagConstraints c2 = new GridBagConstraints();
                c2.gridx = 0;
                c2.gridy = 1;
                relationships3rdCentralPanel.add(listScoller, c2);
                selectedTableRelatnList = listOfSelectedTable;


                GridBagConstraints c1 = new GridBagConstraints();
                c1.insets = new Insets(10,10,10,10);
                c1.gridx = 0;
                c1.gridy = 0;
                JLabel selectedTableName = new JLabel(selectedTable);
                relationships3rdCentralPanel.add(selectedTableName, c1);

                GridBagConstraints c3 = new GridBagConstraints();
                c3.insets = new Insets(10,10,10,10);
                c3.gridx = 4;
                c3.gridy = 0;
                JLabel selectedTableToBeReferencedLabel = new JLabel(selectedTableToBeReferenced);
                relationships3rdCentralPanel.add(selectedTableToBeReferencedLabel, c3);

                ResultSet myRsRefTable = null;
                List<String> tempColumnNameListInArrayFromReferencedTable = new ArrayList<String>();
                int columnNumbersFromReferencedTable = 0;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    DatabaseMetaData metaData2 = connection.getMetaData();
                    myRsRefTable = metaData2.getColumns(null,null, selectedTableToBeReferenced, null);
                    while (myRsRefTable.next()) {
                        //This is the result of all column names in a List Array
                        tempColumnNameListInArrayFromReferencedTable.add(myRsRefTable.getString("COLUMN_NAME"));
                    }
                    columnNumbersFromReferencedTable = tempColumnNameListInArrayFromReferencedTable.size();
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
                String[] stringListFromReferencedTable = new String[columnNumbersFromReferencedTable];
                for (int j = 0; j < columnNumbersFromReferencedTable; j++) {
                    stringListFromReferencedTable[j] = tempColumnNameListInArrayFromReferencedTable.get(j);
                }
                JList listOfReferencedTable = new JList(stringListFromReferencedTable);
                JScrollPane listScoller2 = new JScrollPane(listOfReferencedTable);
                GridBagConstraints c4 = new GridBagConstraints();
                c4.gridx = 4;
                c4.gridy = 1;
                listOfReferencedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                relationships3rdCentralPanel.add(listScoller2, c4);
                referencedTableRelatnList = listOfReferencedTable;

                GridBagConstraints c6 = new GridBagConstraints();
                c6.insets = new Insets(10,10,10,20);
                c6.gridx = 2;
                c6.gridy = 1;
                JLabel references = new JLabel("references");
                relationships3rdCentralPanel.add(references, c6);

                JLabel addConstraintLabel = new JLabel("Add contraint");
                JTextField constraint = new JTextField(30);
                relationships3rdNorthPanel.add(addConstraintLabel);
                relationships3rdNorthPanel.add(constraint);
                contraintTextField = constraint;


                relationships2ndPanel.setVisible(false);
                relationships3rdPanel.setVisible(true);
            }
        });
        finishRelatnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String primaryColumn = (String) selectedTableRelatnList.getModel().getElementAt(selectedTableRelatnList.getSelectedIndex());
                String refColumn = (String) referencedTableRelatnList.getModel().getElementAt(referencedTableRelatnList.getSelectedIndex());
                String constraint = contraintTextField.getText();
                String SQL = "ALTER TABLE " + selectedTable + " ADD ";
                if (constraint.length() != 0) {
                    SQL += "CONSTRAINT " + constraint + " ";
                }
                SQL += "FOREIGN KEY ";
                SQL += "(" + primaryColumn + ")";
                SQL += " REFERENCES ";
                SQL += referencedTableName;
                SQL += " (" + refColumn + ")";

                Connection connection = null;
                Statement myStmt = null;

                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.executeUpdate(SQL);
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
                DataPanel.setVisible(true);
                relationships3rdPanel.setVisible(false);
                relationships3rdCentralPanel.removeAll();
                relatnSelectReferenceTableTable.removeAll();
                showReferencesTable.removeAll();
                relationships3rdNorthPanel.removeAll();
            }
        });
        addForeignWhileCreatingTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = null;
                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "SHOW TABLES";
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                    }
                    foreignKeyCreatingTableSelectRefTableTable.setModel(DbUtils.resultSetToTableModel(myRs));
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
                foreignKeyCreatingTableSelectRefTableTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                newTableBackPanel.setVisible(false);
                addForeignKeyCreateTable1stPanel.setVisible(true);
            }
        });
        backToCreateTableFromForeignKey1stPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addForeignKeyCreateTable1stPanel.setVisible(false);
                newTableBackPanel.setVisible(true);
            }
        });
        nextToPickRefColumnPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel tableName = new JLabel(createTableNameTextField.getText());
                GridBagConstraints c1 = new GridBagConstraints();
                c1.insets = new Insets(10,10,10,10);
                c1.gridx = 0;
                c1.gridy = 0;
                addForeignKeyCreateTable2ndCentralPanel.add(tableName, c1);

                String[] stringOfColumnsFromJTextField = new String[columnsToBeCreated.size()];
                for (int i = 0; i < columnsToBeCreated.size(); i++) {
                    stringOfColumnsFromJTextField[i] = columnsToBeCreated.get(i).getText();
                }
                JList listOfColumnsFromJTextField = new JList(stringOfColumnsFromJTextField);
                listOfColumnsFromJTextField.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane listScoller = new JScrollPane(listOfColumnsFromJTextField);
                GridBagConstraints c2 = new GridBagConstraints();
                c2.gridx = 0;
                c2.gridy = 1;
                addForeignKeyCreateTable2ndCentralPanel.add(listScoller, c2);
                firstTableNameToBeCreatedJList = listOfColumnsFromJTextField;

                int tableToBeRefIndex = foreignKeyCreatingTableSelectRefTableTable.getSelectedRow();
                String tableNameToBeRef = (String) foreignKeyCreatingTableSelectRefTableTable.getValueAt(tableToBeRefIndex, 0);

                GridBagConstraints c3 = new GridBagConstraints();
                JLabel tableNameToBeRefJLabel = new JLabel(tableNameToBeRef);
                c3.insets = new Insets(10,10,10,10);
                c3.gridx = 4;
                c3.gridy = 0;
                addForeignKeyCreateTable2ndCentralPanel.add(tableNameToBeRefJLabel, c3);


                Connection connection = null;
                ResultSet myRsRefTable = null;
                List<String> tempColumnNameListInArrayFromReferencedTable = new ArrayList<String>();
                int columnNumbersFromReferencedTable = 0;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    DatabaseMetaData metaData2 = connection.getMetaData();
                    myRsRefTable = metaData2.getColumns(null,null, tableNameToBeRef, null);
                    while (myRsRefTable.next()) {
                        //This is the result of all column names in a List Array
                        tempColumnNameListInArrayFromReferencedTable.add(myRsRefTable.getString("COLUMN_NAME"));
                    }
                    columnNumbersFromReferencedTable = tempColumnNameListInArrayFromReferencedTable.size();
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
                String[] stringListFromReferencedTable = new String[columnNumbersFromReferencedTable];
                for (int j = 0; j < columnNumbersFromReferencedTable; j++) {
                    stringListFromReferencedTable[j] = tempColumnNameListInArrayFromReferencedTable.get(j);
                }
                JList listOfReferencedTable = new JList(stringListFromReferencedTable);
                JScrollPane listScoller2 = new JScrollPane(listOfReferencedTable);
                GridBagConstraints c4 = new GridBagConstraints();
                c4.gridx = 4;
                c4.gridy = 1;
                listOfReferencedTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                addForeignKeyCreateTable2ndCentralPanel.add(listScoller2, c4);
                secondTableNameToBeReferencedJList = listOfReferencedTable;

                GridBagConstraints c5 = new GridBagConstraints();
                c5.insets = new Insets(10,10,10,20);
                c5.gridx = 2;
                c5.gridy = 1;
                JLabel references = new JLabel("references");
                addForeignKeyCreateTable2ndCentralPanel.add(references, c5);

                addForeignKeyCreateTable1stPanel.setVisible(false);
                addForeignKeyCreateTable2ndPanel.setVisible(true);
            }
        });
        finalSelectForeignWhileCreatingTableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstTableColumnName = (String) firstTableNameToBeCreatedJList.getModel().getElementAt(firstTableNameToBeCreatedJList.getSelectedIndex());
                String secondTableColumnName = (String) secondTableNameToBeReferencedJList.getModel().getElementAt(secondTableNameToBeReferencedJList.getSelectedIndex());
                int tableToBeRefIndex = foreignKeyCreatingTableSelectRefTableTable.getSelectedRow();
                String tableNameToBeRef = (String) foreignKeyCreatingTableSelectRefTableTable.getValueAt(tableToBeRefIndex, 0);
                String appendSQL = "FOREIGN KEY ";
                appendSQL += "(" + firstTableColumnName +")";
                appendSQL += " REFERENCES ";
                appendSQL += tableNameToBeRef + "(" + secondTableColumnName +")";
                appendSQLOfForeignKey = appendSQL;

                addForeignKeyCreateTable2ndPanel.setVisible(false);
                newTableBackPanel.setVisible(true);
            }
        });
        TranslateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel jLabel = new JLabel("Select a Location column to be translate from below:");
                GridBagConstraints c1 = new GridBagConstraints();
                c1.insets = new Insets(10,10,10,10);
                c1.gridx = 0;
                c1.gridy = 0;
                addLatLngGridBagPanel.add(jLabel, c1);


                Connection connection = null;
                ResultSet myRs = null;
                List<String> tempColumnNameList = new ArrayList<String>();
                int columnNumbers = 0;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    DatabaseMetaData metaData = connection.getMetaData();
                    myRs = metaData.getColumns(null,null, selectedTable, null);
                    while (myRs.next()) {
                        //This is the result of all column names in a List Array
                        tempColumnNameList.add(myRs.getString("COLUMN_NAME"));
                    }
                    columnNumbers = tempColumnNameList.size();
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
                String[] stringListFromTable = new String[columnNumbers];
                for (int j = 0; j < columnNumbers; j++) {
                    stringListFromTable[j] = tempColumnNameList.get(j);
                }
                JList listOfTable = new JList(stringListFromTable);
                JScrollPane listScoller = new JScrollPane(listOfTable);
                GridBagConstraints c2 = new GridBagConstraints();
                c2.gridx = 0;
                c2.gridy = 1;
                listOfTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                addLatLngGridBagPanel.add(listScoller, c2);

                addLatLng1stPanel.setVisible(true);
                DataPanel.setVisible(false);
                addLatLngFromColumns = listOfTable;
            }
        });
        addLatLngOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLocationColumn = (String) addLatLngFromColumns
                        .getModel()
                        .getElementAt(addLatLngFromColumns.getSelectedIndex());

                HashMap<Integer, String> idAndLocationHash = new HashMap<>();
                Connection connection = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "select id, " + selectedLocationColumn + " from "  + selectedTable;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                        while (myRs.next()) {
                            idAndLocationHash.put(myRs.getInt(1), myRs.getString(2));
                        }
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
                AddLatLngColumns addLatLngColumns = new AddLatLngColumns();
                addLatLngColumns.addLatLngColumns(selectedTable,selectedDatabase);

                HashMap<Integer, String> idAndLocationHash2nd = new HashMap<>();
                HashMap<Integer, String> idAndLocationHash3rd = new HashMap<>();
                HashMap<Integer, String> idAndLocationHash4th = new HashMap<>();
                HashMap<Integer, String> idAndLocationHash5th = new HashMap<>();
                try {
                    Statement myStmt = null;
                    Statement myStmt2 = null;
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        for (Map.Entry map : idAndLocationHash.entrySet()) {
                            Geo geo = new Geo((String) map.getValue());
                            //float lat = geo.getLatLong()[0];
                            if (geo.getLatLong().size() == 0){
                                idAndLocationHash2nd.put((Integer) map.getKey(), (String)map.getValue());
                                continue;
                            } else {
                                float lat = geo.getLatLong().get(0);
                                float lng = geo.getLatLong().get(1);
                                //System.out.println(lat + " " + lng);
                                String insertLatValueSQL = "UPDATE " +
                                        selectedTable +
                                        " SET " +
                                        "Latitute = " +
                                        lat +
                                        " WHERE " +
                                        "id = " + map.getKey();

                                String insertLngValueSQL = "UPDATE " +
                                        selectedTable +
                                        " SET " +
                                        "Longitute = " +
                                        lng +
                                        " WHERE " +
                                        "id = " + map.getKey();

                                myStmt = connection.createStatement();
                                myStmt.executeUpdate(insertLatValueSQL);

                                //float lng = geo.getLatLong()[1];

                                myStmt2 = connection.createStatement();
                                myStmt2.executeUpdate(insertLngValueSQL);
                            }
                        }
                        if (!idAndLocationHash2nd.isEmpty()) {
                            for (Map.Entry map : idAndLocationHash2nd.entrySet()) {
                                Geo geo = new Geo((String) map.getValue());
                                //float lat = geo.getLatLong()[0];
                                if (geo.getLatLong().size() == 0){
                                    idAndLocationHash3rd.put((Integer) map.getKey(), (String)map.getValue());
                                    continue;
                                } else {
                                    float lat = geo.getLatLong().get(0);
                                    float lng = geo.getLatLong().get(1);
                                    //System.out.println(lat + " " + lng);
                                    String insertLatValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Latitute = " +
                                            lat +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    String insertLngValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Longitute = " +
                                            lng +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    myStmt = connection.createStatement();
                                    myStmt.executeUpdate(insertLatValueSQL);

                                    //float lng = geo.getLatLong()[1];

                                    myStmt2 = connection.createStatement();
                                    myStmt2.executeUpdate(insertLngValueSQL);
                                }
                            }
                        }
                        if (!idAndLocationHash3rd.isEmpty()) {
                            for (Map.Entry map : idAndLocationHash3rd.entrySet()) {
                                Geo geo = new Geo((String) map.getValue());
                                //float lat = geo.getLatLong()[0];
                                if (geo.getLatLong().size() == 0){
                                    idAndLocationHash4th.put((Integer) map.getKey(), (String)map.getValue());
                                    continue;
                                } else {
                                    float lat = geo.getLatLong().get(0);
                                    float lng = geo.getLatLong().get(1);
                                    //System.out.println(lat + " " + lng);
                                    String insertLatValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Latitute = " +
                                            lat +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    String insertLngValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Longitute = " +
                                            lng +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    myStmt = connection.createStatement();
                                    myStmt.executeUpdate(insertLatValueSQL);

                                    //float lng = geo.getLatLong()[1];

                                    myStmt2 = connection.createStatement();
                                    myStmt2.executeUpdate(insertLngValueSQL);
                                }
                            }
                        }
                        if (!idAndLocationHash4th.isEmpty()) {
                            for (Map.Entry map : idAndLocationHash4th.entrySet()) {
                                Geo geo = new Geo((String) map.getValue());
                                //float lat = geo.getLatLong()[0];
                                if (geo.getLatLong().size() == 0){
                                    idAndLocationHash5th.put((Integer) map.getKey(), (String)map.getValue());
                                    continue;
                                } else {
                                    float lat = geo.getLatLong().get(0);
                                    float lng = geo.getLatLong().get(1);
                                    //System.out.println(lat + " " + lng);
                                    String insertLatValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Latitute = " +
                                            lat +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    String insertLngValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Longitute = " +
                                            lng +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    myStmt = connection.createStatement();
                                    myStmt.executeUpdate(insertLatValueSQL);

                                    //float lng = geo.getLatLong()[1];

                                    myStmt2 = connection.createStatement();
                                    myStmt2.executeUpdate(insertLngValueSQL);
                                }
                            }
                        }
                        if (!idAndLocationHash5th.isEmpty()) {
                            for (Map.Entry map : idAndLocationHash5th.entrySet()) {
                                Geo geo = new Geo((String) map.getValue());
                                //float lat = geo.getLatLong()[0];
                                if (geo.getLatLong().size() == 0){
                                    continue;
                                } else {
                                    float lat = geo.getLatLong().get(0);
                                    float lng = geo.getLatLong().get(1);
                                    //System.out.println(lat + " " + lng);
                                    String insertLatValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Latitute = " +
                                            lat +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    String insertLngValueSQL = "UPDATE " +
                                            selectedTable +
                                            " SET " +
                                            "Longitute = " +
                                            lng +
                                            " WHERE " +
                                            "id = " + map.getKey();

                                    myStmt = connection.createStatement();
                                    myStmt.executeUpdate(insertLatValueSQL);

                                    //float lng = geo.getLatLong()[1];

                                    myStmt2 = connection.createStatement();
                                    myStmt2.executeUpdate(insertLngValueSQL);
                                }
                            }
                        }
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

                try {
                    //point the initialized connection to DB connection. Still use TableManager, the same connection.
                    connection = TableManager.getConnection(selectedDatabase);
                    ResultSet myRs = null;
                    Statement myStmt = null;
                    String SQL = "select * from " + selectedTable;
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myRs = myStmt.executeQuery(SQL);
                    }
                    dataTable.setModel(DbUtils.resultSetToTableModel(myRs));
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
                addLatLng1stPanel.setVisible(false);
                DataPanel.setVisible(true);
                addLatLngGridBagPanel.removeAll();
            }
        });
        backToDataPanelFromLatLngPanelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLatLng1stPanel.setVisible(false);
                DataPanel.setVisible(true);
                addLatLngGridBagPanel.removeAll();
            }
        });
        searchResultVisualizeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rsName = getNameSearchRsTextField.getText();
                String viewSQL = "CREATE VIEW ";
                viewSQL += rsName + " AS ";
                viewSQL += searchQuerySQLforExport;
                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.execute(viewSQL);
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

//                String rsName = getNameSearchRsTextField.getText();
//                GetMetaColumns getMetaColumns = new GetMetaColumns();
//                List<String> tempHeaders = getMetaColumns.getColumnsHeader(selectedDatabase, selectedTable);
//                List<String> headers = new ArrayList<>();
//
//                for (int i = 0; i < tempHeaders.size(); i++) {
//                    headers.add("'" + tempHeaders.get(i) + "'");
//                }
//                String SQL = "SELECT ";
//                int i = 0;
//                while ((i + 1) != (headers.size())) {   //out of bound
//                    SQL += headers.get(i) + ", ";
//                    i++;
//                }
//                SQL += headers.get(i);
//                SQL += " UNION ALL ";
//                SQL += searchQuerySQLforExport;
//                SQL += " INTO OUTFILE " + "'d:/" + rsName + ".csv'" + "FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\r\n'";
//                Connection connection = null;
//                Statement myStmt = null;
//                try {
//                    connection = TableManager.getConnection(selectedDatabase);
//                    if (connection != null) {
//                        myStmt = connection.createStatement();
//                        myStmt.execute(SQL);
//                    }
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                } finally {
//                    if (connection != null) {
//                        try {
//                            connection.close();
//                        } catch (SQLException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                }
                try {
                    Process process = Runtime.getRuntime().exec("C:\\Program Files\\Tableau\\Tableau 2018.1\\bin\\tableau.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        joinResultVisualizeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rsName = getNameJoinRsTextField.getText();
                String viewSQL = "CREATE VIEW ";
                viewSQL += rsName + " AS ";
                viewSQL += joinSQL;
                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    if (connection != null) {
                        myStmt = connection.createStatement();
                        myStmt.execute(viewSQL);
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
//                String rsName = getNameJoinRsTextField.getText();
//                List<String> headers = new ArrayList<>();
//                try {
//                    ResultSetMetaData resultSetMetaData = myRsForExport.getMetaData();
//                    int columnCount = resultSetMetaData.getColumnCount();
//                    for (int i = 1; i <= columnCount; i++) {
//                        headers.add("'" + resultSetMetaData.getColumnName(i) + "'");
//                    }
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//                String SQL = "SELECT ";
//                int i = 0;
//                while ((i + 1) != (headers.size())) {   //out of bound
//                    SQL += headers.get(i) + ", ";
//                    i++;
//                }
//                SQL += headers.get(i);
//                SQL += " UNION ALL ";
//                SQL += joinSQL;
//                SQL += " INTO OUTFILE " + "'d:/" + rsName + ".csv'" + "FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\r\n'";
//                Connection connection = null;
//                Statement myStmt = null;
//                try {
//                    connection = TableManager.getConnection(selectedDatabase);
//                    if (connection != null) {
//                        myStmt = connection.createStatement();
//                        myStmt.execute(SQL);
//                    }
//                } catch (IOException e1) {
//                    e1.printStackTrace();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                } finally {
//                    if (connection != null) {
//                        try {
//                            connection.close();
//                        } catch (SQLException ex) {
//                            ex.printStackTrace();
//                        }
//                    }
//                }
                try {
                    Process process = Runtime.getRuntime().exec("C:\\Program Files\\Tableau\\Tableau 2018.1\\bin\\tableau.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        dropViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tableTable.getSelectedRow();
                if (row < 0) {
                    JOptionPane.showMessageDialog(null,"Please select a view to be dropped");
                    return;
                }
                String viewName = (String) tableTable.getValueAt(row, 0);   //fetch the selected table
                Connection connection = null;
                Statement myStmt = null;
                try {
                    connection = TableManager.getConnection(selectedDatabase);
                    String SQL = "DROP VIEW IF EXISTS " + viewName;
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
    }

    public static void main (String[] args) throws Throwable{
        JFrame frame = new JFrame("MySQL database");
        frame.setContentPane(new DBapp().backPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
