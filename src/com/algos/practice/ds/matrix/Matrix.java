package com.algos.practice.ds.matrix;

import com.google.common.base.Preconditions;

public class Matrix {

    private final int numberOfRows;

    private final int numberOfColumns;

    private char[][] matrix;

    public Matrix(final String[] strings) {
        numberOfRows = strings.length;

        Preconditions.checkArgument(strings.length > 0, "Strings array can not be empty");
        validateArray(strings);
        numberOfColumns = strings[0].length();

        matrix = getCharMatrix(strings);
    }

    public static void printMatrix(final int[][] inputMatrix, final int numRows, final int numColumns) {
        System.out.println("Printing matrix");
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numColumns; col++) {
                System.out.print(inputMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrixTopDownward() {
        System.out.println("Printing matrix left top downward");
        for (int col = 0; col < numberOfColumns; col++) {
            for (int row = 0; row < numberOfRows; row++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void printMatrixTopBackward() {
        System.out.println("Printing matrix left top backward");
        for (int row =  0; row < numberOfRows; row++) {
            for (int col = numberOfColumns - 1; col >= 0; col--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public void printMatrixBottomForward() {
        System.out.println("Printing matrix left bottom forward");
        for (int row =  numberOfRows - 1; row >= 0; row--) {
            for (int col = 0; col < numberOfColumns; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public void printMatrixBottomBackward() {
        System.out.println("Printing matrix right bottom backward");
        for (int row =  numberOfRows - 1; row >= 0; row--) {
            for (int col = numberOfColumns - 1; col >= 0; col--) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private char[][] getCharMatrix(final String[] strings) {
        final char[][] charMatrix = new char[numberOfRows][numberOfColumns];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                charMatrix[i][j] = strings[i].charAt(j);
            }
        }

        return charMatrix;
    }

    private void validateArray(final String[] strings) {
        int len = strings[0].length();
        for (int i = 1; i < numberOfRows; i++) {
            if (len != strings[i].length()) {
                throw new RuntimeException("Strings array should contain all the strings of same length");
            }
        }
    }

    public static void main(String[] args) {
        String[] input = { "ABCD", "FFGH", "IJKL", "MNOP", "QRST", "UVWX" };
        Matrix matrix = new Matrix(input);
        
        matrix.printMatrixTopDownward();
        
        matrix.printMatrixTopBackward();
        
        matrix.printMatrixBottomForward();
        
        matrix.printMatrixBottomBackward();
    }
}
