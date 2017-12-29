package com.company.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo {
    static String inFileStr = "D:\\learning\\java8-practice\\resources\\walden.jpg";
    static String outFileStr = "D:\\learning\\java8-practice\\resources\\walden-out.jpg";
    static void fileCopyNoBuffer(){
        long stratTime , elapsetime;
        System.out.println("");
       try (FileInputStream io = new FileInputStream(inFileStr);
               FileOutputStream out = new FileOutputStream(outFileStr)) {
           byte[] bytes = new byte[4000];
           stratTime = System.currentTimeMillis();
           while ( io.read(bytes)!=-1){
                      out.write(bytes);
                  }
                   elapsetime = System.currentTimeMillis() - stratTime;
           System.out.println("elapse time"+elapsetime);
       } catch (FileNotFoundException ex) {
           ex.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println();
        fileCopyNoBuffer();
    }
}