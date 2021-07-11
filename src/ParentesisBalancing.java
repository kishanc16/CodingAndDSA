import java.util.Stack;

public  class ParentesisBalancing {
	
	public static void main(String ar[])
	{
		
		String str ="((())())(())";
		System.out.println("Parenthesis Balance : "+checkBalance(str));

	}

	private static boolean checkBalance(String str) {
		
		Stack<Character> st =new Stack<>();
		for(int i=0; i<str.length(); i++)
		{
			if(st.isEmpty() || str.charAt(i) == '('){
				st.push(str.charAt(i));
			}else if(!st.isEmpty() && st.peek() == ')')
					st.push(')');
			 else
				st.pop();
		}
	
		if(st.isEmpty())
			return true;
		else{
			while(!st.isEmpty()){
				if(st.pop() == ')'){
					str = '(' +str;
				}else{
					str = str+')';
				}
			}
		}
		System.out.println("Balanced "+ str);
		return false;
	}
}
