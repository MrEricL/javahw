




/* What is this ungodly mess? 
The idea of this is to modify each of the programs to be optimized for the maximum number of passes
Now what I do is run each program on a randomly generated array list of ~10-30 integers
Tally the number of passes
Repeat for 100 times (roughly takes 5 min)
Take the average number of all the passes
Figure out which of the algorithms is most successful (smallest number) in the 100 test cases

FINDINGS ------

1. Selection

2. Bubble

3. ???
 */


import java.util.ArrayList;
import java.util.Arrays;



public class MySorts{
    // helper functions


    
    
    public static ArrayList generate(){
	ArrayList<Integer> ran = new ArrayList<Integer>();
	int length= 10 + (int)(Math.random()*20);
	while (length > 0){
	    ran.add((int)(Math.random() * 10001)); //randomly adds an int from 0 -10000
	    length--;
	}
	return ran;
    }

    public static int[]  passPrint(ArrayList <Comparable> x){
	int[] results = new int[3];
	ArrayList y= new ArrayList<Comparable>();
	ArrayList z= new ArrayList<Comparable>();	
	for (int i = 0; i < x.size(); i++) y.add(x.get(i));
	for (int i = 0; i < x.size(); i++) z.add(x.get(i));	    
	//	System.out.println("Passes for bubble sort is: " + bubbleSort(x));
	results[0]=  bubbleSort(x);
	//	System.out.println("Passes for bubble sort is: " + insertionSort(x));
	results[1]=insertionSort(y);
	//	System.out.println("Passes for bubble sort is: " + selectionSort(x));
	results[2]= selectionSort(z);
	return results;
    }
    
    public static  boolean comp (ArrayList<Comparable>  x){
	for (int i=0; i < x.size()-1 ; i++){
	    if (x.get(i).compareTo(x.get(i+1)) >= 0) return false;
	}
	return true;
    }    

    //Bubble sort--------------------------------------------------------------------------------------------------------------------
    public static int bubbleSort( ArrayList<Comparable> d) 
    {
	ArrayList<Comparable> data = d;
	Comparable a;
	Comparable b;
	int g=0;
        for (int i = 0; i < data.size() - 1; i ++){
	    if (!comp(data)){
		for (int x = 0; x < data.size() - 1; x ++){
		    a = data.get(x);
		    b = data.get(x + 1);
		    if (b.compareTo(a) < 0){
			data.set(x, b);
			data.set(x + 1, a);
		    }
		}
		g+=1;
	    }
	    else{
		return g;
	    }
	}
	return -1;
    }    

    //end bubbleSort-------------------------------------------------------------------------------------------------------------------

    //Insertion sort_____________________________________________________________________________________
    
    public static int smallest (ArrayList<Comparable> x, Comparable y, int b){
	Comparable z=null; // is the element in the comparision list

	for (int a=b; a >= 0; a--){
	    	if (b==0 || a==0){
		    if (y.compareTo(x.get(0)) >= 0) return 1;
		    else return 0;
		}
		else {
		    z= x.get(a-1);
		    if (y.compareTo(z) >= 0) return a;

		}
	}

	return 0;

	
    }

    
    public static int insertionSort( ArrayList<Comparable> given) 
    {
	ArrayList <Comparable> data = given;
	int part=1;
	int indexinsert=0;

	int g= 0;
	
	while (part < data.size()){
	    if (!comp(data)){	    
		if (data.get(part) .compareTo(data.get(part-1)) > 0) part++ ; 
		else{
		    indexinsert= smallest(data, data.get(part), part-1);
		    data.add(indexinsert, data.get(part));
		    data.remove(part+1);
		    part++;
		}
	        g+=1;
	    }
	    else return g;	    
	}
	return -1;
    }
 
 // end insertion sort __________________________________________________________________________________

    //selection sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // helper functions
    public static int selectionSort (ArrayList < Comparable> given){
	ArrayList<Comparable> data = given;
	Comparable small= data.get(0);
	int ind;
	Comparable old;

	int g=0; //PASSES
	
	for (int i = 0; i < data.size()-1;i++){
	    	    if (!comp(data)){
				old= data.get(i);
			ind= i;
			for (int x = i; x <= data.size()-1;x++){
			    if (small.compareTo(data.get(x)) > 0){
				small = data.get(x);
				ind=x;
			    }
			}
			data.remove(i);
			data.add(i, small);
			data.remove(ind);
			data.add(ind, old);
			small= data.get(i+1);			
			g+=1; 
		    }
		    else {
			return g;
		    }
	}
	return -1;
    }//ends

    // end selection sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main( String[] args ) {

	ArrayList data= generate();
	int iterator=0;
	double avgB=0;
	double  avgI=0;
	double avgS=0;
	int[] results;



	while (iterator < 100000){
	    data=generate();	    
	    results= passPrint(data);

	       avgB+= results[0];
	      avgI+=results[1];
	      avgS+=results[2];
	    iterator+=1;
	}

		System.out.println(avgB+"\n"+avgI+"\n"+avgS);

    }
}
