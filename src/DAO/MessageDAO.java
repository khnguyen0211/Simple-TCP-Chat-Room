/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.*;
import database.ConnectDB;
import models.Message;

/**
 *
 * @author pnkn0
 */
public class MessageDAO {

    Connection conn = null;
    PreparedStatement sttm = null;

    public int insertMessage(Message msg) throws SQLException {
        String sql = "insert messages(encryptedMessage, decryptedMessage, key_message, sender)" + " values (?, ?, ?, ?)";

        conn = new ConnectDB().getConnection();

        sttm = conn.prepareStatement(sql);

        sttm.setString(1, msg.getEncryptedMessage());
        sttm.setString(2, msg.getDecryptedMessage());
        sttm.setInt(3, msg.getKey());
        sttm.setString(4, msg.getSender());
        if (sttm.executeUpdate() > 0) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        MessageDAO x = new MessageDAO();
    }
}
