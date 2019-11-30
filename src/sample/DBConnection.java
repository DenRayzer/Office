package sample;

import java.sql.*;

public class DBConnection {
    public static Connection dbConnector() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=My_UserBD;username=user1;password=123456";
            con = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public ResultSet GetUser(String login, String passwors) throws SQLException {
        ResultSet resultSet = null;
        String select = "SELECT * FROM Users WHERE _login =? AND _password =?";
        PreparedStatement prst = dbConnector().prepareStatement(select);
        prst.setString(1, login);
        prst.setString(2, passwors);
        prst.executeQuery();
        resultSet = prst.executeQuery();
        return resultSet;
    }

}
