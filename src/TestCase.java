public class TestCase {

	public static void main(String[] args) {
		//int n = 25;

		 //System.out.println("Trailing Zero : "+ findTrailingZero(2965));

		int grid[][] = { { 19, 26},{ 3, 32 } };
		//System.out.println(solve(a,25));
		
		int i=0,j=0,sum=0;
        while(i<grid.length-1 && j<grid[0].length-1)
        {
            sum += grid[i][j];
            
            if(grid[i+1][j] < grid[i][j+1])
            {
                i++;
            }else{
                j++;
            }
        }
        System.out.println(sum);
		
	}
	

	//find square of a*a in M*N matrix whose sum max
	public static int solve(int[][] A, int B) {
		int row = A.length;
		int col = A[0].length;
		int val = Math.min(row, col);

		while (val > 0) {
			int p = 0, q = 0, sum = 0;
			boolean flag = true;
			for (p = 0; p <= row - val; p++) {
				for (q = 0; q <= col - val; q++) {
					sum = 0;
					for (int i = p; i < p + val; i++) {
						for (int j = q; j < q + val; j++) {
							sum += A[i][j];
							System.out.println(sum);
						}
					}
					if (sum > B) {
						System.out.println("for loop break;");
						flag = false;
						break;
					}

				}
			}
			if (flag) {
				System.out.println("while loop break;");
				break;
			}
			;

			val--;

		}
		return (val == 0) ? -1 : val;
	}
	
	

	private static int findTrailingZero(int n) {
		int ans = 0;
		int con = 5;
		while (n / con >= 1) {
			ans += n / con;
			System.out.println(ans);
			n = n / 5;
		}
		
		return ans;
	}

}
