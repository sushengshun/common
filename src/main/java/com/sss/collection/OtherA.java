package com.sss.collection;

import java.util.*;

public class OtherA {

    //Collections collections = new Collections();

    public static void a(){
        String[] s = new String[2];

        List<String> a = new ArrayList<String>();

        Map map = new HashMap();

        map.put(null,"abc");

        System.out.println(map.get(null));

        SortedMap sortedMap = new TreeMap();

    }

    public static void main(String[] args) {
        a();
    }

}
