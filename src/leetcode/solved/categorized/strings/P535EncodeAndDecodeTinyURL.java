package leetcode.solved.categorized.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class P535EncodeAndDecodeTinyURL {

    // NEEDED HELP
    // DATE: 16-May-2021, first attempt
    // EXPLANATION: https://leetcode.com/problems/encode-and-decode-tinyurl/discuss/1110551/JS-Python-Java-C%2B%2B-or-Easy-Map-Solution-w-Explanation
    public class Codec {

        Map<String, String> tinyLongMap = new HashMap<>();
        Map<String, String> longTinyMap = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (longTinyMap.containsKey(longUrl)) return longTinyMap.get(longUrl);

            String tinyUrl = getTinyURL(longUrl);
            while (tinyLongMap.containsKey(tinyUrl)) tinyUrl = getTinyURL(longUrl);

            tinyLongMap.put(tinyUrl, longUrl);
            longTinyMap.put(longUrl, tinyUrl);
            return tinyUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return tinyLongMap.get(shortUrl);
        }

        private String getTinyURL(String url) {
            String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random rand = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(chars.charAt((int) rand.nextInt(chars.length())));
            }
            String tinyUrl = "http://tinyurl.com/" + sb.toString();
            System.out.println("Tiny URL: " + tinyUrl);
            return tinyUrl;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

}

