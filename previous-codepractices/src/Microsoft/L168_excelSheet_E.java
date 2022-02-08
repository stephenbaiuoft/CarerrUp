package Microsoft;


/**
 *
 * Given a positive integer, return its corresponding
 * column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */


public class L168_excelSheet_E {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while( n > 0) {
            // decrease by 1 since we r using char a here
            n--;
            // always insert at the beginning
            sb.insert(0,  (char)('A' + n%26));

            // next significant digit now
            n /= 26;

        }

        return sb.toString();
    }


}
