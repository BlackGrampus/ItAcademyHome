package by.javacourse.se.homework2.task9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String inText = "Волна я воЛна новая волнА ты чо я волна а шо можна волнаволна";
        String inSomeWord = "волна";

        inText = inText.toLowerCase();
        inSomeWord = inSomeWord.toLowerCase();

        Pattern pattern = Pattern.compile("\\b" + inSomeWord + "\\b");
        Matcher matcher = pattern.matcher(inText);

        while (matcher.find()) {
            System.out.println("Индекс :" + matcher.start());
        }
    }
}
