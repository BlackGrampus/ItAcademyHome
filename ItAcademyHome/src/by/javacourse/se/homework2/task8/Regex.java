package by.javacourse.se.homework2.task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String inText = "Я тутака 1234-4321-1234-4321 ne ya tyta 2234-4321-7234-4621";

        Pattern pattern = Pattern.compile("(\\d{4}-){3}\\d{4}");
        Matcher matcher = pattern.matcher(inText);

        while (matcher.find()) {
            System.out.println("Номер карты " + inText.substring(matcher.start(), matcher.end()));
        }
    }
}
