package com.dev.tp3q2;

import static com.dev.tp3q2.Constants.*;

public class Utilities {

    public static String isEmailValid(String email) {

        if (email.matches(BEFORE_AT_SIGN_REGEX_PATTERN))
            if (email.matches(AFTER_AT_SIGN_REGEX_PATTERN))
                if (email.matches(BEFORE_END_WITH_REGEX_PATTERN))
                    return YES;
                else
                    return "Le mail doit se terminer par .com, .net ou .org";
            else
                return "Le mail doit avoir au moins 3 caractères après @";
        else
            return "Le mail doit commencer par 2 caractères suivis de @";
    }

    private static boolean hasNoRepetition(String password) {
        for (int i = 0; i < password.length(); i++)
            for (int j = i + 1; j < password.length(); j++)
                if (password.charAt(i) == password.charAt(j))
                    return false;
        return true;
    }

    public static String isPasswordStrong(String password) {
        String message = "Le mot de passe doit comprendre au moins ";

        if (password.matches(DIGIT_REGEX_PATTERN))
            if (password.matches(LOWERCASE_REGEX_PATTERN))
                if (password.matches(UPPERCASE_REGEX_PATTERN))
                    if (password.matches(SYMBOLS_REGEX_PATTERN))
                        if (password.matches(LENGTH_REGEX_PATTERN))
                            if (hasNoRepetition(password))
                                return YES;
                            else
                                return "Aucun caractère du mot de passe ne doit se répéter";
                        else
                            return "La longueur du mot de passe doit etre >= 8 et <= 40";
                    else
                        return message.concat("un cractère de ponctuation");
                else
                    return message.concat("une lettre majuscule");
            else
                return message.concat("une lettre miniscule");
        else
            return message.concat("un chiffre");
    }
}
