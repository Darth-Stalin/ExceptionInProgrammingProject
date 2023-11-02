package home.work.exception;

import java.util.InputMismatchException;
public class ParseGender {
    public ParseGender(char c) {
    }

    public static char genderParse(char args) {

        String as = String.valueOf(args);

        if (as.equals("f") || as.equals("m")) {
            return args;
        }
        throw new InputMismatchException("Invalid symbol");
    }

}
