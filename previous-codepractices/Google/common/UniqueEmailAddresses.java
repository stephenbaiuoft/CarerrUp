import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};

//        Solution s = new Solution();
//        System.out.println(s.numUniqueEmails(emails));

        System.out.println("asdb".split("@")[0]);
    }



}

class Solution {

    public int numUniqueEmails(String[] emails) {
        Set set = new HashSet<String>();
        Arrays.stream(emails)
                .forEach(email -> set.add(strip(email)));

        return set.size();
    }



    private String strip(String email) {
        // return domain
        String[] result = email.split("@");
        return result[0].split("\\+")[0].replace(".", "") + "@" + result[1];
    }
}