package dp;

public class L418_SentenceScreenFitting_M {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int l = s.length();

        int startOverall = 0;
        for (int i = 0; i < rows; i++) {
            // add the cols, and then check the character at startOverall
            startOverall += cols;
            if (s.charAt(startOverall%l) == ' ') {
                // " ", we can safely advance startOverall to the next word
                // and we know this is the end for the col
                startOverall += 1;
            } else { // this is the case we need to go back
                while (startOverall > 0 && s.charAt( (startOverall - 1)%l) != ' ' ) {
                    startOverall--;
                }
            }
        }

        return startOverall / l;
    }
}
