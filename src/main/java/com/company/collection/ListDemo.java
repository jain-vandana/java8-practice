package com.company.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListDemo {
    private static void arrayListDemo(){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(null);
        System.out.println("list is"+list1);
        list1.add(2,25);
        System.out.println("list is"+list1);
        int x = list1.set(2,35);
        System.out.println("list is"+list1);
        list1.add(1);
        // beared	______
        System.out.println("listl.contains(l): " + list1.contains(1));
        System.out.println(" listl.indexOf(1): " + list1.indexOf(1));
        System.out.println("listl.lastlndexOf(1): " + list1.lastIndexOf(1));
        System.out.println("listl: " + list1);
    }

    public static void main(String[] args) {
        arrayListDemo();
    }
}
