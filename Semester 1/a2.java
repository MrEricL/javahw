public class a2{

    public static String printall (int [][] ar){
	String ret="";
	for (int i=0;i<ar.length;i++){
	    for (int x=0;x<ar[i].length;x++){
	        ret+=ar[i][x]+" ";

	    }
	    ret+="\n";
	}
	return ret;
    }

    public static void populate(int [][] ar){
	int z=0;
	for (int i=0;i<ar.length;i++){
	    for (int x=0;x<ar[i].length;x++){
	        ar[i][x]=z;
		z+=1;

	    }
	    
	}

    }

    
    public static void main( String[] args )
    {
	int[][] a1 ={{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
	System.out.println(printall(a1));
	int [][] a3 = new int [4][5];
	populate(a3);
	System.out.println(printall(a3));



    }




}
