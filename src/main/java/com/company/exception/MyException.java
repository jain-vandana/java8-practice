package com.company.exception;

public class MyException extends Exception {
    String s;
    MyException(String s){
       super(s);
    }


    /*@Override
    public String toString() {
        return MyException.class.getName()+s;
    }*/
}
