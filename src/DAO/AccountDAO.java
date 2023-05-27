/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.*;
import database.ConnectDB;
import models.Account;

/**
 *
 * @author pnkn0
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement sttm = null;

    public int insertAccount(Account account) throws SQLException {
        String sql = "insert accounts(fullname, username, pass, email)" + " values (?, ?, ?, ?)";
        conn = new ConnectDB().getConnection();
        sttm = conn.prepareStatement(sql);
        sttm.setString(1, account.getFullName());
        sttm.setString(2, account.getUsername());
        sttm.setString(3, account.getPassword());
        sttm.setString(4, account.getEmail());

        if (sttm.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    public boolean checkAccount(String userName) throws SQLException {
        String sql = "select * from accounts where username = ?";

        conn = new ConnectDB().getConnection();

        sttm = conn.prepareStatement(sql);

        sttm.setString(1, userName);

        ResultSet resultSet = sttm.executeQuery();

        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean findAccount(String userName, String password) throws SQLException {
        String sql = "select * from accounts where username = ? and pass = ?";

        conn = new ConnectDB().getConnection();

        sttm = conn.prepareStatement(sql);

        sttm.setString(1, userName);
        sttm.setString(2, password);

        ResultSet resultSet = sttm.executeQuery();

        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }

    }

    public String findAccountById(int id) throws SQLException {
        String sql = "select * from accounts where id = ?";

        conn = new ConnectDB().getConnection();

        sttm = conn.prepareStatement(sql);

        sttm.setInt(1, id);
       

        ResultSet resultSet = sttm.executeQuery();

        if (resultSet.next()) {
            return resultSet.getObject(2).toString();
        } else {
            return null;
        }

    }
    
    public String FindFullNameByUsername(String userName) throws SQLException {
        String sql = "select * from accounts where username = ?";

        conn = new ConnectDB().getConnection();

        sttm = conn.prepareStatement(sql);

        sttm.setString(1, userName);

        ResultSet resultSet = sttm.executeQuery();

        if (resultSet.next()) {
            return resultSet.getObject(2).toString();
        } else {
            return null;
        }

    }
    public static void main(String[] args) throws SQLException {

        AccountDAO x = new AccountDAO();
        System.out.println(x.FindFullNameByUsername("admin"));
    }
}
