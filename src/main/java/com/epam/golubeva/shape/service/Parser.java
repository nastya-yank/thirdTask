package com.epam.golubeva.shape.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static List<Integer> parsToList(String string, String patternString){
        List<Integer> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){
            String group = matcher.group(0);
            String obrez = group.substring(1,group.length()-1);
            String[] numbers = obrez.split(",");
            for (String number : numbers) {
                result.add(Integer.parseInt(number));
            }

        }
        return result;
    }
}
