package xmltask.bsu.by;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class HamletInternational {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 — английский \n2 — белорусский \nлюбой — русский");
        char i = scanner.nextLine().charAt(0);
        String country = "";
        String language = "";
        switch (i) {
            case '1':
                country = "US";
                language = "EN";
                break;
            case '2':
                country = "BY";
                language = "by";
                break;
        }
        Locale current = new Locale(language, country);
        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        String s1 = rb.getString("str1");
        System.out.println(s1);
        String s2 = rb.getString("str2");
        System.out.println(s2);
    }
}