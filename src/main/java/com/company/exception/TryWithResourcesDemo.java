package com.company.exception;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryWithResourcesDemo {
    static String inFileStr = "D:\\learning\\java8-practice\\resources\\com\\company\\exception\\walden.jpg";
    static String outFileStr = "walden-out.jpg";

    public static void fileCopyWithArm() throws IOException {
        System.out.println("\nInside fileCopyWithArm ...");

        try (Test t = new Test(); Test2 t2 = new Test2(); /*String s= new String(); this not autoclosable type*/
             BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFileStr));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFileStr))) {
            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }

            throw new IOException("Important Exception!!");
        }
    }

    public static void fileCopyWithOutArm() throws IOException {
        System.out.println("\nInside fileCopyWithArm ...");
        Test t=null;
        Test2 t2 = null;
        BufferedInputStream in =null;
        BufferedOutputStream out = null;
        try {
            t = new Test();
            t2 = new Test2();
            in = new BufferedInputStream(new FileInputStream(inFileStr));
            out = new BufferedOutputStream(new FileOutputStream(outFileStr));
            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }

            throw new IOException("Important Exception!!");
        }finally {
            if (t2 != null)
                t2.close();
            if (t != null)
                t.close();
            if (in != null)
                in.close();
            if (out != null)
                out .close();
        }
    }

    public static void fileCopyWithOutArm2() throws IOException {
        System.out.println("\nInside fileCopyWithArm ...");
        Test t=null;
        Test2 t2 = null;
        BufferedInputStream in =null;
        BufferedOutputStream out = null;
        IOException ioException = null;
         try {
            t = new Test();
            t2 = new Test2();
            in = new BufferedInputStream(new FileInputStream(inFileStr));
            out = new BufferedOutputStream(new FileOutputStream(outFileStr));
            byte[] byteBuf = new byte[4000];
            int numBytesRead;
            while ((numBytesRead = in.read(byteBuf)) != -1) {
                out.write(byteBuf, 0, numBytesRead);
            }

            throw new IOException("Important Exception!!");
        }catch (IOException e){
            ioException =e;
        }
        finally {
             if(ioException!=null){
                  if (t2 != null) {
                      try {
                          t2.close();
                      }catch (IOException e){
                          ioException.addSuppressed(e);
                      }
                  }
             }else {
                 if (t2 != null) {
                     try {
                         t2.close();
                     } catch (IOException e) {
                         ioException = e;
                     }
                 }
             }
             if(ioException!=null){
                 if (t != null) {
                     try {
                         t.close();
                     }catch (IOException e){
                         ioException.addSuppressed(e);
                     }
                 }
             }else {
                 if (t != null) {
                     try {
                         t.close();
                     } catch (IOException e) {
                         ioException = e;
                     }
                 }

             }
             if(ioException!=null){
                 if (in != null) {
                     try {
                         in.close();
                     }catch (IOException e){
                         ioException.addSuppressed(e);
                     }
                 }
             }else {
                 if (in != null) {
                     try {
                         in.close();
                     } catch (IOException e) {
                         ioException = e;
                     }
                 }

             }
             if(ioException!=null){
                 if (out != null) {
                     try {
                         out.close();
                     }catch (IOException e){
                         ioException.addSuppressed(e);
                     }
                 }
                 throw ioException;
             }else {
                 if (out!= null) {
                       out.close();
                 }

             }
        }
    }

    public static void main(String[] args) {
        try {
            //fileCopyWithArm();
            //fileCopyWithOutArm();
            fileCopyWithOutArm2();
        } catch (IOException e) {
            e.printStackTrace();

			/*
			Throwable[] throwables = e.getSuppressed();
			System.out.println(throwables[0].getMessage());
			System.out.println(throwables[1].getMessage());
			*/
        }

    }
}

class Test implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception");
    }
}

class Test2 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("Trivial Exception 2");
    }

}