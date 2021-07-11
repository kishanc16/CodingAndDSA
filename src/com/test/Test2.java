package com.test;
import java.util.*;


public class Test2 {

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,1};
		//System.out.println(lastStoneWeight(arr));
		
		//System.out.println(generateMatrix(3));
		//ArrayList<ArrayList<Integer>> A = generateMatrix(4);
		
//		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        int n = A.size();
//        int count =0;
//        for(int i=0; i<n; i++)
//        {
//            ArrayList<Integer> list = new ArrayList<>();
//            int a =0,y=i;
//            while(a<n && y>=0)
//            {
//            	System.out.print("("+a+" "+y+")");
//            	list.add(A.get(a).get(y));
//            	a++;
//            	y--;
//            	
//            }
//            System.out.println();
//            result.add(list);
//        }
//        for(int i=1; i<n; i++)
//        {
//            ArrayList<Integer> list = new ArrayList<>();
//            int a =i,y=n-1;
//            while(a<n && y>=1)
//            {
//            	System.out.print("("+a+" "+y+")");
//            	list.add(A.get(a).get(y));
//            	a++;
//            	y--;
//            }
//            System.out.println();
//            result.add(list);
//        }
//        System.out.println(result);
		System.out.println("Ans : "+subarraySum(arr, 1));
	}

	public static int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int i = 0, sum = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
		while (i < n) {
            
			sum += nums[i];
            if (sum == k) {
				count++;
			}
			if(map.containsKey(sum - k)){
                map.put(sum,map.get(sum-k)+1);
                count+= map.get(sum - k);
            }else{
                map.put(sum, 1);
            }
            			
			i++;
		}
		return count;
	}
	public static ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<A; i++)
        {
           ArrayList<Integer>list =  new ArrayList<Integer>();
            for(int j=0;j<A; j++)
            {
                list.add(0);
            }
            result.add(list);
        }
        
        int rowIndex =0;
        int colIndex =0;
        int row = A-1;
        int col = A-1;
        int n = A*A;
        int count=1+(9)%n,c=0;
        while(c <= A*A)
        {
            for(int i=colIndex; i<=col; i++)
            {
                result.get(rowIndex).set(i,count);
                count = (count)%n +1;
            }
            ++rowIndex;            
            for(int i=rowIndex; i<=row; i++)
            {
                result.get(i).set(col,count);
                count = (count)%n +1;
            }
            col--;
           
            for(int i=col; i>=colIndex; i--)
            {
                result.get(row).set(i,count);
                count = (count)%n +1;
            }
            row--;
           
            for(int i=row; i>=rowIndex; i--)
            {
                result.get(i).set(colIndex,count);
                count = (count)%n +1;
            }
            colIndex++;
            
            c+=4;
        }
        
        for(int i=0; i<A; i++)
        {
          
            for(int j=0;j<A; j++)
            {
               System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
        return result;
    
}
	
	public static int lastStoneWeight(int[] stones) {
      
		 int length = stones.length;
	        if(length == 1) return stones[0];
	        Arrays.sort(stones);
	        while(stones[length-2] > 0){
	            if(stones[length-2] == stones[length-1]){
	                stones[length-2] = stones[length-1] = 0;
	            }else{
	                stones[length-1] = stones[length-1] - stones[length-2];  
	                stones[length-2] = 0;
	            }
	            Arrays.sort(stones);
	        }
	        
	        return stones[length-1];
	}

}
