package com.company.javaClass;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class stringClass {
    public void main(){
        stringBuffer();
        stringBuilder();
    }

    // String
    // 1. synchronized 2. immutable 3. thread-safe
    public void string(){
        String s1 = "Hello";
        String s2 = s1;
        // note this only returns... so yes!! you cannot modify testing.string
        s1.charAt(1) ;
        //s1.rever
    }
    // StringBuffer
    // 1. synchronized 2. mutable 3.thread-safe
    public void stringBuffer(){
        StringBuffer s1 = new StringBuffer("hello");
        s1.replace(0,1,"abcdsadfadsf");
        System.out.println(s1);
    }

    public void stringBuilder(){
        StringBuilder s1 = new StringBuilder("blahello");
        s1.reverse();
        System.out.println(s1);
    }

}
