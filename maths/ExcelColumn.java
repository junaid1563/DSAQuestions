package maths;

//https://leetcode.com/problems/excel-sheet-column-title/
public class ExcelColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(3421));
        System.out.println(convertToTitle(31));
        System.out.println(convertToTitle(21));
        System.out.println(convertToTitle(1));
    }

    public static String convertToTitle(int columnNumber) {
        char[] cols = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
                'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        int num = columnNumber;
        StringBuilder sb = new StringBuilder();
        while (num > 26) {
            // divide until num<=26
            int rem = num % 26;
            if (rem == 0) {
                // if multiple of 26, eg. 52
                // change rem = 26 and reduce num by 1
                rem = 26;
                num--;
            }
            sb.append(cols[rem - 1] + "");
            num = num / 26;
        }
        if (num > 0) {
            sb.append(cols[num - 1]);
        }
        return sb.reverse().toString();
    }
}