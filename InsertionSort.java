/*======================================
Eric Li
APCS Pd 4
HW #51: Poker Face
2016-12-22

  class InsertionSort -- implements InsertionSort algorithm
======================================*/



import java.util.ArrayList;

public class InsertionSort 
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


 /*|||||||||||||||||||||||||||||||||||||
helper function takes the arraylist, the comparable and b which is the index of the last sorted element
checks if it iterates to the beginning of the list and either return 1 or 0 index
otherwise keep checking if the one you want to change is larger, if so take that index -1

FOR EXAMPLE

[1,4,6,5]
helper function gets: [1,4,6,5], 5, 2

checks if 5 is bigger than 6 -> false

checks if 5 is bigger than 4 -> true
return the index for it to be in which is 2

and ends the function


  |||||||||||||||||||||||||||||||||||||*/   

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
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order


/*|||||||||||||||||||||||||||||||||||||

first checks if the value next to the sorted part is bigger, if so just increase the sorted part
if not go to helper function that returns the index of where it should go
adds it to the index
removes it from it's current index
  |||||||||||||||||||||||||||||||||||||*/

    
    public static void insertionSortV( ArrayList<Comparable> data ) 
    {
	int part=1;
	int indexinsert=0;
	while (part < data.size()){
	    if (data.get(part) .compareTo(data.get(part-1)) > 0) part++ ; // since list is sorted so if its bigger than the biggest value just go on
	    else{
		indexinsert= smallest(data, data.get(part), part-1);
		data.add(indexinsert, data.get(part));
		data.remove(part+1);				      
		System.out.println(data);
		part++;
		
	    }

	}
    }//end insertionSortV


    // ArrayList-returning insertionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) 
{
    ArrayList<Comparable> ret = input;
    insertionSortV(ret);
    return ret;
    }//end insertionSort


    public static void main( String [] args ) 
{
		/*===============for VOID methods=============

	System.out.println("\n*** Testing sort-in-place (void) version... *** ");
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "\nArrayList glen before sorting:\n" + glen );
	insertionSortV(glen);
	System.out.println( "\nArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco );
	insertionSortV(coco);
	System.out.println( "\nArrayList coco after sorting:\n" + coco );

	  ============================================*/

	System.out.println( "*** Testing non-void version... *** " );
    	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "\nArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = insertionSort( glen );
	System.out.println( "\nsorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "\nArrayList glen after sorting:\n" + glen );

      	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "\nArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = insertionSort( coco );
	System.out.println( "\nsorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "\nArrayList coco after sorting:\n" + coco );
	System.out.println( coco );
		/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class InsertionSort
