package tries;

import java.util.Scanner;

public class PatternMatching {
	
	public static void main(String[] args) {
		Implementation a=new Implementation();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			a.add(sc.next());
		}
		String s="de";
		System.out.println(a.patternMatching(s));
		sc.close();
		
	}

}
