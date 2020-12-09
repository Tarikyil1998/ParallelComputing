import java.awt.*;
import java.util.Queue;
import java.util.LinkedList;

class FloodFillSequential {
    // A recursive function to replace previous color 'prevC' at '(x, y)'
    // and all surrounding pixels of (x, y) with new color 'newC' and
    static void floodFillUtil(int[][] screen, int x, int y,
                              int prevC, int newC, int M) {
        // Base cases
        if (x < 0 || x >= M || y < 0 || y >= M)
            return;
        if (screen[x][y] != prevC)
            return;

        // Replace the color at (x, y)
        screen[x][y] = newC;

        // Recur for north, east, south and west
        floodFillUtil(screen, x + 1, y, prevC, newC, M);
        floodFillUtil(screen, x - 1, y, prevC, newC, M);
        floodFillUtil(screen, x, y + 1, prevC, newC, M);
        floodFillUtil(screen, x, y - 1, prevC, newC, M);
    }

    // It mainly finds the previous color on (x, y) and
    // calls floodFillUtil()
    static void floodFill(int[][] screen, int x, int y, int newC) {
        int prevC = screen[x][y];
        fillArea(screen,x,y,prevC,newC);
    //floodFillUtil(screen, x, y, prevC, newC, screen.length);
    }


    public static void fillArea (int[][]screen, int x, int y, int original, int fill){
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

