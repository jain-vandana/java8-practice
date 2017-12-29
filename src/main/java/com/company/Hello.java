package com.company;

import com.company.concurrency.advance.ConnectToHttp;
import org.apache.log4j.Logger;

public class Hello {

    private static org.apache.log4j.Logger log = Logger.getLogger(Hello.class);

    public static void main(String[] args) {
        System.out.println("args = [" +   new ConnectToHttp().downLoad("http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html"));
        log.trace("Trace Message!");
        log.debug("Debug Message!");
        log.info("Info Message!");
        log.warn("Warn Message!");
        log.error("Error Message!");
        log.fatal("Fatal Message!");
    }
}
