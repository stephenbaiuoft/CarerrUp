package com.company.november;

/**
 * Created by stephenbai on 2016-11-10.
 */
//
//StringRightRotation mRote = new StringRightRotation();
//        if (mRote.solution("stackoverflow", "overflowstack")){
//        System.out.println("True");
//        }else{
//        System.out.println("False");
//        }

public class StringRightRotation {
    public boolean solution(String s1, String s2){
        if ( (s1==null)||(s2==null)||( s1.length()==0) ||(s2.length() ==0)
                ||(s1.length()!=s2.length())){
            return false;
        }
        String hold = s1 + s1;
        return (hold.indexOf(s2) > -1) ? true: false;
    }

}
