import java.io.FileNotFoundException;
import java.util.Collections;

public class Main {
    public static void main(String [ ] args) throws FileNotFoundException {
        Controller controller = new Controller();
    }

    private static int[][] GenerateInput(int size) {

        //using a single size int to make sure we always get a square input
        int[][] inputValue = new int[size][size];

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                inputValue[x][y] = 0;
            }
        }

        //Validate to make sure the input is a square
        boolean isSquare = true;
        for (int[] ints : inputValue) {
            for (int col = 0; col < ints.length; col++)
                if (inputValue.length != ints.length) {
                    isSquare = false;
                    break;
                }
        }

        if(isSquare) {
            return inputValue;
        }
        else return null;
    }

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    private static void printArray(int[][] input){
        for(int[] row : input) {
            printRow(row);
        }
    }

    private static void floodfill()  throws InterruptedException {
//        int[][] N = GenerateInput(4000);
        int[][] N = GenerateInput(8000);
//        int[][] N = GenerateInput(16000) ;
//        int[][] N = GenerateInput(32000) ;

        int[][] NSecond = GenerateInput(N.length);

        int x = 4, y = 4, newC = 3;
        long starttime = System.nanoTime();
        FloodFillSequential.fillArea(N, x, y,0, newC);
        long elapsetime = System.nanoTime();
        System.out.println("Elapse time : " +(elapsetime-starttime));
        //printArray(N);

        long starttime2 = System.nanoTime();
        FloodFillThreading floodFillThreading = new FloodFillThreading();
        floodFillThreading.screen = NSecond;
        floodFillThreading.threadCount = 5;
        printArray(floodFillThreading.ThreadStart());
        long elapsetime2 = System.nanoTime();

        System.out.println("Elapse time : " +(elapsetime2-starttime2));
        //printArray(floodFillThreading.ThreadStart());
    }
}
