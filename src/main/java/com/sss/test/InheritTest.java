package com.sss.test;

public class InheritTest {



    public class Parent {
        public void print() {

        }

        public void printB(){
            print();
        }
    }


    public class ChildA extends Parent {
        public void print() {
            System.out.println("childa");
        }
    }


    public static void main(String[] args) {
        InheritTest test = new InheritTest();

        ChildA childA =  test.new ChildA() ;

        childA.printB();

    }
}
