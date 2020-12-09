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
        floodFillUtil(screen, x, y, prevC, newC, screen.length);
    }
}

