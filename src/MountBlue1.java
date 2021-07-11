
public class MountBlue1 {

	public static void main(String[] args) {
		String str[]= {"ITC INFOTECH","IBM","GOOGLE","APPLE"};
		int maxLen = 0;
		for(int i=0; i<str.length; i++)
		{
			if(maxLen < str[i].length())
				maxLen = str[i].length();
		}
		printVertically(str,maxLen);
	}

	private static void printVertically(String[] str, int maxLen) {
		String result ="";
		for(int i=0; i<maxLen; i++)
		{
			for(int j=0; j<str.length; j++)
			{
				if(i < str[j].length()){
					result += str[j].charAt(i)+" ";
				}else{
					result+="  ";
				}
			}
			result+="\n";
		}
		System.out.println(result);
	}

}
