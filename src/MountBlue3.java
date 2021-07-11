
public class MountBlue3 {

	public static void main(String[] args) {
		int n =5;
		int shift =10;
		int arr[][] = new int[n][n];
		printMatrixWithShift(arr,n,shift);
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(arr[i][j]+"    ");
			}
			System.out.println();
		}
	}

	private static void printMatrixWithShift(int arr[][],int n, int shift) {
		int num = (n-1)*(n-1);
		int k=(num-shift)%num+1;
		
		
		for(int i=0;i<n;i++)
		{
			arr[0][i] = k;
			k = k%num+1;
		}
		for(int i=1;i<n;i++)
		{
			arr[i][n-1]=k;
			k = k%num+1;
		}
		for(int i=n-2;i>=0;i--)
		{
			arr[n-1][i] = k;
			k = k%num+1;
		}
		for(int i=n-2; i>=1;i--){
			arr[i][0] = k;
			k = k%num+1;
		}
	}

}
