package multithreading;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Stream;

class WebDownloadWebPage implements Runnable {

    String url;
    int index;
    String  outputPath;

    public WebDownloadWebPage(String url, int index,String o) {
        this.url = url;
        this.index = index;
        this.outputPath=o;
    }

    public static   String sendRequest(String url){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0")
                    .GET()
                    .build();

            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException e) {
            System.out.println(e+" "+url);
        } catch (InterruptedException e) {
            System.out.println(e+" "+url);
        }
        return null;
    }

    public static boolean saveFile(String data,String path){
        if(data==null){return false;}
        try {
            File file = new File(path);
            BufferedReader reader= new BufferedReader(new StringReader(data));
            if(file.createNewFile()){
//                System.out.println("File created");
            }else{
//                System.out.println("File already exists");
            }
            FileWriter writer= new FileWriter(file);
            String line ="";
            while (line!=null){
                line= reader.readLine();
                if(line==null){break;}
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    @Override
    public void run() {
//        System.out.println("Processing : "+index+" "+url);
        String body = sendRequest(url);
        if(body==null){
//            System.out.println("Some thing happened "+index+" "+url);
        }else{
            saveFile(body,outputPath);
//            System.out.println("Processing done : "+index+" "+url);
        }
    }
}
public class DownlodWebPage {


//  Executor :
    public static void downloadWebPagesExecutor(List<String> urls){
        try {
            List<Future<?>> futures= new ArrayList<>();
            int stepSize=10;
            int start=0;
            int end = start+stepSize;
            int core = Runtime.getRuntime().availableProcessors();
            ExecutorService executor= Executors.newFixedThreadPool(core);
            for(int i =0;i<urls.size();i++) {
                String url = urls.get(i);
                String outPath ="C:/Users/Admin/Downloads/webpageExecutor/file"+i+".html";
               Future<?> future= executor.submit(new WebDownloadWebPage(url,i,outPath));
               futures.add(future);
            }
            for(Future<?> future:futures){
                future.get();
            }
            executor.shutdown();
        } catch ( ExecutionException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
//  Async:
    public static void downloadWebPagesAsync(List<String> urls){
        try {
            List<Thread> threads= new ArrayList<>();
            int stepSize=8;
            int start=0;
            int end = start+stepSize;
            while(start<urls.size()){
                for(int i =start;i<Math.min(end,urls.size());i++) {
                    String url = urls.get(i);
                    String outPath="C:/Users/Admin/Downloads/webpagesAsync/file"+i+".html";
                    Thread thread = new Thread(new WebDownloadWebPage(url, i,outPath));
                    thread.start();
                    threads.add(thread);
                }
                for (int i = 0; i < threads.size(); i++) {
                        threads.get(i).join();
                }
                start=end;
                end=start+stepSize;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }

//  Sync:

    public static void downloadWebPagesSync(List<String> urls){
        for(int i =0;i<urls.size();i++){
            String url = urls.get(i);
            System.out.println("Processing : "+i+" "+url);
            String body = sendRequest(url);
            if(body==null){
                System.out.println("Some thing happened "+url);
                continue;
            }else{
                saveFile(body,"C:/Users/Admin/Downloads/webpagesSync/file"+i+".html");
            }
            System.out.println("Processing done : "+i+" "+url);
        }
    }

    public static   String sendRequest(String url){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Accept", "text/html,application/xhtml+xml")
                    .header("Connection", "keep-alive")
                    .GET()
                    .build();

            HttpResponse<String> response = null;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return null;
    }

    public static boolean saveFile(String data,String path){
        if(data==null){return false;}
        try {
            File file = new File(path);
            BufferedReader reader= new BufferedReader(new StringReader(data));
            if(file.createNewFile()){
                System.out.println("File created");
            }else{
                System.out.println("File already exists");
            }
            FileWriter writer= new FileWriter(file);
            String line ="";
            while (line!=null){
               line= reader.readLine();
               if(line==null){break;}
               writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://rgipt.ac.in",
                "http://www.iracing.com/tracks/gateway-motorsports-park/",
                "http://www.mutuo.it",
                "http://vamoaestudiarmedicina.blogspot.com/",
                "https://parade.com/425836/joshwigler/the-amazing-race-host-phil-keoghan-previews-the-season-27-premiere/",
                "https://www.astrologyonline.eu/Astro_MemoNew/Profilo.asp",
                "https://www.lifewire.com/tcp-port-21-818146",
                "https://technofizi.net/top-best-mp3-downloader-app-for-android-free-music-download/",
                "https://www.missfiga.com/",
                "https://www.chiefarchitect.com/",
                "http://www.2345daohang.com/",
                "https://www.game.co.uk/games",
                "https://blog.hubspot.com/marketing/email-open-click-rate-benchmark",
                "http://sophie-world.com/games/port-and-starboard",
                "https://www.provenancevineyards.com/",
                "http://www.online-tech-tips.com/computer-tips/how-to-change-mac-address/",
                "http://www.enkiquotes.com/",
                "https://answers.yahoo.com/question/index?qid=20060914152716AAZTOSo",
                "https://www.chiostrodelbramante.it/",
                "http://yummy-cummy-in-my-tummy.tumblr.com",
                "http://www.j-net.cn/cms",
                "http://press-preview.weebly.com",
                "http://taccs.hu",
                "http://wiki.openstreetmap.org/wiki/Databases_and_data_access_APIs",
                "https://www.merriam-webster.com/dictionary/tabloid",
                "https://www.bls.gov/oes/current/oes292035.htm",
                "https://ru.wikipedia.org/wiki/MultiMedia_Card",
                "http://searchnetworking.techtarget.com/tip/Comparisons-of-coaxial-cable-fiber-optic-cable-and-twisted-pair-cable",
                "https://www.provenancevineyards.com/our-wines",
                "http://support.brother.com/g/s/id/pdf_pub/faq/faq002478/en/Scan_To_FTP.pdf",
                "http://www.excel-easy.com/examples/shortest-path-problem.html",
                "http://stattrek.com/statistics/dictionary.aspx?definition=standard%20error",
                "http://www.flaticon.com/free-icons/parking_403",
                "http://www.bobsplans.com/FreeDownloads/RouterTable.pdf",
                "https://en.wikipedia.org/wiki/NIC_Bank",
                "http://www.history.com/topics/american-civil-war/gettysburg-address",
                "http://remontka.pro/mac-address/",
                "https://en.wikipedia.org/wiki/Gateway",
                "https://twitter.com/mimosagrillclt",
                "http://www.calculate.co.il/",
                "http://www.whio.com/news/local/thief-breaks-into-save-lot-steals-steaks-dayton/dX1YgaOZ7zmj18bPd4tU6L/",
                "https://www.markspcsolution.com/",
                "https://www.mummyandmini.com/",
                "https://www.showplaceicon.com/Browsing/Cinemas/Details/8863",
                "http://securityxploded.com/router-password-kracker.php",
                "http://www.ilovefreesoftware.com/16/featured/5-best-free-network-packet-sniffer.html",
                "https://apshop.vn/",
                "https://www.facebook.com/thekeyboardcat",
                "https://www.soul-flower.com/",
                "http://www.tech-faq.com/mms.html",
                "http://sniz.porn",
                "http://www.inquirelive.co.uk/",
                "https://www.wordnik.com/words/blackletter",
                "https://www.gadgetzone.com.my/",
                "http://ru.dictionarist.com/iconoclast",
                "http://smallbusiness.chron.com/enabling-google-chrome-menu-bar-78783.html",
                "https://coderwall.com/p/kvzbpa/don-t-use-array-foreach-use-for-instead",
                "http://www.wealthdaily.com/articles/nokia-stock/2147",
                "https://www.emploi-petrole.com/",
                "http://dic.academic.ru/dic.nsf/ruwiki/1425594",
                "http://www.biology4kids.com/files/cell2_activetran.html",
                "https://www.namecheap.com/domains/registration.aspx",
                "https://www.zeitschriften-abo.de/DE/NVG/",
                "https://security.radware.com/ddos-knowledge-center/DDoSPedia/command-and-control-server/",
                "https://www.iconfinder.com/icons/858729/computer_mouse_icon_computer_mouse_line_icon_mouse_mouse_icon_mouse_line_icon_icon",
                "http://www.audioenglish.org/dictionary/resolution.htm",
                "http://www.speedcamupdates.com/",
                "https://www.parkwhiz.com/p/new-york-parking/map/",
                "http://www.routeralley.com/guides/nat.pdf",
                "http://barbo.sk",
                "http://www.vpi.us/cat5-5e-6-standards.html",
                "http://fitnessista.com/the-perfect-protein-pancake/",
                "http://animaldiversity.org/accounts/Mus_musculus/",
                "https://www.walmart.com/c/ep/cat6-ethernet-cables",
                "http://science.howstuffworks.com/warp-speed2.htm",
                "http://www.sportshub.com.sg/Directions/Documents/Sports-Hub-Traffic-Brochure.pdf",
                "http://www.srnonline.com/show-clocks",
                "https://www.metal-supply.dk/",
                "https://www.net.com.br/",
                "https://www.slideshare.net/ashamsvk/project-report-on-digital-media-marketing",
                "http://www.metalinjection.net/reviews/album-review-lord-mantis-death-mask",
                "https://www.youtube.com/user/PING",
                "https://learn.sparkfun.com/tutorials/16",
                "https://www.workiva.com/",
                "https://www.jobchannel.ch/",
                "https://fas.org/sgp/crs/misc/R42078.pdf",
                "http://www.matrixlab-examples.com/line-segment.html",
                "https://www.slant.co/topics/2404/~file-managers-for-windows",
                "https://www.computerhope.com/jargon/p/paraport.htm",
                "http://www.apkhere.com/app/com.smartprojects.ramoptimization",
                "http://bangla.plus",
                "https://norecipes.com/japanese-curry-scratch",
                "https://en.wikipedia.org/wiki/Incorporation_of_the_Bill_of_Rights",
                "http://www.abbreviations.com/term/16642",
                "http://www.cnc-club.ru/forum/index.php",
                "https://www.colgate.com/en-us/products/enamel-health",
                "https://estacaoxxx.wordpress.com/",
                "http://careers.stateuniversity.com/pages/100000947/Search-Engines-Future-User-Preferences-Artificial-Intelligence.html",
                "http://energo-investment.hu");


//        long startTime =System.currentTimeMillis();
//        downloadWebPagesSync(urls);
//        long endTime =System.currentTimeMillis();
//        System.out.println((endTime-startTime)+" Sync Timing");
//
//        long asyncStartTime =System.currentTimeMillis();
//        downloadWebPagesAsync(urls);
//        long asyncEndTime =System.currentTimeMillis();
//        System.out.println((asyncEndTime-asyncStartTime)+" Async Timing");
////
//        long executorStartTime =System.currentTimeMillis();
//        downloadWebPagesExecutor(urls);
//        long executorEndTime =System.currentTimeMillis();
//        System.out.println((executorEndTime-executorStartTime)+" Executor Timing");
    }
}
