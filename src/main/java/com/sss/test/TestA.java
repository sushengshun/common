package com.sss.test;

import java.util.TreeMap;

public class TestA {


    public static void a(){

        TreeMap<String,String> treeMap = new TreeMap<>();


        treeMap.put("a","a");
        treeMap.put("d","d");
        treeMap.put("e","e");
        treeMap.put("b","b");


        System.out.println(treeMap.keySet());

    }


    public static void main(String[] args) {
        //a();
    }

}
