package com.company.DataStructure;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by stephenbai on 2016-11-10.
 */
public class MatchingParenthesis {
    // prints
    public void solution(String input){
        Scanner in = new Scanner(input);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            if (checkIfMatch(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public boolean checkIfMatch( String s){
        if ( s.length()%2 !=0 ){
            return false;
        }
        Stack< Character > mStack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);
            char output ;
            if ( (tmp == '(')||
                    (tmp =='{')||(tmp =='[')){
                mStack.push(tmp);
            }else{
                // now pop the stack
                // NEED TO CHECK EMPTY for cases like }{
                if (mStack.isEmpty()) return false;
                tmp = mStack.pop();
                output = s.charAt(i);
                if (output ==')'){
                    if ( (tmp ^ '(') > 0 ){
                        return false;
                    }
                }else if(output ==']'){
                    if ((tmp ^ '[') > 0){
                        return false;
                    }

                }else if(output =='}') {
                    if((tmp^'{')>0 ){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
        // stack needs to be empty !!
        if( mStack.isEmpty())
        return true;
        return false;
    }


    // Clean and Elegant
    // HashMap && Stack Implementation
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (map.containsValue(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
