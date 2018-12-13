import java.util.ArrayList;
import java.util.List;

/**
 * Created by compu on 26/06/2018.
 */
public class Main {

    public static void main(String[] args) {

        String input =  "0B012722900021AC35B2";
        List<Integer> list = new ArrayList<>();
        int checkDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            String s = String.valueOf(input.charAt(i));
            int h = Integer.valueOf(s, 16);
            list.add(h);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 != 0) {
                int j = list.get(i)*2;
                String s = Integer.toHexString(j);
                if (s.length() > 1) {
                    int k = Integer.parseInt(s);
                    int l = 0;
                    while (k > 0) {
                        l += (k % 10);
                        k = k / 10;
                    }
                    list.set(i, l);
                } else if (s.matches("^[0-9]$")) {
                    list.set(i, Integer.parseInt(s));
                }
            }
            checkDigit += list.get(i);
        }
        checkDigit = 16 - (checkDigit %16);
        System.out.println("The check digit for " + input + " is : " + checkDigit +
        "\n\nTherefore the final output is : " + input + checkDigit);
    }
}
