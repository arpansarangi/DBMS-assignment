public class Ext_Hash
{
	public int glob_depth = 2;
	public int loc_depth[] = new int[8];
	public int bucket[][] = new int[8][3];
	public int bfr = 3;
	public int emp = -100001;
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

	void insert(int num)
	{
		int x = num;
		String s = get_binary(x % 10);
		String dir = get_directory(s);
		System.out.println("Directory is ->" + dir);
		int ld = get_loc_depth(dir);
		int buck = get_bucket(ld, dir);
		int bucket_ind = get_bucket_ind(buck);
	}
}