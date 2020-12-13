import java.awt.*;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithmJob  implements Runnable{
    private Thread thread;
    private String threadName;
    private int[][] screen;
    private int intervalSize;
    private int startPosition;

    //Implementing Flood Fill Job. Which the threads will use.
    FloodFillAlgorithmJob(String name, int[][] input, int intervalSize, int startPosition){
        threadName = name;

        this.intervalSize = intervalSize;
        this.startPosition = startPosition;
        screen = input;
    }

    @Override
    public void run() {
        fillArea(screen, intervalSize * startPosition, intervalSize * startPosition, 0, 3, startPosition);
    }

    public void fillArea (int[][]screen, int x, int y, int original, int fill, int startPosition){
        if (x != 0)
            x--;
        if (y!= 0)
            y--;
        //Make a queue with points. Points have a X and Y value.
        Queue<Point> queue = new LinkedList<Point>();

        if (screen[y][x] != original){
            return;
        }
        queue.add(new Point(x, y));
        // Loop till queue is empty
        while (!queue.isEmpty()){
            Point p = queue.remove();
            // Make sure points does not exceed max input size.
            if(p.x < 0 || p.x >= screen.length || p.y < 0 || p.y >= screen.length){
                continue;
            }
            // if the value of the point is 0 change that to 3 to fill the area
                if (screen[p.y][p.x] == original){
                screen[p.y][p.x] = fill;
                queue.add(new Point(p.x-1, p.y));
                queue.add(new Point(p.x+1, p.y));
                queue.add(new Point(p.x, p.y-1));
                queue.add(new Point(p.x, p.y+1));
            }

        }

        return;
    }
}
