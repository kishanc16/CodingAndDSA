package com.datastructure;

public class SpiralMatrix {
	//for n x n matrix
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = { { 1, 2, 3},{ 4, 5, 6 }}; 
		int n1 = arr.length;
		int n2 = arr[0].length;
		int row = n1-1;
		int rowIndex = 0;
		int col = n2-1;	
		int colIndex=0;
		int value = 1;
		
		for(int i=0;i<n1;i++)
		{
			for(int j=0; j<n2;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		while(value <= n1*n2){
			
			for(int i=colIndex; i<=col; i++)
			{
				System.out.print(arr[rowIndex][i]+" ");
				value++;
			}
			rowIndex++;
			
			for(int j=rowIndex;j<=row;j++){
				System.out.print(arr[j][col]+" ");
				value++;
			}
			col--;
			if(rowIndex <= row){
				for(int i=col; i>= colIndex; i--){
					System.out.print(arr[row][i]+" ");
					value++;
				}
				row--;
			}
			if(colIndex<=col){
				for(int j =row; j>=rowIndex;j--){
					System.out.print(arr[j][colIndex]+" ");
					value++;
				}		
				colIndex++;
			}
		}
	}

}
