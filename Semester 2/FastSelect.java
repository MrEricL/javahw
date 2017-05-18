//Eric Li
//APCS2 pd3
//HW #14: So So Fast
//2017-03-07
/*
Since this already sorts everything left of c, just make it y-1
Then just get the index of c or y-1 and it will return

a= lower
b= upper
c= partition
y= yth element
 */
public class FastSelect {

    public static void intz (int[] ar, int y){
	for (int i = 0; i <5//edit
	m(ar, 0, ar.length-1,2,y);
    }

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
	//	ar = swap (ar, b , s);
	
	System.out.println("\nReturn value "+ ar[y-1]);
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
    
    public static void randz(int i){
	int[] x = new int [5];
	int ran;

	while (i > 0){
	      for (int a = 0; a < x.length; a++) x[a]=(int)(Math.random()*10);
	    //  for (int a = 0; a < x.length; a++) x[a]=a;
	      ran = (int)(Math.random()*3)+1;
	      System.out.println("Index: "+ ran);
	      intz(x,ran);
	    System.out.println("\n\n\n");
	    i--;
	}

    }
    
    public static void main (String[] args){

	
	System.out.println("\n\n");
	/*
	int[] ar = {70,3,46,98,7};
	intz(ar,1);

	System.out.println("\n\n");	

	int[] ar2= {1,28,33,37,4982};
	intz(ar2,2);

	mysterion (ar2, 0, 4, 0);
	
	System.out.println("\n\n");	

	int[] ar3= {4982,37,33,28,1};
	mysterion (ar3, 0, 4, 0);

	System.out.println("\n\n");
	
	int[] ar4= {4982,37,33,28,1};
	mysterion (ar4, 0, 4, 0);

	System.out.println("\n\n");
	*/
	randz(15);
	
	
    }
    


}
