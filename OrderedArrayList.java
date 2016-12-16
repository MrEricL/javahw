//Eric Li
//APCS1 pd4
//HW46 -- ascending
//2016-12-14

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList {
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;
    // default constructor initializes instance variable _data
    public OrderedArrayList() {
	_data = new ArrayList <Comparable>();
    }
    public String toString() {
	return _data.toString();
    }
    public Comparable remove( int index ) {
	return _data.remove(index);
    }
    public int size() {
	return _data.size();
    }
    public Comparable get( int index ) {
	   return _data.get(index);
    }
    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index

    /* --------------
_data = [1,2,4]
new val = 3

_data is not empty so skip this check

      index 0 = 1
      1 compareTo 3 -> -1
      
LOOP

     index 1 = 2
     2 compareTo 3 -> -1

LOOP

     index 2 = 4
     2 compareTo 4 -> 1
     push the 4 to index 3
     index 2 becomes 3



    -----------------  */
    
    public void addLinear( Comparable newVal ) {
	if (_data.isEmpty()) _data.add(newVal); //checks if its empty 
	else {
	    for (int i=0; i<_data.size(); i++){
		if (_data.get(i).compareTo (newVal)>0){ //use comparable for each index
		    _data.add(i, newVal); // if it is larger than inserts it
		    break; // makes sure it does not run forever
		}
		else if (i ==_data.size()-1){ //if its equals just adds it
		    _data.add(newVal);
		    break;}
	    }
	}
    }
    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList Franz = new OrderedArrayList();
	System.out.println("\nValues to add via addLinear() calls:");
	// testing linear search
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}
	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();

    }

}//end class OrderedArrayList
 
