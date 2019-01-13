package stack_array_property;

import java.util.ArrayList;
import java.util.List;

public class L402_RemoveKDigits_M {
    public L402_RemoveKDigits_M() {
        String num = "2001432219";
        String rez = removeKdigits(num, 3);

    }

    public String removeKdigits(String num, int k) {
        //change to list
        List<Character> list = new ArrayList<Character>();
        for(char c : num.toCharArray()){
            list.add(c);
        }
        //we need to remove k digits
        for(int i = 0; i<k; i++){
            int size = list.size();
            //observation 1
            if(size > 1 && list.get(1) == '0'){
                list.remove(0);
                while(!list.isEmpty() && list.get(0) == '0'){
                    list.remove(0);
                }
            }

            // size == list.size() makes sure first case and 2nd case CANNOT Happen at the same time
            //if no observation 1, use observation 2
            if(size == list.size()){
                // the for-loop ensures that always the largest element is popped every time
                for(int j = 0; j < size; j++){
                    if((j < size - 1 && list.get(j) > list.get(j+1)) || (j == size - 1)){
                        list.remove(j);
                        break;
                    }
                }
            }
        }
        //generate output
        if(list.size() == 0) return "0";
        StringBuilder result = new StringBuilder();
        for(Character c : list){
            result.append(c);
        }
        return result.toString();
    }
}
