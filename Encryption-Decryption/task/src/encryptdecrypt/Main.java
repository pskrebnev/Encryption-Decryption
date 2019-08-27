package encryptdecrypt;

import java.util.Scanner;

public class Main {

    private static String encDec(String mode, int key, String data) {
        switch (mode) {
            case "dec":
                return decryptor(data, key);
            default:
                return encryptor(data, key);
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
        Scanner scanner = new Scanner(System.in);
        String mode = scanner.nextLine();
        int key = scanner.nextInt();
        String data = scanner.nextLine();

        String phrase = "\\jqhtrj%yt%m~ujwxpnqq&";
        int shift = 5;

        System.out.println(encDec(mode, key, data));
    }
}
