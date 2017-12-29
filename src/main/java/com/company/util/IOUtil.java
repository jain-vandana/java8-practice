package com.company.util;
import java.io.*;

public class IOUtil {


    public static String read(InputStream in) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return text.toString();
    }

    public static void write(String webpage, long id) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("pages/" + String.valueOf(id) + ".html"), "UTF-8"))) {
            writer.write(webpage);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void readFromStandardlnput() {
        System.out.println("\nlnside readFromStandardlnput ...");
        String data;
        System.out.print("Enter	to continue (Using BufferedReader): ");
        try (BufferedReader in = new BufferedReader( new InputStreamReader(System.in,"UTF-16"))){
           while (((data = in.readLine()) != null && !data.equals ("start"))) {
            System.out.print("\nDid not enter V'startV. Try again: ");
        }
    } catch (IOException e) { e.printStackTrace();
    }
}
}
