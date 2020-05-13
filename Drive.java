import java.util.*;
public class Drive extends Ext_Hash 
{
	public static void main(String args[])		//driver function
	{
		Ext_Hash obj = new Ext_Hash();
		Scanner ob = new Scanner(System.in);
		for(int i = 0; i < obj.max_size; i++)
		{
			obj.loc_depth[i] = 1;		//initialize local depth of directories
		}

		for(int i = 0; i < obj.max_size; i++)
		{
			for(int j = 0; j < obj.bfr; j++)
				obj.bucket[i][j] = obj.emp;		//initialize all buckets to empty
		}
		int inp = 0, m;		//ind for choice, m for number
		while(inp != 3)		//exit condition
		{
			System.out.println("Enter a choice among the following:");
			System.out.println("1.Insert");
			System.out.println("2.Search");
			System.out.println("3.Exit");
			inp = ob.nextInt();
			if(inp == 1)
			{	
				System.out.println("Enter number to be inserted");
				m = ob.nextInt();
				obj.a[obj.ind++] = m;
				obj.insert(m);
				System.out.println("Insertion successful");
			}
			if(inp == 2)
			{	
				System.out.println("Enter number to be searched");
				m = ob.nextInt();
				obj.search(m);
			}
		}
	}
}
