import java.util.Arrays;

public class FloodFillThreading {

    public int threadCount;
    int[][] screen;


    private int[][] ThreadStart (){
        int intervals = screen.length/threadCount;
        for(int i = 0; i < threadCount; i++){
            int[] array = Arrays.copyOfRange(screen[i],intervals*i, intervals*(i+1));
        }
    }


}
