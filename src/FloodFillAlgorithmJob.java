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

        Queue<Point> queue = new LinkedList<Point>();
        if (screen[y][x] != original){
            return;
        }
        queue.add(new Point(x, y));

        while (!queue.isEmpty()){
            Point p = queue.remove();
            if(p.x < 0 || p.x >= screen.length || p.y < 0 || p.y >= screen.length){
                continue;
            }
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
