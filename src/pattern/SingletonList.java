/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pattern;

import java.util.ArrayList;

/**
 *
 * @author pnkn0
 */
public class SingletonList {
    private static SingletonList instance;
    private ArrayList<String> listKey = new ArrayList<>();

    public ArrayList<String> getListKey() {
        return listKey;
    }
    
    private SingletonList() {
    
    }
    
    public static synchronized SingletonList getIntace() {
        if(instance == null) {
            instance = new SingletonList();
        }
        return instance;
    }
}
