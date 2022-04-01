package com.example.tinderclone.Login;

import android.util.Patterns;

import java.util.regex.Pattern;

public class ValidationHelper {

    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    public static boolean isValidEmail(String email) {
        if (email == null) return false;

        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static boolean isValidConfirmPassword(String cpassword , String password) {
        if (cpassword == null || !cpassword.equals(password)) return false;
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(cpassword).matches() ;
    }

    public static boolean isValidPassword(String password) {
        if (password == null) return false;

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        return pattern.matcher(password).matches();
    }
    public static boolean Validate(String email, String password,String cpassword){
        return isValidEmail(email) && isValidPassword(password) && isValidConfirmPassword(cpassword, password);
    }
}
