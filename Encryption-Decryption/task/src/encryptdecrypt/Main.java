package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static char begin = 'a';
    private static char end = 'z';
    private static int period = end - begin + 1;


    private static String encDec(String mode, String phrase, int shift) {
        switch (mode) {
            case "enc":
                return encryptor(phrase, shift);
            case "dec":
                return decryptor(phrase, shift);
            default:
                return "Please, choose encryption or decryption";
        }
    }

    private static String decryptor(String st, int shift) {
        StringBuilder sb = new StringBuilder();
        char c[] = st.toCharArray();
        char newChar;

        for (char ch : c) {
            newChar = (char) (ch - shift);
            sb.append(newChar);
        }
        return sb.toString();
    }

    private static String encryptor(String st, int shift) {
        StringBuilder sb = new StringBuilder();
        char c[] = st.toCharArray();
        for (char ch : c) {
            char newChar;
            newChar = (char) (ch + shift);
            sb.append(newChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String phrase = scanner.nextLine();
//        int shift = scanner.nextInt();

        String phrase = "\\jqhtrj%yt%m~ujwxpnqq&";
        int shift = 5;

        System.out.println(encDec("dec", phrase, shift));
    }
}
