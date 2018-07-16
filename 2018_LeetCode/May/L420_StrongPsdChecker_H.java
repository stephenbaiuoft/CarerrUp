package May;

public class L420_StrongPsdChecker_H {
    public class Solution {
        public int strongPasswordChecker(String s) {
            if(s == null || s.length() == 0 ) return 6;
            /*Count the changes require for missing types*/
            boolean hasDigit=false, hasUpper=false, hasLower=false;
            int missType=3;
            for (int i = 0; i < s.length(); i++) {
                char ch=s.charAt(i);
                if (!hasDigit && Character.isDigit(ch)) {
                    hasDigit=true;
                    missType--;
                }else if (!hasUpper && Character.isUpperCase(ch)) {
                    hasUpper=true;
                    missType--;
                }else if (!hasLower && Character.isLowerCase(ch)) {
                    hasLower=true;
                    missType--;
                }
            }
            /*Count the changes required for repeating chars in a row*/
            int nReplace=0, nOneDelete=0, nTwoDelete=0, nThreeDelete=0;
            for (int i = 2; i < s.length(); i++){
                if(s.charAt(i) == s.charAt(i-1) && s.charAt(i-1) == s.charAt(i-2)){
                    int len=3;
                    while(i+1 < s.length() && s.charAt(i+1) == s.charAt(i)){
                        len++;
                        i++;
                    }
                    nReplace+= len/3; //replace 1 char in each 3 repeating chars can fix it; e.g., aaa aaa -> aab aab
                    /*Better ways to fix repeating chars, when s.length() > 20 */
                    if(len%3 == 0) nOneDelete++; //One replace can be reduce to One Delete; e.g. aab aab ->  aab aa
                    else if(len%3 == 1) nTwoDelete++; //One replace can be reduced to Two Delete; aab aab a -> aab aa
                }
            }
            if (s.length() < 6) {
                return Math.max(6-s.length(), missType); //repeating chars problem will be automatically fixed by insertion;
            }else if (s.length() <= 20) {
                return Math.max(missType, nReplace); //For repeating chars, replace is always a better choice;
            }else {
                int requiredDelete= s.length()-20; //minimal chars need to be deleted
                int nDelete=0; //chars have been deleted
                /*
                * 每一个都要做  因为 总归有删除的*/
                // aab aab -> aab aa ,can save one replace and reduce required Delete by 1
                int nToDelete= Math.min(requiredDelete, nOneDelete);
                nReplace-= nToDelete; requiredDelete-= nToDelete; nDelete+= nToDelete;
                // aab aab a -> aab aa, can save one replace and reduce required Delete by 2
                nToDelete = Math.min(requiredDelete, nTwoDelete*2);
                nReplace-= nToDelete/2; requiredDelete-= nToDelete; nDelete+= nToDelete;
                //Can always reduce one replacement by deleting three characters, not just length%3==2.
                //For example, for both aab aab a and aab aab aa, you can reduce 2 replacement by deleting 3 * 2 = 6 characters.
                nToDelete = Math.min(requiredDelete, nReplace*3);
                nReplace-= nToDelete/3; requiredDelete-= nToDelete; nDelete+= nToDelete;
                return Math.max(missType, nReplace)+requiredDelete+nDelete;
            }
        }
    }
}
