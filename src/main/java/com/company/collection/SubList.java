package com.company.collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SubList implements Iterable<String>{
    public static void main(String[] args) {
        HashSet set = new HashSet();
        List<String> l1 = new ArrayList<String>();
        l1.add("van");
        l1.add("jain");
        l1.add("vani");
        l1.add("prasann");
        l1.add("shobhit");
        List subList = l1.subList(1, 3);
        System.out.println("l1 = [" + args + "]" + l1);
        System.out.println("sublist = [" + args + "]" + subList);
        subList.add("Angel");
        System.out.println("l1 = [" + args + "]" + l1);
        System.out.println("sublist = [" + args + "]" + subList);
        l1.set(0, "vandana");
        System.out.println("sublist = [" + args + "]" + subList);
       /* l1.add(0, "vandanajain");
        System.out.println("sublist = [" + args + "]" + subList);*/

        //System.out.println("list3: " + list3);
        System.out.println("listl: " + l1);
        /*for (String element :new SubList()) {
            System.out.println("element: " + element);
// Generates ConcurrentModificationException
            if (element.equals("vani")) {
                l1.remove("vani"); //
            }
        }*/

        Iterator<String> ite = l1.iterator();
        while (ite.hasNext()){
            String element = ite.next();
            System.out.println("element is::" + ite.next() + "]");
            if( element!= null && element.equals("vani")){
                ite.remove();
                ite.forEachRemaining(Filter::add);
            }
        }

        //l1.forEach(System.out ::println);
        //l1.forEach(Filter ::filter);// here in filter class we have not implemented consumer Interface still by magic may be through some dynamic proxy it may pass
       // subList.forEach(new Filter());//here we have implemented the consumer interface

    }

    @Override
    public Iterator<String> iterator() {
        return new ArrayList<String>().iterator();
    }
}


class Filter implements Consumer<String>{
 static void filter(String name) {
        if(!name.equals("vani")){
            System.out.println("name = [" + name + "]");
        }
        }

    @Override
    public void accept(String name) {
        if(!name.equals("vani")){
            System.out.println("name = [" + name + "]");
        }
    }

    static void add(String name) {
        {
            System.out.println("name = [" + name +"jain");
        }
    }
}