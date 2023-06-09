/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panels;

import DAO.MessageDAO;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import models.Message;

/**
 *
 * @author pnkn0
 */
public class EncryptPanel extends javax.swing.JPanel {

    Socket socket = null;
    BufferedReader bf = null;
    DataOutputStream os = null;
    String sender;
    String receiver;
    String username;
    MessageDAO msgDao = null;

    public JTextArea getTxtMessages() {
        return this.txtMessages;
    }

    /**
     * Creates new form ChatPanel
     */
    public EncryptPanel(Socket socket, String sender, String receiver, String userName) {
        initComponents();
        this.setSize(640, 520);
        this.socket = socket;
        this.sender = sender;
        this.receiver = receiver;
        this.username = userName;
        try {
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(EncryptPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        txtKey = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessages = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(48, 129, 183));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        setToolTipText("");
        setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(48, 129, 183));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cambria", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtMessage.setColumns(20);
        txtMessage.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(48, 129, 183));
        txtMessage.setRows(5);
        txtMessage.setText("aaa");
        jScrollPane1.setViewportView(txtMessage);

        txtKey.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtKey.setForeground(new java.awt.Color(48, 129, 183));
        txtKey.setText("2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KEY");

        btnEncrypt.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEncrypt.setForeground(new java.awt.Color(48, 129, 183));
        btnEncrypt.setText("ENCRYPT");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(48, 129, 183));
        jButton1.setText("RESULT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEncrypt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKey, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMessages.setEditable(false);
        txtMessages.setBackground(new java.awt.Color(255, 255, 255));
        txtMessages.setColumns(20);
        txtMessages.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtMessages.setRows(5);
        jScrollPane2.setViewportView(txtMessages);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        if (txtMessage.getText().trim().length() == 0 || txtKey.getText().trim().length() == 0) {
            JOptionPane.showConfirmDialog(null, "Please fill out those field");
            return;
        }
        try {
            String message = txtMessage.getText();
            int key = Integer.parseInt(txtKey.getText());
            String receiverAndKey = sender + " " + txtKey.getText();
            
            String encryptedMessage = caesarEncrypt(message, key);
            Message msg = new Message(caesarEncrypt(message, key),key, "decrypting...", username);
            try {
                msgDao = new MessageDAO();
                msgDao.insertMessage(msg);
            } catch (SQLException ex) {
                Logger.getLogger(EncryptPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            String encryptedMessageAndKey = encryptedMessage + txtKey.getText();

            os.writeBytes(encryptedMessageAndKey);
            os.write(13);
            os.write(10);
            os.flush();
            txtMessages.append("(encrypted) " + sender + ": " + encryptedMessage + "\n");
            txtMessage.setText("");
        } catch (IOException ex) {
            Logger.getLogger(EncryptPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                String msg = bf.readLine();
                if (msg != null && msg.length() > 0) {
                    String newMsg = "Analyst: \n";
                    String[] lstMsg = msg.split("-");
                    for (int i = 0; i < lstMsg.length; i++) {
                        newMsg += lstMsg[i] + "\n";
                    }
                    JOptionPane.showMessageDialog(null, newMsg);
                } else {
                    
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(EncryptPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        worker.execute();
    }//GEN-LAST:event_jButton1ActionPerformed

    private String caesarEncrypt(String message, int key) {
        String result = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    result += (char) ((ch + key - 65) % 26 + 65);
                } else {
                    result += (char) ((ch + key - 97) % 26 + 97);
                }
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtKey;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextArea txtMessages;
    // End of variables declaration//GEN-END:variables
}
