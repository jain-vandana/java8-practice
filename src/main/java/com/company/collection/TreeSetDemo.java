package com.company.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet t1;
        //t1 = new TreeSet(new TitleComparator());
        t1 = new TreeSet(/*new AutherComparator()*/);

        Book b1 = new Book("java", "bbbb", 1997);
        Book b2 = new Book("HeadFirst", "joshe", 1997);

        t1.add(b1);
        t1.add(b2);

        System.out.println("Tree Set is"+t1);
    }
}
