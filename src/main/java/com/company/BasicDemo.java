package com.company;


import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Objects;

interface I{

        }

class A{
    static void overload(){
        System.out.println("inside A");
    }
    void postAReview() {
        System.out.println("inside A!!!!!!!!!!!!!!!!!");
    }

   public void instanceMethod(double d){
        System.out.println("A!!!!!");
    }

    void instanceMethod(A d){
        System.out.println("A class!!!!!");
    }
}

class B extends A implements I,Cloneable{
   static void overload(){
        System.out.println("inside A");
    }
    final public void instanceMethod(double d){
        System.out.println("A!!!!!");
    }
    void postAReview() {
        System.out.println("inside B");
    }

    void instanceMethod(int d){
        System.out.println("B#####");
    }

    void instanceMethod(B b){
        System.out.println("B class!!!!!");
    }

    public C clone(){
        try{
          return (C) super.clone();
        }catch (Exception e){
          e.printStackTrace();
        }
        return null;
    }
}

class D extends  B{

}

class C extends B{

    public static void main(String[] args) {

        B b = new C();
        D d= (D)b;
        System.out.println("args c class run= [" + args + "]");
    }
}
public class BasicDemo {

    Object ob= new C();

   /* char[] data = new char[6];
    char cc = data[7];
    //int i= 233.3;
   static Object ob= new A();
    A a = new Object();*/


    public static void main(String[] args) {

        C c= new C();
        C c1 = c.clone();

        I i=new B();
        //I i1 = ((B)i).clone();
        if(c==c1){
            System.out.println("clone and interface objet are same");
        }else{
            System.out.println("object are diffrent");
        }

     A aholdB= new B();
     B bobj= new B();
     //aholdB.overload();
     //aholdB.postAReview();
       /* aholdB.instanceMethod(new B());
        System.out.println("args = [" + aholdB.getClass() + "]");
        System.out.println("args = [" + bobj.+ "]");
       BasicDemo basicDemo = new BasicDemo();*/

       /*if(ob instanceof Objects){
           System.out.println("args = object");
       }
        if(ob instanceof A){
            System.out.println("args = A");
        }

        if(ob instanceof B){
            System.out.println("args = B");
        }*/



    }
    /*static void veryExpensive()	{
        System.out.println("\n lnside veryExpensive ...");
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++)	{
            sum = sum + i;
        }
    }*/

    /*static void stringExamples() {
        Integer i= 100;
        System.out.println("\nlnside stringExamples ...");
        String s = "hello world I";
        System.out.println("s: " + s);
        System.out.println("\ns.length(): " + s.length());
        System.out.println("s.isEmpty(): " + s.isEmpty());
        System.out.println("\ns.equals(\"HELLO WORLD!\"):" + s.compareTo("HELLO WORLD!"));

        stringPool();
    }*/

    /*static void stringPool() {
        System.out.println("\nlnside stringPool ...");
        String s1 = "hello!";
        String s2 = "hello!";
        String s3 = "hello!".intern();
        String s4 = new String("hello!");
        String s5 = "lo!";
        System.out.println("s1 ==	s2:	" + (s1 == s2));
        System.out.println(" s1 ==	s3:	" + (s1 == s3));
        System.out.println("s1 ==	s4:	" + (s1 = s4));
        System.out.println("s1 ==	s4.intern(): " + (s1 == s4.intern()));
        System.out.println("s1 == \"hel\" + \"lo!\":	" + (s1 = "hel" + "lo!"));
        System.out.println("si = \"hel\" + s5: " + (s1 = "hel" + s5));

    }*/
}