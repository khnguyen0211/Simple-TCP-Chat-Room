/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pnkn0
 */
public class Validator {
    
    public boolean isEmailValid(String email){
        var regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isNameValid(String name){
        if (name != null && name.length() > 0) {
            var regex = "^(\\w+.*[^0-9].*){2,40}$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean checkComfirmPassword(String password, String confirm) {
        if(password.compareToIgnoreCase(confirm) == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean checkSpace(String s) {
        if(s.trim().length() == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isStringNumber(String s) {
        var regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
