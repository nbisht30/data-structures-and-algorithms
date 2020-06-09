package codingblocks.tries;

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

    }
}
