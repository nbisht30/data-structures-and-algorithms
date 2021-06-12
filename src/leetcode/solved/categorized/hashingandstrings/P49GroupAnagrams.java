package leetcode.solved.categorized.hashingandstrings;

import java.util.*;

/**
 * @author Nikhil Bisht
 * @date 06-04-2020
 */
public class
P49GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"tin", "ram", "zip", "cry", "pus", "jon", "zip", "pyx"}).
                forEach(System.out::println);
        System.out.println("My code:- ");
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        //Using sorting: Sort each word of strs then you dont need to map different anagrams to a single key, this would be faster when
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

    public List<List<String>> groupAnagramsUsingHashCode(String[] strs) {
        //TTS: 45 mins(Could have solved in 12 mins if not for figuring out that prime numbers can be used)
        //My soln : Get a unique id for each anagram and put all anagrams mapping to their ids in a map,
        // then generate a list of anagram groups from the map, this is a better solution as the size of each word in strs can be large.

        // Need one prime number for one letter for each letter in English alphabet.
        int primes[] = new int[26];

        // Find first 26 primes and fill in the primes array.
        int i = 0;
        for(int j = 2; j < 200 && i < 26 ; j++){
            if(isPrime(j)) primes[i++] = j;
        }

        // Map words to hashcode
        Map<Integer, List<String>> map = new HashMap<>();

        for(String s: strs){
            int code = hashCode(primes, s);
            map.putIfAbsent(code, new ArrayList<>());
            map.get(code).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(Integer code: map.keySet()) res.add(map.get(code));

        return res;
    }

    int hashCode(int[] primes, String word){
        int code = 1;
        for(char ch: word.toCharArray()) code *= primes[ch - 97];
        return code;
    }

    boolean isPrime(int n){
        for(int i = (int)Math.sqrt(n); i >= 2; i--){
            if(n % i == 0) return false;
        }
        return true;
    }
}
