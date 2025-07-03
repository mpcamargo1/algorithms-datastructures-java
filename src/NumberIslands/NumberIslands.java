package NumberIslands;

public class NumberIslands {

    public int getNumberOfIslands(char[][] grid) {
        int numberIslands = 0;

        if (grid == null) {
            return numberIslands;
        }

        int height = grid.length;
        int width = grid[0].length;

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                if (grid[y][x] != '1') {
                    continue;
                }

                numberIslands++;
                exploreIsland(grid, x, y);

            }
        }

        return numberIslands;
    }

    private void exploreIsland(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;

        grid[y][x] = '0';

        // UP
        if (y - 1 >= 0 && grid[y - 1][x] == '1') {
            exploreIsland(grid, x, y - 1);
        }

        // DOWN
        if (y + 1 < m && grid[y + 1][x] == '1') {
            exploreIsland(grid, x, y + 1);
        }

        // LEFT
        if (x - 1 >= 0 && grid[y][x - 1] == '1') {
            exploreIsland(grid, x - 1, y);
        }

        // RIGHT
        if (x + 1 < n && grid[y][x + 1] == '1') {
            exploreIsland(grid, x + 1, y);
        }

    }

    public static void main(String[] args) {
        NumberIslands numberIslands = new NumberIslands();

        char[][] grid = new char[][] {
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int islandsFound = numberIslands.getNumberOfIslands(grid);

        System.out.println(islandsFound);
    }
}
