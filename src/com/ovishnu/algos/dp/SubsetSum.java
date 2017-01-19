package com.ovishnu.algos.dp;

import com.ovishnu.algos.utils.ArrayUtils;

public class SubsetSum {

    public boolean doesSumExist(final int[] set, final int start, final int end, final int sum) {
        System.out.println("Sum is " + sum + " start " + start + " end " + end);
        
        ArrayUtils.printArray(set);

        if (start > end) {
            return false;
        }

        for (int i = start; i <= end; i++) {
            int[] remaining = new int[end - start];
            int remainingIndex = 0;
            for (int k = start; k <= end; k++) {
                if (k != i) {
                    remaining[remainingIndex] = set[k];
                    remainingIndex++;
                }
            }
            boolean doesSumExist = false;
            int remainingSum = sum - set[i];
            if (remainingSum == 0) {
                return true;
            } else if (remainingSum > 0) {
                doesSumExist = doesSumExist(remaining, 0, remainingIndex - 1, remainingSum);
            }
            if (doesSumExist) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] set = { 3, 2, 7, 1 };
        System.out.println(subsetSum.doesSumExist(set, 0, 3, 6));
    }

}
