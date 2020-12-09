import java.util.Collections;

public class Main {
    public static void main(String [ ] args)
    {
        int[][] N = GenerateInput(95);
        int[][] N2 = GenerateInput(N.length * 2);
        int[][] N4 = GenerateInput(N.length * 4) ;
        int[][] N8 = GenerateInput(N.length * 8) ;

        int x = 4, y = 4, newC = 3;
        long starttime = System.nanoTime();
        FloodFillSequential.floodFill(N, x, y, newC);
        long elapsetime = System.nanoTime();
        System.out.println("Elapse time : " +(elapsetime-starttime));

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
}
