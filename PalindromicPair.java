package tries;
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromicPair {

	public static void main(String[] args) {
		Implementation a=new Implementation();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<String> arr=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			String s=sc.next();
			arr.add(s);
			for(int j=0;j<s.length();j++)
			{
				a.add(s.substring(0,s.length()-j));
			}
		}
		for(String word : arr)
		{
			if(a.search(word) && a.search(a.reverse(word)))
			{
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
		sc.close();

	}

}
