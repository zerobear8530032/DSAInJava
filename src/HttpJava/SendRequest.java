package HttpJava;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SendRequest {
    public static void getResquest(String urlstr){
        try{
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int statscode=conn.getResponseCode();

            System.out.println(statscode);
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer buffer= new StringBuffer();
            String line ="";
            while (line!=null){
                line= bufferedReader.readLine();
                buffer.append(line);
            }
            System.out.println(buffer.toString());
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void postResquest(String urlstr){
        try{
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            writer.append("{\n" +
                    "  \"title\": \"My Post Title\",\n" +
                    "  \"body\": \"This is the content of the post\",\n" +
                    "  \"userId\": 1\n" +
                    "}");

            int statscode=conn.getResponseCode();

            System.out.println(statscode);
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder buffer= new StringBuilder();
            String line ="";
            while (line!=null){
                line= bufferedReader.readLine();
                buffer.append(line);
                buffer.append("\n");
            }
            System.out.println(buffer.toString());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void putResquest(String urlstr){
        try{
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            BufferedWriter writer= new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            writer.append("{\n" +
                    "  \"title\": \"MY post\",\n" +
                    "  \"body\": \"Content \",\n" +
                    "  \"userId\": 1\n" +
                    "}");

            int statscode=conn.getResponseCode();

            System.out.println(statscode);
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder buffer= new StringBuilder();
            String line ="";
            while (line!=null){
                line= bufferedReader.readLine();
                buffer.append(line);
            }
            System.out.println(buffer.toString());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void deleteResquest(String urlstr){
        try{
            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");
//            conn.setDoOutput(true);

            int statscode=conn.getResponseCode();

            System.out.println(statscode);
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder buffer= new StringBuilder();
            String line ="";
            while (line!=null){
                line= bufferedReader.readLine();
                if(line==null){break;}
                buffer.append(line);
            }
            System.out.println(buffer.toString());
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args){
//        getResquest("https://jsonplaceholder.typicode.com/posts");
//        postResquest("https://jsonplaceholder.typicode.com/posts");
//        putResquest("https://jsonplaceholder.typicode.com/posts/1");
        deleteResquest("https://jsonplaceholder.typicode.com/posts/1");
    }
}
