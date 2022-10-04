package tries;

import java.util.Scanner;

public class AutoComplete {

	public static void main(String[] args) {
		Implementation a=new Implementation();
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			a.add(sc.next());
		}
		String str=sc.next();
		TrieNode b=a.searchRoot(str);
		if(b==null)
		{
			sc.close();
			return;
		}
		a.autoComplete(b,str);
		sc.close();
	}

}
