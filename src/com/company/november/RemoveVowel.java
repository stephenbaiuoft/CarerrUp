package com.company.november;

/**
 * Created by stephenbai on 2016-11-10.
 */
public class RemoveVowel {
    // prints vowels
    public void solution(String str){
        StringBuilder sb = new StringBuilder();
        String v = "aeiouAEIOU";
        for(int i = 0; i < str.length(); i++){
            if(v.indexOf(str.charAt(i)) > -1) continue;
            sb.append(str.charAt(i));
        }
        str = sb.toString();
        System.out.println(str);
    }
}
