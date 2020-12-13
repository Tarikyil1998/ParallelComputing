import java.awt.*;
import java.util.Queue;
import java.util.LinkedList;

class FloodFillSequential {
    // A Qeueue function to replace previous color 'prevC' at '(x, y)'
    // and all surrounding pixels of (x, y) with new color 'newC' and
    public static void fillArea (int[][]screen, int x, int y, int original, int fill){
        long starttime = System.nanoTime();
        if (x != 0)
            x--;
        if (y!= 0)
            y--;
        // Make a queue with points. Points have a X and Y value.
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
        //Print out the run time of the algorithm
        long elapsetime = System.nanoTime();
        System.out.println("Elapse time sequential approach : " +(elapsetime-starttime));
        return;
    }
}

