package com.dynamicprogramming;

public class MatrixChainMultltplication {

	public static void main(String[] args) {
		int arr[]= {10,20,30,40};
		
		int minSolution1 = matrixMulNaive(arr,1,arr.length-1);
		System.out.println("Minimum Soultion : "+minSolution1);
		int minSolution2 = matrixMul(arr,arr.length);
		System.out.println("Minimum Soultion : "+minSolution2);
	}

	private static int matrixMul(int[] arr, int n) {
		int matrix[][] = new int[n][n];
		
		for(int j=0; j<n; j++)
			matrix[j][j] = 0;
		int j,min=0;
		for(int k=2; k<n; k++){
			
			for(int i=1; i<n-k+1; i++){
			j = i+k-1;
			matrix[i][j] = Integer.MAX_VALUE;
			for(int p =i; p<j;p++)
			{
				min = matrix[i][p]+matrix[p+1][j]+arr[i-1]*arr[p]*arr[j];
				
				if(min < matrix[i][j])
					matrix[i][j] = min;
			}
			
			}
		}
		
		for(int i=0; i<n; i++)
		{
			for(j=0; j<n; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		return matrix[1][n-1];
	}

	//Naive approach time complexity is O(2^n)
	private static int matrixMulNaive(int[] arr, int i, int n) {
		
		if(i == n) return 0;
		
		int min = Integer.MAX_VALUE;
		int  count =0;
		for(int k =i; k<n; k++)
		{
			count = matrixMulNaive(arr,i,k)+matrixMulNaive(arr,k+1,n)
			+arr[i-1]*arr[k]*arr[n];
		}
		if(count < min) min = count;
		
		return min;
	}
	
}
