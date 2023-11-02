package home.work.exception;

public class ParseNumber {
    public ParseNumber(long l) {
    }
    public static String check(String args){
        if (args.length() == 11){
            return args;
        }
        throw new NumberFormatException(){};
    }
}
