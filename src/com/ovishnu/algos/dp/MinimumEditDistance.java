package com.ovishnu.algos.dp;

public class MinimumEditDistance {
    
    private String str1, str2;
    
    private int[][] solutionMatrix;

    public MinimumEditDistance(final String str1, final String str2) {
        this.str1 = str1;
        this.str2 = str2;
        intializeSolutionMatrix();
    }
    
    private void intializeSolutionMatrix() {
        solutionMatrix = new int[str1.length() + 1][str2.length() + 1];
        
        for(int row = 0; row < str1.length(); row++) {
            solutionMatrix[row][0] = row;
        }
        
        for(int col = 0; col < str2.length(); col++) {
            solutionMatrix[0][col] = col;
        }
    }
    
    public int getDistance() {
        for(int row = 1; row <= str1.length(); row++) {
            for(int col = 1; col <= str2.length(); col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    solutionMatrix[row][col] = min(solutionMatrix[row - 1][col - 1], solutionMatrix[row][col - 1] + 1, solutionMatrix[row - 1][col] + 1);
                } else {
                    solutionMatrix[row][col] = min(solutionMatrix[row - 1][col - 1] + 2, solutionMatrix[row][col - 1] + 1, solutionMatrix[row - 1][col] + 1);
                }
            }
        }
        
        return solutionMatrix[str1.length()][str2.length()];
    }
    
    private int min(int x, int y, int z) {
        if ( x < y) {
            if(x < z) {
                return x;
            }
        } else {
            if(y < z) {
                return y;
            }
        }
        
        return z;
    }
    
    public static void main(String[] args) {
        MinimumEditDistance editDistance = new MinimumEditDistance("INTENTION", "EXECUTION");
        System.out.println("Minimum distance is " + editDistance.getDistance());
    }
}
