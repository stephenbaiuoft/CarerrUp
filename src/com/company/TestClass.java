package com.company;

/**
 * Created by stephenbai on 2016-11-10.
 */

//  TestClass mTest = new TestClass();
//  mTest.checkStaticInheritance();
public class TestClass {

    public void checkObjectEqual(){

    }

    protected void compareIteratorEnumerator (){

    }


    public void checkStaticInheritance(){
        MCompany mCompany = new MCompany();
        mCompany.staticMethod();
        System.out.println("--------Start nonStatic----------------");
        //
        mCompany.nonStaticMethod();
        System.out.println("---------End nonStatic---------------");
        Company company = new MCompany();
        System.out.println("Using Polymorphism / Parent Class");
        // interesting as it prints static of company,
        // static only runs @ compile time!!!!!!!!
        company.staticMethod();

        company.nonStaticMethod();

    }

}



class MCompany extends Company{

    public static void staticMethod(){
        //super.staticMethod();
        System.out.println("mmmmmmmmmmmmCompany: staticMethod");
    }


    public void nonStaticMethod(){
       // super.nonStaticMethod();
        System.out.println("mmmmmmmmmmmmCompany: nonStaticMethod");
    }
}

class Company{
    public static void staticMethod(){
        System.out.println("Company: staticMethod");
    }

    public void nonStaticMethod(){
        System.out.println("Company: nonStaticMethod");
    }
}

abstract  class Animal{
    float weight;
    void eat(){
        System.out.println("Animal eating");
    }
}

class Mammal extends  Animal{
    void giveMilk(){
        System.out.println("Mammals give milk");
    }
}