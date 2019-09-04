package DBUtils;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtils {
    private static Connection conn = null;
    public String login;
    public String pass;

    public static void setData(String login, String pass) {
        login = login;
        pass = pass;
    }

    public static void dbConnect(String login, String pass) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException ex) {
            System.out.println("Where is Your database driver?");
            ex.printStackTrace();
            throw ex;        }
        System.out.println("Database driver found!");
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bud_firma", login, pass);
        } catch (SQLException e){
            System.out.println("Connection failed!"+e);
            throw e;        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            throw e;        }
    }

    public static void dbExecuteQuery (String sqlStmt) throws SQLException {
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);
        } catch(SQLException ex) {
            System.out.println("smth went wrong in dbExecuteQuery!"+ex);
            throw ex;        }
        finally {
            if (stmt !=null){
                stmt.close();            }
           // dbDisconnect();
             }
    }
    public static ResultSet dbExecute(String queryStmt) throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            System.out.println("Select statement: " + queryStmt + "\n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();            }
            if (stmt != null) {
                stmt.close();            }
         //   dbDisconnect();
               }
        return crs;    }

 }