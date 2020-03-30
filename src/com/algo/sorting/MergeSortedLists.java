package com.algo.sorting;

public class MergeSortedLists {
	public static void main(String a[]) {
		int[] A = { 1, 3, 9 };
		int[] B = { 2, 4, 7, 9 };
		System.out.println("Printing A...");
		for (int x : A) {
			System.out.print(x + " ");
		}
		System.out.println();
		System.out.println("Printing B...");
		for (int x : B) {
			System.out.print(x + " ");
		}
		int[] C = merge(A, B);
		System.out.println();
		System.out.println("Printing merged list...");
		for (int x : C) {
			System.out.print(x + " ");
		}
	}

	public static int[] merge(int[] A, int[] B) {
		int aSize = A.length;
		int bSize = B.length;
		int[] C = new int[aSize + bSize];
		
		int i = 0, j = 0, k = 0;

		while (i < aSize && j < bSize) {
			if (A[i] < B[j])
				C[k++] = A[i++];
			else
				C[k++] = B[j++];
		}
		// Copy the remaining elements-if present
		for (; i < aSize; i++) {
			C[k++] = A[i];
		}
		for (; j < bSize; j++) {
			C[k++] = B[j];
		}
		return C;
	}
}
