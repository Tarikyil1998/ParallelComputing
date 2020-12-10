import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FloodFillThreading {

    public int threadCount;
    int[][] screen;

    public int[][] ThreadStart () throws InterruptedException {
        int intervals = screen.length/threadCount;

        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 0; i < threadCount; i++){
            //int[] array = Arrays.copyOfRange(screen[i],intervals*i, intervals*(i+1));

            //FloodFillAlgorithmJob job = new FloodFillAlgorithmJob("Thread " + i, screen, intervals, i);
            es.execute(new FloodFillAlgorithmJob("Thread " + i, screen, intervals, i));
            //job.start();
        }
        es.shutdown();
        es.awaitTermination(1, TimeUnit.MINUTES);

        return screen;
    }




}
