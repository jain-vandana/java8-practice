package com.company.oops.inheritance;

/**
 * Created by ${vani} on 06-Dec-17.
 */

interface I1{

    default void instanceMethod(){
        staticMethod();
    }
    static void staticMethod(){
        System.out.println("Inside I1");
    }
}

interface I2 extends  I1{
    static void staticMethod(){
        System.out.println("inside I2");
    }

}
interface ILambda{
    void test();
    default void test1(){}
}

public class TestX /*implements I1,I2*/{

    public static void main(String[] args) {

        TestX x = new TestX();
        System.out.println("args = "+int.class);
        System.out.println("args = "+Integer.class);
        System.out.println("args = "+TestX.class);
        System.out.println("args = "+void.class);
        System.out.println("args = "+int[].class);
        Class clazz = TestX.class;
        clazz.getMethods();

        /*I1.staticMethod();
        I2.staticMethod();
        TestX x;
        x = new TestX();

        I1 i1 = new TestX();
        x.lambdaMethod(()-> System.out.println(" this lambda call"));
        I1.staticMethod();

        TestX x1 =new TestX();
        System.out.println(x.getClass().getClassLoader());
        System.out.println(x.getClass().getSuperclass());
        System.out.println(x.getClass().getName());
        System.out.println(x.getClass().hashCode());
        System.out.println(x1.getClass().getClassLoader());
        System.out.println(x1.getClass().getSuperclass());
        System.out.println(x1.getClass().getName());
        System.out.println(x1.getClass().hashCode());*/

    }

   /* void lambdaMethod(ILambda il){
        il.test();
    }*/
}


