
public class Test2 {

	public static void main(String[] args) {
		int m = 15, n =15;
		
		int arr[][] = {				
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,1,0,0,0},
				{0,0,0,0,0,0,1,1,1,1,0,0,1,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
				};
		
		System.out.println("Original Generation : ");
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		nextGeneration(arr,m,n);
	}

	private static void nextGeneration(int[][] arr, int m, int n) {
		
		int next[][] = new int[m][n];
		
		
		for(int i=1 ;i<m-1; i++)
		{
			for(int j=1 ;j<n-1 ;j++)
			{				
				int alive = 0;
				int dead = 0;
				//for finding neighbours elements
				for(int p = -1;p<=1; p++)
				{
					for(int q =-1; q<=1; q++)
					{
						if(arr[i+p][j+q] == 1) alive++;		
						if(arr[i+p][j+q] == 0) dead++;
					}
				}
				
				alive -= 1;
				dead -= 1;
								
				if(arr[i][j] == 1 && alive < 2)
				{
					next[i][j] = 0;
					
				}else if(arr[i][j] == 1 && alive>3 )
				{
					next[i][j] = 0;
					
				}else if(arr[i][j] == 0 && dead == 3)
				{
					next[i][j] = 1;
				}else{
					next[i][j] = arr[i][j];
				}
					
			}			
		}
		
		System.out.println("Next Generation");
		for(int i=0; i<m; i++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(next[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
