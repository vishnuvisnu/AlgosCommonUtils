package com.algos.practice.dp;

import com.algos.practice.utils.ArrayUtils;

public class MaxValueContiguousSubsequence {

	private void printSubsequenceRange(final int[] a) {
		int len = a.length;
		int maxSum = 0;
		int runningSum = a[0];
		int j = 0;
		int start = 0, finish = 0;

		for (int i = 1; i < len; i++) {
			if (runningSum > 0) {
				runningSum += a[i];
			} else {
				runningSum = a[i];
				j = i;
			}
			if (runningSum > maxSum) {
				maxSum = runningSum;
				start = j;
				finish = i;
			}
		}
		System.out.println("Max Sum: " + maxSum);
		System.out.println("Indices: i=" + start + ": j=" + finish);
	}

	private void printAllSubSequences(final int[] a) {
		for (int len = 1; len <= a.length; len++) {
			printAllSubSequences(a, len);
		}
	}

	private int max(final int num1, final int num2, final int num3) {
		if (num1 > num2) {
			if (num2 > num3) {
				return num1;
			}
		} else {
			if (num2 < num3) {
				return num3;
			} else {
				return num2;
			}
		}
		throw new RuntimeException("Invalid input to max");
	}

	/**
	 * Print all the all the sub sequences of input length.
	 * 
	 * @param a
	 * @param len
	 *            Length of the subsequence.
	 */
	private void printAllSubSequences(final int[] a, final int len) {
		System.out.println("\nPrinting all subsequences of length " + len);
		for (int i = 0, j = len - 1; j < a.length; j++, i++) {
			ArrayUtils.printArray(a, i, j);
		}
	}

	private void printAllTriplets(final int[] a) {
		int num_of_triplets = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				for (int k = j + 1; k < a.length; k++) {
					System.out.println("Triplet " + a[i] + " " + a[j] + " "
							+ a[k]);
					num_of_triplets++;
				}
			}
		}
		System.out.println("Total number of triplets " + num_of_triplets);
	}

	private void printAllPairs(final int[] a) {
		int num_of_pairs = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				System.out.println("Pair " + a[i] + " " + a[j]);
				num_of_pairs++;
			}
		}
		System.out.println("Total number of pairs " + num_of_pairs);
	}

	public static void main(String[] args) {
		MaxValueContiguousSubsequence sequence = new MaxValueContiguousSubsequence();
		int[] a = { -2, 11, -4, 13, -5, 2 };
		sequence.printSubsequenceRange(a);
		// int[] b = { -15, 29, -36, 3, -22, 11, 19, -5 };
		// sequence.printSubsequenceRange(b);
	}
}
