package com.ovishnu.algos.leet;

public class Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfRows = grid.length;
        int numberOfCols = grid[0].length;

        int counter = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                if (isIsland(grid, row, col, numberOfRows, numberOfCols)) {
                    counter++;
                }
            }
        }

        return counter;
    }

    private boolean isIsland(final char[][] grid, final int row, final int col, final int numberOfRows,
            final int numberOfCols) {
        if (grid[row][col] == '1') {
            if (isWater(grid, row - 1, col, numberOfRows, numberOfCols)
                    && isWater(grid, row + 1, col, numberOfRows, numberOfCols)) {
                System.out.println("Island is row is " + row + " col is " + col);
                return true;
            } else if (isWater(grid, row, col - 1, numberOfRows, numberOfCols)
                    && isWater(grid, row, col + 1, numberOfRows, numberOfCols)) {
                System.out.println("Island is row is " + row + " col is " + col);
                return true;
            }
        }

        return false;

    }

    private boolean isWater(final char[][] grid, final int row, final int col, final int numberOfRows,
            final int numberOfCols) {
        if (row < '0' || row >= numberOfRows || col < '0' || col >= numberOfCols) {
            return true;
        }

        if (grid[row][col] == '0') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] multi = new char[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        char[][] multi1 = new char[][] { { 1, 1 } };
        Islands islands = new Islands();
        System.out.println("Number of islands is " + islands.numIslands(multi1));
    }
}
