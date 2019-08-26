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
        int realShift = shift % period;

        for (char ch : c) {
            char newChar;
            if (ch >= begin && ch <= end) {
                // do shift
                newChar = (char)((((ch - begin) + (period - realShift)) % period) + begin);
            } else {
                newChar = ch;
            }
            sb.append(newChar);
        }
        return sb.toString();
    }

    private static String encryptor(String st, int shift) {
        StringBuilder sb = new StringBuilder();
        char c[] = st.toCharArray();
        int realShift = shift % period;

        for (char ch : c) {
            char newChar;
            if (ch >= begin && ch <= end) {
                // do shift
                newChar = (char) (((ch - begin + realShift) % period) + begin);
            } else {
                newChar = ch;
            }
            sb.append(newChar);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String phrase = scanner.nextLine();
//        int shift = scanner.nextInt();

        String phrase = "Welcome to hyperskill!";
        int shift = 5;

        System.out.println(encDec("enc", phrase, shift));
    }
}
