package tries;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
class Node
{
	char data;
	int value;
	Node left;
	Node right;
	public Node(char data,int value)
	{
		this.data=data;
		this.value=value;
	}
}
class MyComparator implements Comparator<Node>
{
	public int compare(Node x,Node y)
	{
		return x.value-y.value;
	}
}
public class HuffManCoding
{
	public static void print(Node root,String s)
	{
		if(root.left==null && root.right==null && Character.isLetter(root.data))
		{
			System.out.println(root.data+" :"+s);
			return;
		}
		print(root.left,s+'0');
		print(root.right,s+'1');
	}
	public static void main(String[] args) {
		String s="aaaabbbccdd";
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++)
		{
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
		}
		Node root=null;
		PriorityQueue<Node> pq=new PriorityQueue<>(new MyComparator());
		for(Entry<Character,Integer> e: map.entrySet())
		{
			Node n =new Node(e.getKey(),e.getValue());
			n.left=null;
			n.right=null;
			pq.add(n);
		}
		while(pq.size()>1)
		{
			Node n1=pq.poll();
			Node n2=pq.poll();
			Node f=new Node('-',n1.value + n2.value);
			f.left=n1;
			f.right=n2;
			root=f;
			pq.add(f);
		}
		print(root,"");
 }
}
