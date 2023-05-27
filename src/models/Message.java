/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author pnkn0
 */
public class Message {

    private String encryptedMessage;
    private int key;
    private String decryptedMessage;
    private String sender;
    
    public Message() {}

    public Message(String encryptedMessage, int key, String decryptedMessage, String sender) {
        this.encryptedMessage = encryptedMessage;
        this.key = key;
        this.decryptedMessage = decryptedMessage;
        this.sender = sender;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getDecryptedMessage() {
        return decryptedMessage;
    }

    public void setDecryptedMessage(String decryptedMessage) {
        this.decryptedMessage = decryptedMessage;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    
    
}

