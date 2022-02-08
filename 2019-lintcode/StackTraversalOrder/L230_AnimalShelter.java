package StackTraversalOrder;

import java.util.LinkedList;

/*
* An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
* People must adopt either the "oldest" (based on arrival time)
* of all animals at the shelter,
* or they can select whether they would prefer a dog or a cat
* (and will receive the oldest animal of that type).
* They cannot select which specific animal they would like.
* Create the data structures to maintain this system and implement operations such as enqueue,
* dequeueAny, dequeueDog and dequeueCat.

Example
Example 1

Input:
enqueue("james", 1)
enqueue("tom", 1)
enqueue("mimi", 0)
dequeueAny()
dequeueCat()
dequeueDog()
*
*
* */
public class L230_AnimalShelter {
    public void runTest() {
        enqueue("james", 1);
        enqueue("tom", 1);
        enqueue("mini", 0);
        dequeueAny();
        dequeueCat();
        dequeueDog();
    }

    class Pet {
        public int time;
        public String name;
        public Pet(String name, int t) {
            this.name = name;
            this.time = t;
        }
    }
    private LinkedList<Pet> dogs = new LinkedList<>();
    private LinkedList<Pet> cats = new LinkedList<>();
    private int time = 0;

    public void enqueue(String name, int type) {
        // write your code here
        if (type == 0) {
            cats.add(new Pet(name, this.time++));
        } else {
            dogs.add(new Pet(name, this.time++));
        }
    }

    /*
     * @return: A string
     */
    public String dequeueAny() {
        // write your code here
        String name = null;
        if (dogs.isEmpty()) {
            return cats.pollFirst().name;
        } else if (cats.isEmpty()) {
            return dogs.pollFirst().name;
        } else {
            if (dogs.peekFirst().time < cats.peekFirst().time) {
                return dogs.pollFirst().name;
            } else {
                return cats.pollFirst().name;
            }
        }
    }

    /*
     * @return: A string
     */
    public String dequeueDog() {
        // write your code here
        if (dogs.isEmpty()) return null;
        return dogs.pollFirst().name;
    }

    /*
     * @return: A string
     */
    public String dequeueCat() {
        // write your code here
        if (cats.isEmpty()) return null;
        return cats.pollFirst().name;
    }

}
