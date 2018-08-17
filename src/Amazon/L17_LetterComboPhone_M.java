package Amazon;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class L17_LetterComboPhone_M {
    private List<String> mResult = new LinkedList<>();
    private String[] numDictionary = {
            "","",
            "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };

    private int length;
    private String digits;

    public List<String> letterCombinations(String digits) {
        this.length = digits.length();
        this.digits = digits;
        if (this.length == 0) {
            return mResult;
        }

        String str = "";
        getString(0, str);

        return mResult;
    }

    // recursion method
    // length is current length
    private void getString(int index, String str) {
        if (index == this.length ) {
            mResult.add(str);
            return;
        }
        else {
            int intIndex = Character.getNumericValue( this.digits.charAt(index));
            String string = numDictionary[intIndex];
            for (char c : string.toCharArray()) {
                getString(index + 1, str + c);
            }
        }

    }

}
