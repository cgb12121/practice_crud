package com.backend.practice.dump;

public class PasswordValidator {

    /**
     * @^ Start of the String
     * @(?=.*[0-9]) Must contain at least one digit
     * @(?=.*[a-z]) Must contain at least one lowercase character
     * @(?=.*[A-Z]) Must contain at least one uppercase character
     * @(?=.*[@#$%^&+=]) Must contain at least one special character
     * @(?=\\S+$) No whitespace allowed in the password
     * @.{8,} The password is at least 8 characters
     * @$ End
     */
    public static boolean isValidPassWord(String password) {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=`<>!·~',:;*/+-._])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }
}
