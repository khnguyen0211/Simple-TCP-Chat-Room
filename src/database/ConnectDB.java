/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author pnkn0
 */
import java.sql.*;

public class ConnectDB {

    private Connection conn = null;

    public Connection getConnection() throws SQLException {
        String serverName = "KHOINGUYEN";
        String dbName = "CaesarChatApp";
        String user = "sa";
        String pass = "52000695";
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;user=" + user + ";password=" + pass;
        return DriverManager.getConnection(connectionUrl);
    }

    public Statement createStatement() throws SQLException {
        this.conn = getConnection();
        Statement stmt = conn.createStatement();
        return stmt;
    }
}