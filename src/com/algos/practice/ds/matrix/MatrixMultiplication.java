package com.algos.practice.ds.matrix;

public class MatrixMultiplication {
    
    
    public int[][] multiply(final int[][] matrix1, final int[][] matrix2) {
        int m = matrix1.length;
        int n = matrix1[0].length;
        int p = matrix2[0].length;
        Matrix.printMatrix(matrix1, m, n);
        Matrix.printMatrix(matrix2, n, p);
        
        int[][] result = new int[m][p];
        
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < p; col++) {
                for(int k = 0; k < n; k++) {
                    result[row][col] += (matrix1[row][k] * matrix2[k][col]);
                }
            }
        }
        Matrix.printMatrix(result, m, p);
        return result;
    }

    public static void main(String[] args) {
        MatrixMultiplication obj = new MatrixMultiplication();
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};
        obj.multiply(matrix1, matrix2);
    }
}
