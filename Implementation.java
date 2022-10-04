package tries;


class TrieNode
{
	char data;
	TrieNode[] children;
	int childcount;
	boolean isTerminating;
	public TrieNode(char data)
	{
		this.data=data;
		children=new TrieNode[26];
		this.childcount=0;
		this.isTerminating=false;
	}

}
public class Implementation
{
	TrieNode root;
	public Implementation()
	{
		this.root=new TrieNode('\0');
	}
	public void add(String s)
	{
		add1(s,root);
	}
	private void add1(String s, TrieNode root2) {
		if(s.length()==0)
		{
			root2.isTerminating=true;
			return;
		}
		int index=s.charAt(0)-'a';
		TrieNode child=root2.children[index];
		if(child==null)
		{
			child=new TrieNode(s.charAt(0));
			root2.children[index]=child;
			root.childcount++;
		}
		add1(s.substring(1),child);
	}
	public boolean search(String s)
	{
		return search1(s,root);
	}
	private boolean search1(String s, TrieNode root2) {
		if(s.length()==0)
		{
			return root2.isTerminating;
		}
		int index=s.charAt(0)-'a';
		TrieNode child=root2.children[index];
		if(child==null)
		{
			return false;
		}
		return search1(s.substring(1),child);
	}
	public void remove(String s)
	{
		remove1(s,root);
	}
	public String reverse(String str)
	{
		String s1="";
		for(int i=0;i<str.length();i++)
		{
			s1=str.charAt(i)+s1;
		}
		return s1;
	}
	private void remove1(String s, TrieNode root2) {
		if(s.length()==0)
		{
			root2.isTerminating=false;
			return;
		}
		int index=s.charAt(0)-'a';
		TrieNode child=root2.children[index];
		if(child==null)
			return;
		remove1(s.substring(1),child);
		if(child.childcount==0 && !child.isTerminating)
		{
			root2.children[index]=null;
			root2.childcount--;
		}
	}
	public void display(TrieNode root,String s)
	{
		if(root==null)
			return;
		if(root.isTerminating)
		{
			System.out.println(s);
		}
		for(int i=0;i<26;i++)
		{
			if(root.children[i]!=null)
			{
				display(root.children[i],s+root.children[i].data);
			}
		}
	}
	public void print()
	{
		display(root,"");
	}
	public boolean patternMatching1(String s,TrieNode root)
	{
		if(s.length()==0)
		{
			return true;
		}
		int index=s.charAt(0)-'a';
		TrieNode child=root.children[index];
		if(child==null)
		{
			return false;
		}
		return patternMatching1(s.substring(1),child);
	}
	public boolean patternMatching(String s)
	{
		return patternMatching1(s,root);
	}
	public TrieNode searchRoot(String s)
	{
		return searchRoot(s,root);
	}
	
	private TrieNode searchRoot(String s, TrieNode root2) {
		if(s.length()==0)
		{
			return root2;
		}
		int index=s.charAt(0)-'a';
		TrieNode child=root2.children[index];
		if(child==null)
			return null;
		return searchRoot(s.substring(1),child);
	}
	public void autoComplete(TrieNode root,String s)
	{
		autoComplete(s,root,"");
	}
	private void autoComplete(String s, TrieNode root2, String string) {
		if(root2==null)
			return;
		if(root2.isTerminating)
		{
			System.out.println(s+string);
		}
		for(int i=0;i<root2.children.length;i++)
		{
			if(root2.children[i]!=null)
			{
				autoComplete(s,root2.children[i],string+root2.children[i].data);
			}
		}
		
	}
	public static void main(String[] args) {
		Implementation a=new Implementation();
		a.add("this");
		a.add("moin");
		a.add("imran");
//		a.remove("this");
		System.out.println(a.search("this"));
		a.print();
	}
}
