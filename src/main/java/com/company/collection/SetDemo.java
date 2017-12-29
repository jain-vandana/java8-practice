package com.company.collection;

import java.util.*;

public class SetDemo {
   /* @Override
    public String toString() {
        return "SetDemo{}";
    }*/

    public static void linkedHashSetDemo() {
        Set<String> hashSet = new HashSet<>();
        TreeSet t1 = new TreeSet();

       /* hashSet.add("Raj");
        hashSet.add("Dohn");
        hashSet.add("Anita");*/
        System.out.println("hashSet: " + hashSet);
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Raj");
        linkedHashSet.add("lohn");
        linkedHashSet.add("Anita");
        System.out.println("linkedHashSet: " + linkedHashSet);
    }
    public static void main(String[] args) {
       Set s1 = new HashSet();
        TreeSet t1 = new TreeSet();

        Book b1 =new Book("java","joshe",1997);
        Book b2 =new Book("java","joshe",1997);

        t1.add(b1);
        t1.add(b1);
        /*s1.add(b1);
        s1.add(b2);*/
        System.out.println("args = [" + s1 + "]");

       String java = "java";
        System.out.println(java.hashCode());
        System.out.println("javb".hashCode());
        System.out.println("javc".hashCode());

        System.out.println("args = [" + args + "]"+"vandana".hashCode());
        System.out.println("args = [" + args + "]"+"vandana".hashCode());
        System.out.println("args = [" + args + "]"+"vani".hashCode());
        System.out.println("args = [" + args + "]"+"prasan".hashCode());
        System.out.println("args = [" + args + "]"+"shobhit".hashCode());



    }
}
