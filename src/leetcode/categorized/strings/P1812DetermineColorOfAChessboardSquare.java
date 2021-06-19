package leetcode.categorized.strings;

class P1812DetermineColorOfAChessboardSquare {
    // MYSELF
    // TIME: 5 mins
    // DATE: 16-06-21
    // CONTEST: Biweekly Contest 49 Virtual
    public boolean squareIsWhite(String coordinates) {
        int c = coordinates.charAt(0) - 'a' + 1;
        int r = Integer.parseInt(coordinates.charAt(1) + "");
        if ((c + r) % 2 == 0) return false;
        return true;
    }
}