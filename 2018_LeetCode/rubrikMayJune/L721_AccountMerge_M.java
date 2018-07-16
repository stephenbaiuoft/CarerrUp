package rubrikMayJune;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class L721_AccountMerge_M {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> parents = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();
        // treeset for sorted order
        HashMap<String, TreeSet<String>> unions = new HashMap<>();

        for (List<String> account: accounts) {
            // first email to link to account name
            emailToName.put(account.get(1), account.get(0));
            // this is to loop through the email listing
            for(int i = 1; i < account.size(); i++) {
                // initialize each email to point to itself first
                parents.put(account.get(i), account.get(i));
            }
        }

        // now we can union emails
        for (List<String> account: accounts) {
            // find the parent for first email (always the first)
            String p = find(account.get(1), parents);
            for(int i = 2; i < account.size(); i++) {
                // link the parent for this email to p
                // here --> we use find(account.get(i), parents) ==> this triggers compression!!!

                parents.put(find(account.get(i), parents), p);
            }
        }

        for (List<String> account: accounts) {
            // important to avoid infinite loop
            String p = find(account.get(1), parents);
            if (!unions.containsKey(p)) {
                TreeSet<String> set = new TreeSet<>();
                unions.put(p, set);
            }

            for(int i = 1; i < account.size(); i++) {
                unions.get(p).add(account.get(i));
            }
        }

        List<List<String>> rez = new ArrayList<>();
        for (String s: unions.keySet()) {
            //
            List<String> emailList = new ArrayList(unions.get(s));
            emailList.add(0, emailToName.get(s));
            rez.add(emailList);
        }

        return rez;
    }


    private String find(String email, HashMap<String, String> parents) {
        String p = parents.get(email);
        if (!email.equals(p)) {
            parents.put(email, find(p, parents));
        }
        // return updated one at last
        return parents.get(email);
    }
}
