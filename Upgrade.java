import java.util.*;

class Upgrade {
	public static void main(String args[]){
		Table t = new Table();
		t.original = true;
		System.out.println("input no. of elements");
        Scanner sc= new Scanner(System.in);
        t.n = sc.nextInt();
        //sc.nextLine();
        System.out.println("input no. of FD ");
        t.m = sc.nextInt();
        sc.nextLine();
        for(int j=0;j<t.m;j++)
        {
            System.out.println("Input FD");
            String a=sc.nextLine();
            //sc.nextLine();
            int x=0;
            for(int i=0;i<a.length();i++)/* FD converted to binary form*/
            {
                char c = a.charAt(i);
                if (c == '-') {
                    t.FD[j][0] = x;
                    x = 0;
                    i++;
                } else
                    x += Math.pow(2, (int) (c - 'A'));
            }
            t.FD[j][1]=x;
        }
		t.findNF();
		switch(t.form){
			case 1:
                //Assuming all newly formed tables are in BCNF.
                int totalAdded=0, toSubtract=0;
                Table t1to2[] = new Table[t.n1to2];
				for(int i=0; i<t.n1to2; i++){
                    t1to2[i] = new Table();
                    int toAdd = t.FD[t.violate2nf[i]][0] | t.FD[t.violate2nf[i]][1];
                    t1to2[i].attributes += toAdd;
                    totalAdded |= toAdd;
                    toSubtract |= t.FD[t.violate2nf[i]][0];
				}
                toSubtract = totalAdded - toSubtract & totalAdded;               //Set operation A-B
                t.attributes -= toSubtract;
                System.out.println("The DB decomposed to 2NF has the following relations.");
                System.out.println(t.attributes);
                //todo - print letters instead of numbers
                for(int i=0; i<t.n1to2; i++){
                   System.out.println(t1to2[i].attributes); 
                }
				break;
		}
	}
}