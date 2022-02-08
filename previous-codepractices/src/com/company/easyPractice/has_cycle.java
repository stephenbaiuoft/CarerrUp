package com.company.easyPractice;

import java.util.Hashtable;

/**
 * Created by stephenbai on 2016-10-22.
 */

/* Testing Function
has_cycle test = new has_cycle();
        if (test.run()){
        System.out.print(1);
        }
        else{
        System.out.print(0);
        }
        */
public  class has_cycle{

    private Hashtable<String,Boolean> hashtable ;
    private Node head;
    public void createNode(){
        Node current;
        Node newNode;

        head = new Node();
        head.data = 500;
        current = head;
        for (int i = 0; i< 10; i++){
            newNode = new Node();
            newNode.data = i ;
            newNode.next = null;

            current.next = newNode;
            current = newNode;
        }
        // value should be 9
        System.out.println(current.data);
       // current.next = head.next.next.next.next;
    }

    public  Boolean run(){
        createNode();
        hashtable = new Hashtable<>();
        if (head == null) return false;
        while(head.next!=null){
            if (hashtable.containsKey( head.next.toString() )){
                return true;
            }else{
                hashtable.put( head.next.toString(), true);
            }
            //go to next one
            head = head.next;

        }
        return false;
    }


}

    /*
    Node head = new Node();
    head.data = 100;
    head.next = new Node();
    head.next.data = 200;

    Node ptr = new Node();
    ptr.data = 500;
    ptr.next = head.next;

    System.out.print( "ptr.next is: " );
    System.out.println( ptr.next.toString() );

    System.out.print( "head.next is: " );
    System.out.println( head.next.toString() );

    // Result: same head.next value with ptr.next value... This is called reference

    */
