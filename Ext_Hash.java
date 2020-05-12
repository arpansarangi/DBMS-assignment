import java.util.*;
public class Ext_Hash
{
	public int glob_depth = 2;
	public int bfr = 3;
	public int max_size = 8
	public int loc_depth[] = new int[max_size];
	public int bucket[][] = new int[max_size][bfr];
	public int emp = -100001, maxn = 100001;
	String get_binary(int n)
	{
		int x = n;
		String ans = "";
		for(int i = 0; i < 3; i++)
		{
			if(x % 2)
				ans = "1" + ans;
			else
				ans = "0" + ans;
			x /= 2;
		}
		return ans;
	}


	String get_directory(String a)
	{
		String ans = "";
		for(int i = a.length() - 1; i <= a.length() - glob_depth; i--)
		{
			ans = a[i] + ans;
		}
		return ans;
	}

	int get_loc_depth(String k)
	{
		int dec = 0;
		for(int i = 0; i < k.length(); i++)
		{
			int dig = 0;
			if(k[k.length() - 1 - i] == '1')
				dig = 1;
			if(dig == 1)
				dec += Math.pow(2, i);
		}
		return loc_depth[dec];
	}

	int get_bucket(int l, String k)
	{
		int dec = 0;
		for(int i = k.length() - 1; i >= k.length() - l; i--)
		{
			if(k[i] == '1')
			{
				dec += Math.pow(2, k.length() - 1 - i);
			}
		}
		return dec;
	}

	int get_bucket_ind(int b)
	{
		for(int i = 0; i < bfr; i++)
		{
			if(bucket[b][i] == emp)
				return i;
		}
		return -1;
	}

	int find_bucket_ind(int b, int n)
	{
		for(int i = 0; i < bfr; i++)
		{
			if(bucket[b][i] == emp)
				break;
			if(bucket[b][i] == n)
				return i;
		}
		return -1;
	}

	void search(int num)
	{
		int x = num;
		String s = get_binary(x % 10);
		String dir = get_directory(s);
		int ld = get_loc_depth(dir);
		int buck = get_bucket(ld, dir);
		int bucket_ind = find_bucket_ind(buck, num);
		if(bucket_ind == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found");
	}


	void insert(int num)
	{
		int x = num;
		String s = get_binary(x % 10);
		String dir = get_directory(s);
		int ld = get_loc_depth(dir);
		int buck = get_bucket(ld, dir);
		int bucket_ind = get_bucket_ind(buck);
		if(bucket_ind != -1)
			bucket[buck][bucket_ind] = num;
		else
		{
			int dec = 0;
			for(int i = 0; i < k.length(); i++)
			{
				int dig = 0;
				if(k[k.length() - 1 - i] == '1')
					dig = 1;
				if(dig == 1)
					dec += Math.pow(2, i);
			}			
			loc_depth[dec]++;
			if(ld < glob_depth)
			{
				int a[] = new int[maxn];
				int ind = 0;
				for(int i = 0; i < bfr; i++)
				{
					a[ind++] = bucket[buck][i];
					bucket[buck][i] = emp;
				}
				for(int i = 0; i < ind; i++)
					insert(a[ind]);
			}
			else
			{
				int a[] = new int[maxn];
				int ind = 0;
				for(int i = 0; i < max_size; i++)
				{
					for(int j = 0; j < bfr; j++)
					{
						if (bucket[i][j] == emp)
							break;
						a[ind++] = bucket[i][j];
						bucket[i][j] = emp;
					}
				}
				glob_depth++;
				for(int i = 0; i < ind; i++)
					insert(a[ind]);
			}
		}
	}


	public static void main(String args[])
	{
		Scanner ob = new Scanner(System.in);
		for(int i = 0; i < max_size; i++)
		{
			loc_depth[i] = 1;
		}

		for(int i = 0; i < max_size; i++)
		{
			for(int j = 0; j < bfr; j++)
				bucket[i][j] = emp;
		}
		int inp = 0, m;
		while(inp != 3)
		{
			System.out.println("Enter a choice among the following:");
			System.out.println("1.Insert");
			System.out.println("2.Delete");
			System.out.println("3.Exit");
			inp = ob.nextInt();
			if(inp == 1)
			{	
				System.out.println("Enter number to be inserted");
				m = ob.nextInt();
				insert(m);
				System.out.println("Insertion successful");
			}
			if(inp == 2)
			{	
				System.out.println("Enter number to be searched");
				m = ob.nextInt();
				search(m);
			}
		}
		return 0;
	}
}
