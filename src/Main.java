import java.io.FileNotFoundException;
import java.util.Collections;

public class Main {
    public static void main(String [ ] args) throws InterruptedException {
       int[] amountOfThreads = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256,512};
       int[] inputArray = new int[]{1000,2000,3000,4000,5000,6000,7000,8000,9000,10000};
        for(int j = 0;j < amountOfThreads.length; j++) {
            for (int i = 0; i < amountOfThreads.length; i++) {
                floodfill((inputArray[i]), (amountOfThreads[j]));
            }
        }
    }


    // Return false if the array contains a 0 because this means the flood fill has not worked correct.
    private boolean validateOutput(int[][] arr){
        for(int x = 0; x < arr.length; x++) {
            for(int y = 0; y < arr.length; y++) {
                if(arr[x][y] == 0){
                    return false;
                }
            }
        }
        return true;

    }
    //GenerateInput to have a consistent square input to achieve the N^2 complexity
    public static int[][] GenerateInput(int size) {

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
    //Function to print the rows of a int array
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    //Function to print the input of a 2d int array
    public static void printArray(int[][] input){
        for(int[] row : input) {
            printRow(row);
        }
    }

    private static void floodfill(int size, int threadcount)  throws InterruptedException {
        int[][] N = GenerateInput(size);
        int[][] NSecond = GenerateInput(size);
        System.out.println("N = "+size + " - " + "Thread = " + threadcount);
        int x = 4, y = 4, newC = 3;
        FloodFillSequential.fillArea(N, x, y,0, newC);
        FloodFillThreading floodFillThreading = new FloodFillThreading();
        floodFillThreading.screen = NSecond;
        floodFillThreading.threadCount = threadcount;
        floodFillThreading.ThreadStart();

    }
}
