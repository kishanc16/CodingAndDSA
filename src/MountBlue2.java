import java.util.Arrays;

public class MountBlue2 {

	public static void main(String[] args) {
		String str[] = { "aabc","bacda","aca" };
		String list = commonChars(str);
		System.out.println(list);
	}

	 public static String commonChars(String[] A) {
	        int[][] count = new int[A.length][26];
	        for (int i = 0; i < A.length; ++ i) {
	            for (int j = 0; j < A[i].length(); ++ j) {
	                char ch = A[i].charAt(j);
	                count[i][ch - 97] ++; 
	            }
	        }
	        String result = "";
	        for(int i=0; i<A.length; i++)
	        {
	        	System.out.println(Arrays.toString(count[i]));
	        }
	        for (int i = 0; i < 26; ++ i) {
	            int k = Integer.MAX_VALUE;
	            for (int j = 0; j < A.length; j ++) {
	                if (count[j][i] == 0) {
	                    k = -1; 
	                    break;
	                }
	                k = Math.min(k, count[j][i]);
	            } 
	            while (k -- > 0) {
	                result+=((char)(97 + i));
	            }
	        }
	        return result;
	        
	 }
}
