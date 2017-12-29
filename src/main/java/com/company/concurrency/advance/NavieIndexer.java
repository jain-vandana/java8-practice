package com.company.concurrency.advance;

import com.company.exception.HttpConnect;

import java.util.ArrayDeque;

public class NavieIndexer {
    ArrayDeque<Weblink> arrayDeque = new ArrayDeque<>();
    public static class Weblink{
        private long id;
        private String title;
        private String url;
        private String host;

        private volatile String htmlPage;

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
        Weblink weblink;
        Downloader(Weblink weblink){
            this.weblink = weblink;
        }
        @Override
        public void run() {
                weblink.htmlPage = new ConnectToHttp().download1(weblink.getUrl());
                System.out.println(":::::::::::::::::::::::::;"+weblink.htmlPage);
        }
    }

    class Indexer implements Runnable{
        Weblink weblink;
        Indexer(Weblink weblink){
            this.weblink = weblink;
        }
        @Override
        public void run() {
                while (weblink.htmlPage == null){
                    System.out.println("waiting for downloading");
                }
                indexing();
            }

        void indexing(){
            System.out.println("weblink indexing done");
        }

    }



    public Weblink createWeblink(long id, String title, String url, String host) {
        Weblink weblink = new Weblink();
        weblink.setId(id);
        weblink.setTitle(title);
        weblink.setUrl(url);
        weblink.setHost(host);
        return weblink;
    }

    void go(ArrayDeque arrayDeque){
        Weblink weblink=null;
        while (( weblink = (Weblink)arrayDeque.remove())!= null){
            Thread downloader = new Thread(new Downloader(weblink));
            Thread Indexer = new Thread(new Indexer(weblink));
            downloader.start();
            Indexer.start();
        }
    }

    void add(Weblink weblink){
       arrayDeque.add(weblink);
    }
    public static void main(String[] args) {
        NavieIndexer navieIndexer = new NavieIndexer();
        navieIndexer.add(navieIndexer.createWeblink(2000, "Taming Tiger, Part 2", "https://www.facebook.com/", "http://www.javaworld.com"));
        navieIndexer.add(navieIndexer.createWeblink(2001, "How do  project into Eclipse and get up and running?", "https://mail.google.com/mail/u/0/#inbox", "http://www.stackoverflow.com"));
        navieIndexer.go(navieIndexer.arrayDeque);
    }
}
