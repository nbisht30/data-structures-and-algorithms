package leetcode.thirtydaychallengeapril;

import java.util.*;

/**
 * @author Nikhil Bisht
 * @date 06-04-2020
 */
public class Day6GroupAnagrams {
    static int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

    public static void main(String[] args) {
        groupAnagrams(new String[]{"tin", "ram", "zip", "cry", "pus", "jon", "zip", "pyx"}).
                forEach(System.out::println);
        System.out.println("My code:- ");
        groupAnagramsMyImps(new String[]{"tin", "ram", "zip", "cry", "pus", "jon", "zip", "pyx"}).
                forEach(System.out::println);
    }


    public static List<List<String>> groupAnagrams(String[] strs) {  //Using sorting: Sort each word of strs then you dont need to map different anagrams to a single key, this would be faster when
        // words in strs are of small size but when words are of large size, this would slow down.
        Map<String, List<String>> codeWithAnagrams = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            if (codeWithAnagrams.containsKey(key)) {
                codeWithAnagrams.get(key).add(strs[i]);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(strs[i]);
                codeWithAnagrams.put(key, strings);
            }
        }
        List<List<String>> returnString = new ArrayList<>();
        for (List<String> list : codeWithAnagrams.values()) {
            returnString.add(list);
        }
        return returnString;
    }

    public static List<List<String>> groupAnagramsMyImps(String[] strs) {
        //TTS: 45 mins(Could have solved in 12 mins if not for figuring out that prime numbers can be used)
        //My soln : Get a unique id for each anagram and put all anagrams mapping to their ids in a map,
        // then generate a list of anagram groups from the map, this is a better solution as the size of each word in strs can be large.
        Map<Integer, List<String>> codeWithAnagrams = new HashMap<>();
        List<List<String>> returnString = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            int code = getAnagramCode(strs[i]);
            List<String> strings = codeWithAnagrams.get(code);
            if (strings == null) {
                strings = new ArrayList<>();
                codeWithAnagrams.put(code, strings);
                returnString.add(strings);
            }
            strings.add(strs[i]);
        }
        return returnString;
    }

    public static int getAnagramCode(String str) {
        Integer code = 1;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            code *= (primes[chars[i] - 97]);
        }
        return code;
    }
}
/*
Code: 321 Word: duh
109 97 121

Code: 321 Word: ill
98 117 121
*/
