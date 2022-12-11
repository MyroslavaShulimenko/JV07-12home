package home;

import java.util.*;

public class MainHome {



  //  1. Write a Java method to count the number of words in a string

   // 2.Write a Java method to check if two strings are anagrams of each other or not

    public static void main(String[] args) {
        getWordsWithCount("as soon as possible");
        getWordsWithCount("An anagram is a word or phrase formed by rearranging the letters of a different word or phrase");

        System.out.println("----------------------level2----------------------------");
        System.out.println(checkStringsAnagram("toga", "goat"));
        System.out.println(checkStringsAnagram("asdfg", "adfgh"));
        System.out.println(checkStringsAnagram("thing", "night"));
        System.out.println(checkStringsAnagram("thing", "thing"));
    /*    Map<String, Integer> map = new LinkedHashMap<>();
        map.put("fghj", 1);
        map.put("qwe", 1);
        map.put("rty", 1);
        // map.
        map.put("fghj", 2);
        System.out.println(map);
        for (int i = 0; i < map.size(); i++) {

        }*/
    }

    public static void getWordsWithCount(String sentence) {
        String[] words = sentence.split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String key : words) {
            map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
        }
        System.out.println(map);
    }

    public static boolean checkStringsAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char a = word1.charAt(i);
            char b = word2.charAt(i);
            if (a != b) {
                map.compute(a, (k, v) -> (v == null) ? 1 : v + 1);
                map.compute(b, (k, v) -> (v == null) ? -1 : v - 1);
            }
        }
        System.out.println(map);
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
