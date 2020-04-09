package leetcode.randomproblems.strings;

/**
 * @author Nikhil Bisht
 * @date 04-04-2020
 */
/*
 * https://leetcode.com/problems/defanging-an-ip-address/
 * */
public class DefangingAnIPAddress {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
    }

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
