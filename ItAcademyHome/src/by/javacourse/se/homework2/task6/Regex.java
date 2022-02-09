package by.javacourse.se.homework2.task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String inText = "Longest abra longest длинное ";

        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-я*]*\\b");
        Matcher matcher = pattern.matcher(inText);

        int tempMaxCounterChar = 0;
        String theLongestWord = null;

        while ((matcher.find())) {
            if (tempMaxCounterChar <= matcher.end() - matcher.start()) {
                tempMaxCounterChar = matcher.end() - matcher.start();
                theLongestWord = inText.substring(matcher.start(), matcher.end());
                System.out.println("Самое длинное слово в строке :" + theLongestWord);
            }
        }
    }
}
