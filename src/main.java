public class main {
//    public static void main(String [] args) {
//        Connection connection = null;
//        try {
//            List<Database> databases = null;
//            connection = DBmanager.getConnection();
//            if (connection != null) {
//                System.out.println("Connection Established");
//                databases = DBmanager.getAllDatabases(connection);
//            }
//            for (Database temp : databases) {
//                System.out.println(temp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
//    public static void main(String [] args) {
//        Connection connection = null;
//        try {
//            List<Table> tables = null;
//            connection = TableManager.getConnection("newarkdata");
//            if (connection != null) {
//                System.out.println("Connection Established");
//                tables = TableManager.getAllTables(connection, "newarkdata");
//            }
//            for (Table temp : tables) {
//                System.out.println(temp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }

      public static void main(String[] args) {
          String table = "people";
          String column = " var";
          String datatype = " int";
          String st = "create table " + table;
          st += column;
          st += datatype;
          System.out.println(st);
          int i = 0;
          while (i != 10) {
              i++;
          }
          System.out.println(i);
      }
}
