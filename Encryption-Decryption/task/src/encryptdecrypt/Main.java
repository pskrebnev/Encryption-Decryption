package encryptdecrypt;

import java.util.ArrayList;
import java.util.Arrays;
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

    private static ArrayList<String> parcing(String[] strings) {
        String mKey = "-key";
        String mMode = "-mode";
        String mData = "-data";
        String mode;
        String data;
        String key;

        ArrayList<String> arrayParam = new ArrayList<>();
        arrayParam.addAll(Arrays.asList(strings));

        if (arrayParam.get(arrayParam.indexOf(mMode) + 1).equals("dec")) {
            mode = "dec";
        } else {
            mode = "enc";
        }

        if (arrayParam.contains(mData)) {
            data = arrayParam.get(arrayParam.indexOf(mData) + 1);
        } else {
            data = "";
        }

        if (arrayParam.contains(mKey)) {
            key = arrayParam.get(arrayParam.indexOf(mKey) + 1);
        } else {
            key = "";
        }

        arrayParam.clear();
        arrayParam.add(0, mode);
        arrayParam.add(1, data);
        arrayParam.add(2, key);

        return arrayParam;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String mode = parcing(args).get(0);
        String data = parcing(args).get(1);
        int key = Integer.parseInt(parcing(args).get(2));

        while (data.isEmpty()) {
            data = scanner.nextLine();
            key = scanner.nextInt();
        }

        System.out.println(encDec(mode, key, data));
    }
}
