package by.javacourse.se.homework2.task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {

        String inText = "шла Саша по шоссес и ссосала сушкусс точна Сушскус точноссс ссстооо пудов тоносососточно";//
        Pattern pattern = Pattern.compile("\\b([A-Za-zА-Яа-я]*[CcСс][A-Za-zА-Яа-я]*){3,}\\b");
        Matcher matcher = pattern.matcher(inText);

        int counter = 0;
        while (matcher.find()) {
            counter++;
            System.out.println(inText.substring(matcher.start(), matcher.end()));
        }
        System.out.println("Количество слов:" + counter);
    }
}
