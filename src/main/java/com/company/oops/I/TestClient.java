package com.company.oops.I;

/**
 * Created by ${vani} on 06-Dec-17.
 */

interface A{
    default void go(){
        System.out.println("A: default go method");
    }
        }
interface B{
    default void go(){
        System.out.println("A: default go method");
    }
}
interface C extends A{
    default void go(){
        A.super.go();
        System.out.println("A: default go method");
    }
}

abstract class AbstractClass{

    /*public void go(){
        System.out.println("Abstract class: default go method");
    }*/

}
public class TestClient extends AbstractClass implements A,B,C,Cloneable{
   public void foo(){
        System.out.println("TestClient: foo method");
    }
    @Override
    public C clone() {
        try {
            return (C) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void go(){
        C.super.go();//this is correct
       System.out.println("Abstract class: default go method");
    }
    public static void main(String[] args) {
    TestClient tc = new TestClient();
    //C c = new TestClient();
        tc.go();
       // C.super.go();// as main method is static (so compilation error not an enclosing class)
    }
}
