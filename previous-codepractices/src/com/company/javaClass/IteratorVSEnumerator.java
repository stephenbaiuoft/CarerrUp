package com.company.javaClass;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class IteratorVSEnumerator {
    public IteratorVSEnumerator(){
        main();
    }

    public void main(){
        Vector v = new Vector();
        Object element;
        Enumeration enum1;
        Iterator iter;
        long start;

        for(int i=0; i<2000000; i++){
            v.add("New Element");
        }

        // vector has both enums/iterators
        // arraylist only has
        enum1 = v.elements();
        iter = v.iterator();

        start=System.currentTimeMillis();
        while(iter.hasNext()){
            element=iter.next();
        }
        System.out.println("Iterator took " + (System.currentTimeMillis()-start));

        System.gc();   //request to GC to free up some memory
        //*************CODE BLOCK FOR ENUMERATION*******************
        start=System.currentTimeMillis();
        while(enum1.hasMoreElements()){
            element=enum1.nextElement();
        }
        System.out.println("Enumeration took " + (System.currentTimeMillis()-start));


    }

    // Iterator allows Caller to remove elements from underlying collection
    // during the iteration with well-defined sematics

    // Iterator, is the interface, with 3 methods
    // hasNext(), next(), remove();


    // Enumeration, is also interface with 2 methods
    // hasMoreElements(), nextElement()

}
