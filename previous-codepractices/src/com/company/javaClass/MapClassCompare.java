package com.company.javaClass;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stephenbai on 2016-11-11.
 */
public class MapClassCompare {
    // HashMap: no ordering in keys or values, key can be null, Unique Keys
    // TreeMap: ordered by Tree
    // LinkedHashMap: preserves insertion order
    // Hashtable: synchronized, No-null Unique Key
    public MapClassCompare(){
        System.out.println("HashMap Output");
        hashMap();
        System.out.println();
        System.out.println("TreeMap Output");
        TestTreeMap();

        System.out.println();
        System.out.println("LinkedMap Output");
        TestLinkedMap();
    }

    public void TestLinkedMap(){
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 40);

        LinkedHashMap<Dog, Integer> linkedHashMap = new LinkedHashMap<Dog, Integer>();
        linkedHashMap.put(d1, 10);
        linkedHashMap.put(d2, 15);
        linkedHashMap.put(d3, 5);
        linkedHashMap.put(d4, 20);

        for (Map.Entry<Dog, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public void TestTreeMap(){
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 40);

        TreeMap<Dog, Integer> treeMap = new TreeMap<Dog, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);

        for (Map.Entry<Dog, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

// function implmentations
    public void hashMap() {
        HashMap<Dog, Integer> hashMap = new HashMap<Dog, Integer>();
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 20);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("white", 10);

        hashMap.put(d1, 10);
        hashMap.put(d2, 15);
        hashMap.put(d3, 5);
        hashMap.put(d4, 20);

        //print size
        System.out.println(hashMap.size());

        //loop HashMap
        for ( Map.Entry<Dog, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " - " + entry.getValue());
        }
    }

}

class Dog implements Comparable<Dog>{
    String color;
    int size;

    Dog(String c, int s) {
        color = c;
        size = s;
    }

    public boolean equals(Object o) {
        return ((Dog) o).color.equals(this.color);
    }

    public String toString(){
        return color + " dog";
    }

    @Override
    public int compareTo(Dog o) {
        // Largest on top to Smallest
        return  o.size - this.size;
    }
}