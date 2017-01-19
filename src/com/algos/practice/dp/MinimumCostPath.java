package com.algos.practice.dp;

import com.google.common.base.Preconditions;

public class MinimumCostPath {

    private int[][] matrix;

    private int numberOfRows;

    private int numberOfColumns;

    private int[][] solutionMatrix;

    public MinimumCostPath(final int[] inputArray, final int numberOfRows, final int numberOfColumns) {
        matrix = new int[numberOfRows][numberOfColumns];
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        Preconditions.checkArgument(inputArray.length == (numberOfRows * numberOfColumns), "Wrong input");
        int arrayIndex = 0;
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                matrix[row][col] = inputArray[arrayIndex++];
            }
        }
        
        printMatrix(matrix, numberOfRows, numberOfColumns);
    }
    
    private void printMatrix(final int[][] inputMatrix, final int numberOfRows, final int numberOfCols) {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfCols; col++) {
                System.out.print(" " + inputMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private void initializeSolutionMatrix() {
        solutionMatrix = new int[numberOfRows][numberOfColumns];
        solutionMatrix[0][0] = matrix[0][0];

        for (int row = 1; row < numberOfRows; row++) {
            solutionMatrix[row][0] = matrix[row][0] + solutionMatrix[row - 1][0];
        }

        for (int col = 1; col < numberOfColumns; col++) {
            solutionMatrix[0][col] = matrix[0][col] + solutionMatrix[0][col - 1];
        }
        
        printMatrix(solutionMatrix, numberOfRows, numberOfColumns);
    }

    public int execute() {
        initializeSolutionMatrix();
        for (int row = 1; row < numberOfRows; row++) {
            for (int col = 1; col < numberOfColumns; col++) {
                solutionMatrix[row][col] = matrix[row][col] + min(solutionMatrix[row - 1][col], solutionMatrix[row][col - 1]);
            }
        }
        
        printMatrix(solutionMatrix, numberOfRows, numberOfColumns);
        return solutionMatrix[numberOfRows - 1][numberOfColumns - 1];
    }
    
    private int min(final int x, final int y) {
        if(x < y) {
            return x;
        } else {
            return y;
        }
    }
    
    public static void main(final String[] args) {
        int[] input = {1, 7, 9, 2, 8, 6, 3, 2, 1, 6, 7, 8, 2, 9, 8, 2};
        MinimumCostPath costPath = new MinimumCostPath(input, 4, 4);
        System.out.println(costPath.execute());
    }
}
