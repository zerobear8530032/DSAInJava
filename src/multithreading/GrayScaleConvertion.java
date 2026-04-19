//
package multithreading;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

class ConvertToGrayScale implements   Runnable{

    int rowStart ;
    int rowEnd ;
    int colStart;
    int colEnd;
    BufferedImage image;

    public ConvertToGrayScale(int rowStart, int rowEnd, int colStart, int colEnd, BufferedImage image) {
        this.rowStart = rowStart;
        this.rowEnd = rowEnd;
        this.colStart = colStart;
        this.colEnd = colEnd;
        this.image = image;
    }

    @Override
    public String toString() {
        return "ConvertToGrayScale{" +
                "rowStart=" + rowStart +
                ", rowEnd=" + rowEnd +
                ", colStart=" + colStart +
                ", colEnd=" + colEnd +
                ", image=" + image +
                '}';
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName()+"  start");
        convertToGrayScale();
//        System.out.println(Thread.currentThread().getName()+"  end");
    }

    public void convertToGrayScale(){
        for(int i = rowStart; i<Math.min(rowEnd,image.getHeight()); i++){
            for(int j = colStart;j<Math.min(colEnd,image.getWidth());j++){
                int rgb = image.getRGB(j,i);
                int grayPixel = convertToGray(rgb);
                image.setRGB(j,i,grayPixel);
            }
        }
    }

    public static int convertToGray(int pixelData){
        int transprancyBits = (pixelData >> 24) & 255;
        int redBits   = (pixelData >> 16) & 255;
        int greenBits = (pixelData >> 8) & 255;
        int blueBits  = pixelData & 255;
        int gray = (int)((0.299 * redBits) + (0.587 * greenBits) + (0.114 * blueBits));
        int pixel = (transprancyBits << 24) | (gray << 16) | (gray << 8) | gray;
        return pixel;
    }
}

public class GrayScaleConvertion {
    public static void main(String[] args) {
        String inputPath="C:/Users/Admin/Pictures/Screenshots/image.jpg";
        String outputPath="C:/Users/Admin/Pictures/Screenshots/outputsync-image.jpg";

        long startTime = System.currentTimeMillis();
        convertImageToGrayScaleSync(inputPath,outputPath);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+" Sync Time");

        outputPath="C:/Users/Admin/Pictures/Screenshots/outputasync-image.jpg";
        startTime = System.currentTimeMillis();
        convertImageToGrayScaleAsync(inputPath,outputPath);
        endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+" Async Time");

        outputPath="C:/Users/Admin/Pictures/Screenshots/outputExecutorAsync-image.jpg";
        startTime = System.currentTimeMillis();
        convertImageToGrayScaleAsyncExecutors(inputPath,outputPath);
        endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+" Executor Time");
    }


//    Async :
    public static void convertImageToGrayScaleAsyncExecutors(String inputPath, String outputPath){
        try {
            File file = new File(inputPath);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            List<Future<?>> futures= new ArrayList<>();
            int rowStart=0;
            int colStart=0;
            int stepSize=1000;
            int rowEnd= rowStart+stepSize;
            int colEnd= colStart+stepSize;
            int thcount =Runtime.getRuntime().availableProcessors();
//            System.out.println(thcount);
            ExecutorService executor = Executors.newFixedThreadPool(thcount);
            while (rowStart<height){
                colStart=0;
                colEnd=colStart+stepSize;

                while (colStart<width){

                    Future<?> future=executor.submit(new ConvertToGrayScale(rowStart,rowEnd,colStart,colEnd,image));
                    futures.add(future);
                    colStart=colEnd;
                    colEnd+=stepSize;
                }
                rowStart=rowEnd;
                rowEnd+=stepSize;
            }

            for(Future<?> th:futures){

                    th.get();

            }
            executor.shutdown();

            ImageIO.write(image,"jpg",new File(outputPath));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//    Async :
    public static void convertImageToGrayScaleAsync(String inputPath, String outputPath){
        try {
            File file = new File(inputPath);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            List<Thread> threads= new ArrayList<>();
            int rowStart=0;
            int colStart=0;
            int stepSize=1000;
            int rowEnd= rowStart+stepSize;
            int colEnd= colStart+stepSize;
            while (rowStart<height){
                colStart=0;
                colEnd=colStart+stepSize;
                while (colStart<width){
//                    System.out.println(rowStart+" "+rowEnd+" "+colStart+" "+colEnd);
                    Thread th= new Thread(new ConvertToGrayScale(rowStart,rowEnd,colStart,colEnd,image));
                    th.start();
                    threads.add(th);
                    colStart=colEnd;
                    colEnd+=stepSize;
                }
                rowStart=rowEnd;
                rowEnd+=stepSize;
            }

            for(Thread th:threads){
                th.join();
            }

            ImageIO.write(image,"jpg",new File(outputPath));

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

//    Sync :
    public static void convertImageToGrayScaleSync(String inputPath, String outputPath){
        try {
            File file = new File(inputPath);
            BufferedImage image = ImageIO.read(file);
            int width = image.getWidth();
            int height = image.getHeight();
            for(int i =0;i<height;i++){
                for(int j =0;j<width;j++){
                    int rgb = image.getRGB(j,i);
                    int grayPixel = convertToGray(rgb);
                    image.setRGB(j,i,grayPixel);
                }
            }
            ImageIO.write(image, "jpg", new File(outputPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static int convertToGray(int pixelData){
        int transprancyBits = (pixelData >> 24) & 255;
        int redBits   = (pixelData >> 16) & 255;
        int greenBits = (pixelData >> 8) & 255;
        int blueBits  = pixelData & 255;
        int gray = (int)((0.299 * redBits) + (0.587 * greenBits) + (0.114 * blueBits));
        int pixel = (transprancyBits << 24) | (gray << 16) | (gray << 8) | gray;
        return pixel;
    }

}

