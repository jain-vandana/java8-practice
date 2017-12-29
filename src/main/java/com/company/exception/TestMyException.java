package com.company.exception;

public class TestMyException {
    int age;

    void checkException(int age) throws MyException{
        if(age<18){
            throw new MyException("age is below 18");

        }
    }
    public static void main(String[] args) {
        TestMyException t1= new TestMyException();
        try {
            t1.checkException(17);
        }catch (MyException e){
            System.out.println(  "e.toString()"+e.getMessage());
        }



    }
}
