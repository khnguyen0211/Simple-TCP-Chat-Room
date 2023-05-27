/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author pnkn0
 */
public class OutputThread extends Thread {

    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String receiver;

    public OutputThread(Socket socket, JTextArea txt, String receiver) {
        this.socket = socket;
        this.txt = txt;
        this.receiver = receiver;
        try {
            this.bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(OutputThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (socket != null) {
                    String msg = "";
                    if ((msg = bf.readLine()) != null && msg.length() > 0) {
                        txt.append(receiver + ": " + msg + "\n");
                    }
                }
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    

}
