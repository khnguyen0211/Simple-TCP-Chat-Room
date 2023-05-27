/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
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
public class FileThread extends Thread {

    Socket socket;
    JTextArea txt;
    BufferedReader bf;
    String receiver;

    public FileThread(Socket socket, JTextArea txt, String receiver) {
        this.socket = socket;
        this.txt = txt;
        this.receiver = receiver;
        try {
            this.bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(FileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            DataInputStream is = null;
            FileOutputStream outputStream = null;
            while (true) {
                if (socket != null) {
                    // Receive file name and size from client
                    is = new DataInputStream(socket.getInputStream());
                    String fileName = is.readUTF();
                    long fileSize = is.readLong();
                    String url = "";
                    if (receiver.compareToIgnoreCase("Manager") == 0) {
                        url = "C:\\Users\\pnkn0\\OneDrive\\Desktop\\Chat App Project\\src\\clientFiles\\";
                    } else {
                        url = "C:\\Users\\pnkn0\\OneDrive\\Desktop\\Chat App Project\\src\\serverFiles\\";
                    }
                    // Create output stream to save the file to a folder
                    File outputFile = new File(url + fileName);
                    outputStream = new FileOutputStream(outputFile);

                    // Receive file bytes from client and save to output stream
                    byte[] buffer = new byte[8192];
                    int count;
                    while (fileSize > 0 && (count = is.read(buffer, 0, (int) Math.min(buffer.length, fileSize))) != -1) {
                        outputStream.write(buffer, 0, count);
                        fileSize -= count;
                    }

//                    // Close the streams and socket
//                    outputStream.close();
//                    is.close();
//                    socket.close();

                      txt.append(receiver + ": " + fileName + "\n");
                }
            }
        } catch (IOException ex) {
//            Logger.getLogger(ReceiveFileThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isNotFileName(String str) {
        String[] fileExtensions = {".txt", ".pdf", ".docx", ".jpg", ".png", ".zip"}; // thêm các đuôi mở rộng tập tin cần kiểm tra
        for (String ext : fileExtensions) {
            if (str.contains(ext)) {
                return false;
            }
        }
        return true;
    }
}
