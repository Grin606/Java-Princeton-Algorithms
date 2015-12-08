public class QuickUnionPathComp
{
	private int[] id; // array with parents number
	
	public QuickUnionPathComp(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; ++i) id[i] = i;
	}
	
	private int root(int i)
	{
		while (i != id[i])
		{
			id[i] = id[id[i]]; // magic trick - change parent into a grandpa
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}
