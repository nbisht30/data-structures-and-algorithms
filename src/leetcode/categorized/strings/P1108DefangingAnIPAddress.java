package leetcode.categorized.strings;

public class P1108DefangingAnIPAddress {

    public static String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(address.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
