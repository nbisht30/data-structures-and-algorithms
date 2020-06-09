package codingblocks.tries;

import java.util.BitSet;

/**
 * @author Nikhil Bisht
 * @date 09-06-2020
 */
public class HuffmanClient {
    public static void main(String[] args) {
        String str = "abbccda";
        HuffmanEncoderDecoder huffmanEncoderDecoder = new HuffmanEncoderDecoder(str);
        String codedString = huffmanEncoderDecoder.encode(str);
        System.out.println(codedString);
        System.out.println(huffmanEncoderDecoder.decode(codedString));


        // codedString currently occupies a more bytes than the orriginal string str as it has more number of characters
        // so we need to store bits as bits, instead of storing them as characters inside a string.

        BitSet bitSet = new BitSet(codedString.length());
        for (int i = 0; i < codedString.length(); i++) {
            if (codedString.charAt(i) == '1') {
                bitSet.set(i);
            }
        }

        byte[] arr = bitSet.toByteArray(); //to count number of bytes finally occupied
        System.out.println("********************************");
        System.out.println("Final size occupied by coded string in HDD: " + arr.length);
        System.out.println("Final coded string: " + bitSet);


    }
}
