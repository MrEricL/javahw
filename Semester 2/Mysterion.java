//Eric Li
//APCS2 pd3
//HW #14: So So Fast
//2017-03-07
/*
When a is 0 and b is array.length -1 and c is 0  it seems to sort
When a is x  and b is 0 and c is 0, it swaps 0 and x
When a is 0 and b is 0 and c is 1 it sorts the first few
When all are the same then no change

Seems to be related to mergesort
a is the lowerbound
b is the upperbound for all the be solved
c is odd since that's the index that always ends up at the end or stays in the position

I'm going to assume it's the wonky parition to break a and b up

 */
public class Mysterion {

    public static void m(int[] ar, int a, int b, int c, int y){
	printar(ar);
	int v =  ar[c];
	ar=swap(ar,c,b);
	int s = a;
	for (int  i = s; i < b; i++){
	    if (ar[i]<v){
		ar=swap(ar,s,i);
		s++;
	    }
	}
	ar = swap (ar, b , s);
	
	System.out.println("Return value "+ ar[y-1]);
	//	printar(ar);
	    
	}


    public static int[] swap(int[] ar, int x, int y){
	int a = ar[x];
	int b = ar[y];
	ar[x]=b;
	ar[y]=a;

	return ar;
    }

    public static void printar (int[] ar){
	for (int i = 0; i < ar.length; i++) System.out.print (ar[i]+"\t");
	System.out.println();

    }
    /*
    public static void randz(int i){
	int[] x = new int [5];

	while (i > 0){
	      for (int a = 0; a < x.length; a++) x[a]=(int)(Math.random()*10);
	    //  for (int a = 0; a < x.length; a++) x[a]=a;	    
	    mysterion(x,0,4,3);
	    System.out.println("\n\n\n");
	    i--;
	}
	


    }
    */
    public static void main (String[] args){

	
	System.out.println("\n\n");

	int[] ar = {70,3,46,98,7};
	m(ar, 0, 4,1,2);
	/*
	System.out.println("\n\n");	

	int[] ar2= {1,28,33,37,4982};
	mysterion (ar2, 0, 4, 0);
	
	System.out.println("\n\n");	

	int[] ar3= {4982,37,33,28,1};
	mysterion (ar3, 0, 4, 0);

	System.out.println("\n\n");
	
	int[] ar4= {4982,37,33,28,1};
	mysterion (ar4, 0, 4, 0);

	System.out.println("\n\n");

	randz(15);
	*/
	
    }
    


}
