import java.util.*;

//todo - public and private
public class Table
{
    int m,n;
    int n1to2,attributes;
	boolean original;
    int [][]FD = new int[100][2];
    int []candidate_keys=new int[100];
    int []violate2nf = new int[100];
    int form,flag;

	Table(){
		original = false;
		n1to2=0;
        form=1;
        flag=0;
        attributes=0;
	}

    public void findNF()
    {
		if(original==true){
			for(int i=0; i<n; i++)
				attributes+=Math.pow(2,i);
		}
    	int c=0;
        for(int i=1;i<Math.pow(2,n);i++)
        {
            int closure=i;
            for(int j=0;j<m;j++)
            {
                for(int k=0;k<m;k++)
                {
                    if((FD[k][0]&closure) == FD[k][0])
                    {
                        closure=(closure|FD[k][1]);
                    }
                }
            }
            if(closure == Math.pow(2,n)-1)
            {
                int flag=0;
                for(int j=0;j<c;j++)
                {
                    if((i&candidate_keys[j])==candidate_keys[j])
                        flag=1;
                }
                if(flag==0)
                {
                    candidate_keys[c]=i;
                    c++;
                }
            }
        }
        int []prime=new int[n];
        for(int i=0;i<n;i++)
            prime[i]=0;
        for(int i=0;i<c;i++)
        {
            for(int j=0;j<n;j++)
            {
                int k=1<<j;
                if((candidate_keys[i] & k)==k)
                {
                    prime[j]=1;
                }
            }
        }
        int all_prime=0,all_nonprime=0;

        for(int i=0;i<n;i++)
        {
            if(prime[i]==1)
                all_prime+=(1<<i);
            else
                all_nonprime+=(1<<i);
        }

        for(int i=0;i<m;i++)
        {
            int flag2=0;
            for(int j=0;j<c;j++)
            {
                if(((FD[i][0] | candidate_keys[j])== candidate_keys[j] )&& FD[i][0]!=candidate_keys[j])
                    flag2=1;
            }
            if(flag2==1)
            {
                if((all_nonprime & FD[i][1])!=0){
                    flag=1;
                    violate2nf[n1to2++] = i;
                }   
            }
        }
        if(flag==0)
        {
            form =2;
            for(int i=0;i<m;i++)
            {
                int flag2=0;
                for(int j=0;j<c;j++)
                {
                    if((candidate_keys[j] & FD[i][0]) == candidate_keys[j])
                        flag2=1;
                }
                if(flag2==0)
                {
                    if((all_prime | FD[i][1]) != all_prime)
                        flag=1;
                }
            }
        }
        if(flag==0)
        {
            form =3;
            for(int i=0;i<m;i++)
            {
                int flag2=0;
                for(int j=0;j<c;j++)
                {
                    if((candidate_keys[j] & FD[i][0]) == candidate_keys[j])
                        flag2=1;
                }
                if(flag2==0)
                {
                   flag=1;
                }
            }
        }
        if(flag==0){
            form=4;
            System.out.println("The highest normal form is BCNF.");
        }
        else 
            System.out.println("The highest normal form is " + form + "NF.");
    }
}