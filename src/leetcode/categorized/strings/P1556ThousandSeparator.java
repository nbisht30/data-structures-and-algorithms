package leetcode.categorized.strings;

class P1556ThousandSeparator {
    public String thousandSeparator(int n) {
        if (n == 0) return "0";
        StringBuilder sb = new StringBuilder();
        
        
        int cnt = 0;
        while(n  > 0){
            sb.append(n % 10 + "");
            cnt++;
            if(cnt == 3) {
                sb.append(".");
                cnt = 0;
            }
            n = n/10;
        }
        if(sb.length() > 1 && sb.charAt(sb.length() - 1) == '.') sb.setLength(sb.length() - 1);
        
        return sb.reverse().toString();
    }
}