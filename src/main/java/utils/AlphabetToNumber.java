package utils;

public class AlphabetToNumber {
    public static final int BASE_ASCII_NUMBER = 64;


    public static int charToNumber(char letter){
        return (int) letter - BASE_ASCII_NUMBER;
    }

    public static char numberToChar(int number){
        return (char) ((char) number + BASE_ASCII_NUMBER);
    }
}
