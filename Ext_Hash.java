import java.util.*;
public class Ext_Hash
{
	public int glob_depth = 2;		//global depth
	public int bfr = 3;		//bfr
	public int max_size = 8		//maximum number of directories
	public int loc_depth[] = new int[max_size];		//local depth of all directories
	public int bucket[][] = new int[max_size][bfr];		//buckets to store numbers
	public int emp = -100001, maxn = 100001;		//emp to initialize buckets with a value which identifies it as empty, maxn for maximum number of elements
	

	String get_binary(int n)		//converts hash of number to binary String
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


	String get_directory(String a)		//finds directory using last glob_depth digits of binary String
	{
		String ans = "";
		for(int i = a.length() - 1; i <= a.length() - glob_depth; i--)
		{
			ans = a[i] + ans;
		}
		return ans;
	}

	
	int get_loc_depth(String k)		//finds local depth of directory
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

	
	int get_bucket(int l, String k)		//finds bucket among local depth number of buckets in the directory
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

	
	int get_bucket_ind(int b)		//finds index in bucket where element can be inserted
	{
		for(int i = 0; i < bfr; i++)
		{
			if(bucket[b][i] == emp)
				return i;
		}
		return -1;		//bucket is full
	}

	
	int find_bucket_ind(int b, int n)	//finds index of element in bucket being searched
	{
		for(int i = 0; i < bfr; i++)
		{
			if(bucket[b][i] == emp)
				break;
			if(bucket[b][i] == n)
				return i;
		}
		return -1;		//element not found
	}

	
	
	void search(int num)
	{
		int x = num;		//copy number
		String s = get_binary(x % 10);		//binary String of hash
		String dir = get_directory(s);		//directory of element
		int ld = get_loc_depth(dir);		//local depth of element
		int buck = get_bucket(ld, dir);		//bucket number of element
		int bucket_ind = find_bucket_ind(buck, num);		//the index in bucket where element is present 
		if(bucket_ind == -1)
			System.out.println("Element not found");
		else
			System.out.println("Element found");		//Appropriate message
	}


	
	void insert(int num)
	{
		int x = num;		//copy number
		String s = get_binary(x % 10);		//binary String of hash
		String dir = get_directory(s);		//directory of element
		int ld = get_loc_depth(dir);		//local depth of element
		int buck = get_bucket(ld, dir);		//bucket number of element
		int bucket_ind = get_bucket_ind(buck);		//the index in bucket where element is present 
		if(bucket_ind != -1)
			bucket[buck][bucket_ind] = num;		//insert element in required position
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
			loc_depth[dec]++;		//increase local depth
			if(ld < glob_depth)		//reassign elements to new buckets
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
			else 		//increase global depth as local depth <= global depth and reassign all elements to new buckets
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


	
	public static void main(String args[])		//driver function
	{
		Scanner ob = new Scanner(System.in);
		for(int i = 0; i < max_size; i++)
		{
			loc_depth[i] = 1;		//initialize local depth of directories
		}

		for(int i = 0; i < max_size; i++)
		{
			for(int j = 0; j < bfr; j++)
				bucket[i][j] = emp;		//initialize all buckets to empty
		}
		int inp = 0, m;		//ind for choice, m for number
		while(inp != 3)		//exit condition
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
