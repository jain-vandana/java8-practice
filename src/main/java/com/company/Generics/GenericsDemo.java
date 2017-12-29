package com.company.Generics;

import java.util.*;

public class GenericsDemo  <T extends List>{
    public static void main(String[] args) {

        Container<String> store = new Store<>();
        store.set("vandana");
        //store.set(1); :- this will give compilation error as generic is for compilation, and it save us from run time error

        Container<Integer> integerStore = new Store<>();
        integerStore.set(1);
        System.out.println(integerStore.get());
        Container<List<Integer>> listStore = new Store<>();
        listStore.set(Arrays.asList(1,2,3));
        System.out.println(listStore.get());


        List<Number> list = new ArrayList<>();
        list.add(new Integer(1));
        list.add(new Double(22.0));
        //list.add(new String("22.0"));
        List[] array = new ArrayList[2];
        array[0] = new ArrayList();
        array[1] = new LinkedList();// we will get Run time error refer one Note file( because refrence is list but Object is ArrayList Type, in that we cant add Linked List
        // so this is the advantage of Generics , It fails at compile time only )
       //GenericsDemo<Collection> listl = new GenericsDemo<Collection>();// Type parameter java.util.Collection is not within its bound; should extends java.util.List



    //go(new ArrayList<Integer>());//This is because of coveriance as In Method signature List<Number> we cann't pass List Integer
  go(new Integer[1]);
}
// Invariance
    static void go(List<Number> list) {}
    // Covariance
    static void go(Number[] list) { list[0] = 24.4;
    }

}

interface Container<T> {
    void set(T a);
    T get();
}

class Store<T> implements Container<T>{
    private T a;

    @Override
    public void set(T a) {
        this.a = a;
    }

    @Override
    public T get() {
        return a;
    }
}
