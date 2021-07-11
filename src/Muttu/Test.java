package Muttu;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int weight[] = { 1, 3, 5, 7, 11 };
		int target = 10;
		int ans = findMinPlate(weight, target);
		System.out.println(ans);

	}

	private static int findMinPlate(int[] weight, int target) {
		int dp[] = new int[target + 1];
		int n = weight.length;

		if (target == 0)
			return 0;

		for (int i = 0; i <= target; i++) {
			dp[i] = 0;
		}
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= weight[j]) {
					dp[i] += dp[i - weight[j]];
				}
			}
		}

		System.out.println(Arrays.toString(dp));

		return (dp[target] == Integer.MAX_VALUE) ? -1 : dp[target];
	}

}
