package by.javacourse.se.homework2.task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        String inText = "Abra kadabra abra abrA кадабра Абра абра кадабра абра аа АА ";

        Pattern pattern = Pattern.compile("(\\b[АаAa][АаAa]\\b)|(\\b[АаAa][A-Za-zА-Яа-я]+?[АаAa]\\b)");
        Matcher matcher = pattern.matcher(inText);

        System.out.println(matcher.find());
        while (matcher.find()) {
            System.out.println(inText.substring(matcher.start(), matcher.end()));
        }
    }
}
