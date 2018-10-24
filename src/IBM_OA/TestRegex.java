package IBM_OA;

import java.util.*;
/*
*         TestRegex program = new TestRegex();
        String input1 = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive     computing |" +
                "\'IBM Cognitive Computing\' is a revolution?";

        String input2 = "\"Computer Science Department\"|Computer-Science-Department|the \"computer science department\"";

        //program.solution(input1);
        program.solution(input2);
* */

public class TestRegex{
    // output the testing.string
    public void solution(String passage) {

        // assuming passage is given correctly
        String pattern = "\\d";
        String[] hold = passage.split("\\|");
        LinkedHashMap<String, String> map  = new LinkedHashMap<>();
        //HashSet<String> set = new HashSet<>();

        for (String str:hold) {
            String parsed = parse(str);
            // iterate throug the map
            boolean add = true;
            Iterator<String> itr = map.keySet().iterator();
            while(itr.hasNext())
            {
                String pIterator = itr.next();
                if ( pIterator.contains(parsed) && pIterator.length() > parsed.length() ){
                    // break out the for-loop
                    add = false;
                    break;
                }
                // if a tie, AND str has a smaller length
                else if ( pIterator.equals(parsed) ) {
                    if ( map.get(pIterator).length() > str.length()) {
                        // remove this entry
                        itr.remove();
                        break;
                    } else {
                        // yeah this logic is crazy
                        add =false;
                        break;
                    }
                }
                // if parsed is a larger set
                else if (parsed.contains(pIterator) && parsed.length() > pIterator.length()) {
                    // remove this iterator
                    itr.remove();
                    break;
                }

            }
            if(add) {
                // add to map
                map.put(parsed, str);
            }
        }

        // output results
        Collection <String> results = map.values();
        String output = String.join("|", results);
        System.out.println("output is:" + output);

    }

    // removes the parsed set
    public boolean keyStrContains(String parsed, Set<String> keySet) {
        Iterator itr = keySet.iterator();
        while(itr.hasNext()) {
            String str = (String) itr.next();
            if (parsed.length() > str.length() && parsed.contains(str)) {
                // remove this element
                itr.remove();
                return true;
            }
            // check if already contained by the list
            else if (str.contains(parsed)) {
                return true;
            }
        }

        return false;
    }

    // parses each input based on the 4 rules
    public String parse(String input) {
        // remove trailing and leading space
        input = input.trim();

        // change multi space to single space
        input = input.replaceAll("\\s+", " ");
        //System.out.println("1 parsed result is: " + input);
        // change non-alphanumeric char to ""
        input = input.replaceAll("[^\\w\\s]", "");
        //System.out.println("2 parsed result is: " + input);

        input = input.toLowerCase();
        System.out.println("parsed result is:-" + input + "-");
        return input;
    }
}