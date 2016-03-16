package com.ovishnu.algos.utils;

public class ArrayUtils {
	
	public static void printArray(final int[] a) {
		printArray(a, 0, a.length - 1);
	}
	
	public static void printArray(final String[] a) {
        printArray(a, 0, a.length - 1);
    }
	
	public static void printArray(final String[] a, final int start, final int end) {
	    System.out.println("Printing array from index " + start + " to " + end);
        for(int index = start; index <= end; index++) {
            System.out.print(" " + a[index]);
        }
        System.out.println();
	}

	public static void printArray(final int[] a, final int start, final int end) {
		System.out.println("Printing array from index " + start + " to " + end);
		for(int index = start; index <= end; index++) {
			System.out.print(" " + a[index]);
		}
		System.out.println();
	}
}
