package com.eddielaio.shorturlsystem.common;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class transformUtil {

    private static final HashMap<Integer, Character> IndexToChar = new HashMap<>();
    private static final HashMap<Character, Integer> CharToIndex = new HashMap<>();
    private transformUtil() {
        initTable();
    }


    private void initTable() {
        for (int i = 0; i < 62; i++) {
            Integer integer = i;
            if (i < 26) {
                IndexToChar.put(integer, (char) ('a' + integer));
            } else if (i >= 26 && i < 52) {
                IndexToChar.put(integer, (char) ('A' + integer - 26));
            } else {
                IndexToChar.put(integer, (char) ('0' + integer - 52));
            }
        }
        Set<Map.Entry<Integer, Character>> entries = IndexToChar.entrySet();
        for (Map.Entry<Integer, Character> entry : entries) {
            Integer key = entry.getKey();
            Character value = entry.getValue();
            CharToIndex.put(value, key);
        }
    }



    public static String base62(Integer id) {
        Stack<Integer> result = new Stack<>();
        StringBuilder s = new StringBuilder();
        while (id > 0) {
            Integer remainder = id % 62;
            result.push(remainder);
            id /= 62;
        }
        while (!result.isEmpty()) {
            s.append(IndexToChar.get(result.pop()));
        }
        while (s.length() < 6){
            //padding with IndexToChar[0]
            s.insert(0, IndexToChar.get(0));
        }
        return s.toString();
    }


    public static long base10(String code) {
        long decVal = 0L;
        for (int i = 0; i < code.length(); i++) {
            int base10 = CharToIndex.get(code.charAt(i));
            decVal += base10 * Math.pow(62, code.length() - i - 1);
        }
        return decVal;
    }

    public static String randomBase62() {
        //generate a random 6 code number for shorten url
        StringBuilder s = new StringBuilder();
        Random r = new Random();
        while (s.length() < 6) {
            int i = r.nextInt(62);
            s.append(IndexToChar.get(i));
        }
        return s.toString();
    }

    private static HashMap<Integer, Character> getIndexToChar() {
        return IndexToChar;
    }

    private static HashMap<Character, Integer> getCharToIndex() {
        return CharToIndex;
    }

}
