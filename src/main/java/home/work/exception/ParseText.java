package home.work.exception;

import java.util.InputMismatchException;

public class ParseText {
    public static String transform(String data) {
        boolean hasDigits = false;

        for(int i = 0; i < data.length() && !hasDigits; ++i) {
            if (Character.isDigit(data.charAt(i))) {
                throw new InputMismatchException("Invalid symbol");
            }
        }
        return data;
    }
}