package com.company.concurrency.advance;

import com.company.util.IOUtil;

import java.io.*;
import java.net.*;

public class ConnectToHttp {

    public static void main(String[] args) {
        System.out.println("args = [" + new ConnectToHttp().download1("https://mail.google.com/mail/u/0/#inbox"));
    }
StringBuilder text = new StringBuilder();
    public String download1(String httpUrl){
        URL url = null;
        try {
            url = new URL(
                    httpUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
    public String downLoad(String uri) {
        String htmlpage = null;
        try {
            URL url = new URI(uri).toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream IO = con.getInputStream();
            htmlpage = IOUtil.read(IO);
            System.out.println("html page = [" + htmlpage + "]");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return htmlpage;
}

}
