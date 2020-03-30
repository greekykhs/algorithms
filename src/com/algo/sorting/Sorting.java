package com.algo.sorting;

public class Sorting {
	public static void main(String[] args) {
		int[] arr1 = { 9, 2, 8, 12, 7 };
		System.out.println("Before Sort..");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
		System.out.println();
		bubbleSort(arr1);
		System.out.println("After  Sort..");
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}
	public static int[] bubbleSort(int A[])
	{
		int length=A.length;
		int temp;
		int flag=0;
		for(int i=0;i<length;i++){
			for(int j=0; j<length-1-i;j++){
				if(A[j]>A[j+1]){
					temp=A[j];
					A[j]=A[j+1];
					A[j+1]=temp;
					flag=1;
				}				
			}
			if(flag==0)
				break;
		}		
		return A;
	}
	public static void insertionSort(int A[]) {  
		int length=A.length;
		int key, j;
		for(int i=1; i<length; i++)
		{
			key=A[i];
			j=i-1;
			while((j>-1) && (A[j]>key))
			{
				A[j+1]=A[j];
				j--;
			}
			A[j+1]=key;
		}
	}
	
	public static void selectionSort(int A[]) {
		int length = A.length;
		int index;
		int minVal = 0;
		for (int i = 0; i < length; i++) {
			index = i;
			for (int j = i + 1; j < length; j++) {
				if (A[j] < A[index]) {
					index = j;
				}
			}			
			if(i!=index)
			{
				minVal = A[index];
				A[index] = A[i];
				A[i] = minVal;
			}
		}
	}

}
