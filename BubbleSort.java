
import java.util.ArrayList;

public class BubbleSort 
{

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static int bubbleSortV( ArrayList<Comparable> d, ArrayList <Comparable>  perfect) 
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
    }//end bubbleSortV


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static void  bubbleSort( ArrayList<Comparable> input ) 
    {
	//	ArrayList<Comparable>  ret = input;
	//	bubbleSortV(ret);
	//	return ret;	
    }//end bubbleSort


    public static  boolean comp (ArrayList<Comparable>  x){
	for (int i=0; i < x.size()-1 ; i++){
	    if (x.get(i).compareTo(x.get(i+1)) >= 0) return false;
	}
	return true;
		
    }
    
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

    
    public static int insertionSortV( ArrayList<Comparable> given) 
    {
	ArrayList <Comparable> data = given;
	int part=1;
	int indexinsert=0;

	int g= 0;
	
	while (part <= data.size()){
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
	

    
    public static void main(String [] args)
    {

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  ArrayList coco = new ArrayList < Integer>();

	  coco.add(1);
	  coco.add(3);	  
	  coco.add(5);
	  coco.add(7);	  
	  coco.add(12);

	  System.out.println( insertionSortV(glen));
	  /*
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bubbleSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  */
	/*
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  ArrayList glenSorted = bubbleSort( glen );
	  System.out.println( "sorted version of ArrayList glen:\n" 
	  + glenSorted );
	  System.out.println( "ArrayList glen after sorting:\n" + glen );

	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  ArrayList cocoSorted = bubbleSort( coco );
	  System.out.println( "sorted version of ArrayList coco:\n" 
	  + cocoSorted );
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  System.out.println( coco );
	*/

    }//end main

}//end class BubbleSort
