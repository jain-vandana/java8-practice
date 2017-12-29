package com.company.concurrency.advance;

import java.util.ArrayDeque;

public class NavieIndexerWaitNotify {

    ArrayDeque<NavieIndexerWaitNotify.Weblink> arrayDeque = new ArrayDeque<>();
    public static class Weblink{
        private long id;
        private String title;
        private String url;
        private String host;

        private String htmlPage;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getHtmlPage() {
            return htmlPage;
        }

        public void setHtmlPage(String htmlPage) {
            this.htmlPage = htmlPage;
        }
    }

    class Downloader implements Runnable{
        NavieIndexerWaitNotify.Weblink weblink;
        Downloader(NavieIndexerWaitNotify.Weblink weblink){
            this.weblink = weblink;
        }
        @Override
        public void run() {
            synchronized (weblink) {
                weblink.htmlPage = new ConnectToHttp().download1(weblink.getUrl());
                System.out.println(":::::::::::::::::::::::::;" + weblink.htmlPage);
               weblink.notify();
            }
        }
    }

    class Indexer implements Runnable{
        NavieIndexerWaitNotify.Weblink weblink;
        Indexer(NavieIndexerWaitNotify.Weblink weblink){
            this.weblink = weblink;
        }
        @Override
        public void run() {
            synchronized (weblink) {
                while (weblink.htmlPage == null) {
                    System.out.println("waiting for downloading");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            indexing();
        }

        void indexing(){
            System.out.println("weblink indexing done");
        }

    }



    public NavieIndexerWaitNotify.Weblink createWeblink(long id, String title, String url, String host) {
        NavieIndexerWaitNotify.Weblink weblink = new NavieIndexerWaitNotify.Weblink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }

    void go(ArrayDeque arrayDeque){
        NavieIndexerWaitNotify.Weblink weblink=null;
        while (arrayDeque.size()>0){
            weblink = (NavieIndexerWaitNotify.Weblink)arrayDeque.remove();
            Thread downloader = new Thread(new Downloader(weblink));
            Thread Indexer = new Thread(new Indexer(weblink));
            downloader.start();
            Indexer.start();
        }
    }

    void add(NavieIndexerWaitNotify.Weblink weblink){
        arrayDeque.add(weblink);
    }
    public static void main(String[] args) {
        NavieIndexerWaitNotify navieIndexerWaitNotify = new NavieIndexerWaitNotify();
        navieIndexerWaitNotify.add(navieIndexerWaitNotify.createWeblink(2000, "Taming Tiger, Part 2", "https://www.facebook.com/", "http://www.javaworld.com"));
        navieIndexerWaitNotify.add(navieIndexerWaitNotify.createWeblink(2001, "How do  project into Eclipse and get up and running?", "https://mail.google.com/mail/u/0/#inbox", "http://www.stackoverflow.com"));
        navieIndexerWaitNotify.go(navieIndexerWaitNotify.arrayDeque);
    }
}
