package IBM_OA;

/**
 *         ReverseString program = new ReverseString();
 String input = "Hello Waston";
 program.reverseInput(input);
 */

public class ReverseString {

    public void reverseInput(String input) {
        //Scanner scan = new Scanner(System.in);
        //while(scan.hasNext()){
        input = input.trim();
        if(input.length() <= 0) {
            return;
        }
        char[] ary = input.toCharArray();
        // flip it once
        char[] revAry = reverse(ary, 0, ary.length - 1);

        // flip every word now
        int startIndex = 0;
        for(int i = 0; i < revAry.length - 1; i++) {
            if ( revAry[i] == ' ') {
                formatWord(revAry, startIndex, i);
                // move to the next word
                startIndex = i + 1;
            }

        }
        // reverse the last word
        formatWord(revAry, startIndex, ary.length - 1);

        String output =  String.valueOf(revAry);
        System.out.println("output is: " + output);
        //}

    }

    public void formatWord(char[] word, int left, int right) {
        word[left] = Character.toUpperCase(word[left]);
        word[right] = Character.toLowerCase(word[right]);
    }

    // reverse, prints, and returns
    public char[] reverse(char[] word, int left, int right) {

        while(left < right) {
            //swap letters
            word[left] ^= word[right];
            word[right] ^= word[left];
            word[left] ^= word[right];

            left ++;
            right --;
        }
        // return the result;
        return word;
    }
}
