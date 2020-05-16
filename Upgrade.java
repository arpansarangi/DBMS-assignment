import java.util.*;

//todo - public and private
class Upgrade
{
    public static void printOriginal(Table t){
        System.out.print(t.writeAttributes(t.attributes));
        System.out.print(" with candidate keys");
        for(int i=0; i<t.c; i++){
            if(t.candidate_keys[i]>0){
                System.out.print(" " + t.writeAttributes(t.candidate_keys[i]));
                if(i<t.c-1)
                    System.out.print(",");
            }
        }
        System.out.println();
    }

	public static void main(String args[]){
		Table t = new Table();
		t.original = true;
		System.out.println("Input no. of attributes");
        Scanner sc= new Scanner(System.in);
        t.n = sc.nextInt();
		System.out.println("Input attributes");
        sc.nextLine();
        String in = sc.nextLine();
        for (int x=0; x<in.length(); x++){
            t.map.put((char) (x + 'A'), in.charAt(x));
            t.mapback.put(in.charAt(x), (char) (x + 'A'));
        }
        t.mapback.put('-','-');
        t.mapback.put('>','>');
        System.out.println("Input no. of FD ");
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
                char c = t.mapback.get(a.charAt(i));
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
                int totalAdded=0, toSubtract=0;
                Table t1to2[] = new Table[t.n1to2];
				for(int i=0; i<t.n1to2; i++){
                    t1to2[i] = new Table();
                    int toAdd = t.FD[t.violate2nf[i]][0] | t.FD[t.violate2nf[i]][1];
                    t1to2[i].attributes += toAdd;
                    totalAdded |= toAdd;
                    toSubtract |= t.FD[t.violate2nf[i]][0];
				}
                toSubtract = totalAdded - (toSubtract & totalAdded);               //Set operation A-B
                t.attributes -= toSubtract;
                System.out.println("The DB decomposed to 2NF has the following relations.");
                printOriginal(t);
                for(int i=0; i<t.n1to2; i++){
                   System.out.print(t.writeAttributes(t1to2[i].attributes)); 
                   System.out.println(" with candidate key " + t.writeAttributes(t.FD[t.violate2nf[i]][0]) + ".");
                }
			break;
            case 2:
                totalAdded=0;
                toSubtract=0;
                Table t2to3[] = new Table[t.n2to3];
				for(int i=0; i<t.n2to3; i++){
                    t2to3[i] = new Table();
                    int toAdd = t.FD[t.violate3nf[i]][0] | t.FD[t.violate3nf[i]][1];
                    t2to3[i].attributes += toAdd;
                    totalAdded |= toAdd;
                    toSubtract |= t.FD[t.violate3nf[i]][0];
				}
                toSubtract = totalAdded - (toSubtract & totalAdded);               //Set operation A-B
                t.attributes -= toSubtract;
                System.out.println("The DB decomposed to 3NF has the following relations.");
                printOriginal(t);
                for(int i=0; i<t.n2to3; i++){
                   System.out.print(t.writeAttributes(t2to3[i].attributes)); 
                   System.out.println(" with candidate key " + t.writeAttributes(t.FD[t.violate3nf[i]][0]) + ".");
                }
            break;
            case 3:
                Table t3tobcnf[] = new Table[t.n3tobcnf];
                int key[] = new int[t.n3tobcnf];
                for(int i=0; i<t.n3tobcnf; i++){
                    t3tobcnf[i] = new Table();
                    t3tobcnf[i].attributes += t.FD[t.violatebcnf[i]][0] | t.FD[t.violatebcnf[i]][1];
                    key[i] = t.FD[t.violatebcnf[i]][0];
                    int b = t.FD[t.violatebcnf[i]][1] - (t.FD[t.violatebcnf[i]][1] & t.FD[t.violatebcnf[i]][0]);
                    t.attributes = t.attributes - (t.attributes & b);
                    for(int it=0; it<t.c; it++){
                        if(t.candidate_keys[it]>0){
                            if((t.candidate_keys[it] & t.attributes) != t.candidate_keys[it]){
                                t.candidate_keys[it] = 0;
                            }
                        }
                    }
                }
                System.out.println("The DB decomposed to BCNF has the following relations.");
                printOriginal(t);
                for(int i=0; i<t.n3tobcnf; i++){
                   System.out.print(t.writeAttributes(t3tobcnf[i].attributes)); 
                   System.out.println(" with candidate key " + t.writeAttributes(key[i]) + ".");
                }
            break;
		}
	}
} 
