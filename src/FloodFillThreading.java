import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FloodFillThreading {

    public int threadCount;
    int[][] screen;

    public int[][] ThreadStart () throws InterruptedException {
        long starttime2 = System.nanoTime();
        int intervals = screen.length/threadCount;

        ExecutorService es = Executors.newCachedThreadPool();
        // For every threadcount start a Job
        for(int i = 0; i < threadCount; i++){
            es.execute(new FloodFillAlgorithmJob("Thread " + i, screen, intervals, i));
        }
        es.shutdown();
        //Wait for all the jobs to finish
        es.awaitTermination(1, TimeUnit.MINUTES);
        long elapsetime2 = System.nanoTime();
        //Print out the run time
        System.out.println("Elapse time threading approach : " +(elapsetime2-starttime2));
        return screen;
    }




}
