package hashmap_questions;

import java.util.HashSet;

public class L734_SentenceSimilarity_E {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        // check first condition
        if (words1.length != words2.length) return false;
        // need hashtset for pairs
        HashSet<String> set = new HashSet<>();
        for (String[] p: pairs) {
            if (p.length > 0) {
                set.add(p[0] + "," + p[1]);
            }
        }

        String w1 = null;
        String w2 = null;
        for (int i = 0; i < words1.length; i++) {
            w1 = words1[i];
            w2 = words2[i];
            if (w1.equals(w2)) continue;
            else {
                if (!set.contains(w1 + "," + w2) &&
                        !set.contains(w2 + "," + w1)){
                    return false;
                }
            }
        }

        return true;
    }
}
