package tries;

public class Prefix {

	public static void main(String[] args) {
		Implementation a=new Implementation();
		String s="imran";
		for(int i=0;i<s.length();i++)
		{
			a.add(s.substring(0,s.length()-i));
		}
		a.print();
	}

}
