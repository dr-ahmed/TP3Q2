package com.dev.tp3q2;

public class Constants {

    public static final String DIGIT_REGEX_PATTERN = ".*[0-9]+.*",
            LOWERCASE_REGEX_PATTERN = ".*[a-z]+.*",
            UPPERCASE_REGEX_PATTERN = ".*[A-Z]+.*",
            SYMBOLS_REGEX_PATTERN = ".*[!@#$%^&*()\\-+_€\\[\\]{}?]+.*",
            LENGTH_REGEX_PATTERN = "^.{8,40}$";

    public static final String BEFORE_AT_SIGN_REGEX_PATTERN = "^.{2,}@.*$",
            AFTER_AT_SIGN_REGEX_PATTERN = "^.*@.{3,}$",
            BEFORE_END_WITH_REGEX_PATTERN = ".*(com|org|net).*";

    public static final String YES = "YES";

    public static final String EMAIL_1 = "ahmed@gmail.com",
            PASSWORD_1 = "abcD123!",
            EMAIL_2 = "test@taalimi.org",
            PASSWORD_2 = "Ab?12345";
}
