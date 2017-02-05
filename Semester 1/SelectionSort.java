/*
Eric Li
APCS1 pd4
HW #50: Selection, Natch
2016-12-21
 */

/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort 
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
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static int  selectionSortV( ArrayList<Comparable> given, ArrayList <Comparable> perfect ) 
    {
	ArrayList<Comparable> data = given;
	Comparable small= data.get(0);
	int ind;
	Comparable old;

	int g=0; //PASSES
	
	for ( int i = 0; i < data.size()-1;i++){
	    	    if (!comp(data,perfect)){
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
    }		
		
	//end selectionSort

    public static  boolean comp (ArrayList<Comparable>  x, ArrayList <Comparable> y){
	for (int i=0; i < x.size() ; i++){
	    if (x.get(i).compareTo(y.get(i)) != 0){
		    return false;
		}
	}
	    return true;
    }



    public static void main( String [] args ) 
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

	  System.out.println( selectionSortV(glen,coco));
	
	/*===============for VOID methods=============

	  ============================================*/

    }//end main

}//end class SelectionSort
