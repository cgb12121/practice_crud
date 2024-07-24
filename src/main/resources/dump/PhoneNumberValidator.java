package com.backend.practice.dump;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    public static boolean isValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\d{10}$.{9,15}");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
