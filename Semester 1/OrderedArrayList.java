//Eric Li
//APCS1 pd4
//HW #48: Halving the Halves
//2016-12-14

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
    
      public void  addBinary(Comparable newVal) {


	int hi = _data.size();
	int low = 0;	
	int mid=(hi + low)/2;
	int i=0;
	// when empty
	if (_data.size() == 0) {
	    _data.add(newVal);
	    return;
	}

	while (hi>= low &&  i < 10){
	    if (newVal.compareTo(_data.get(mid)) == 0){
		_data.add(mid, newVal);
	        return;
	    }
	    else if (newVal.compareTo(_data.get(mid)) > 0){
		hi = mid-1;
	    }
	    
	    else if ((newVal.compareTo(_data.get(mid)) < 0)){
		low = mid+1;
	    }	

	}
	if (hi==low){
	    _data.add(hi, newVal);
	    return;
	}

	
      }
    // main method solely for testing purposes
    public static void main( String[] args ) {
	OrderedArrayList game = new OrderedArrayList();
	System.out.println("\nValues to add via addLinear() calls:");
	// testing linear search
	for( int i = 0; i < ((int)(10*Math.random())); i++ ) {
	    int valToAdd = (int)( 100 * Math.random() );
	    game.addLinear( valToAdd );
	}
	System.out.println( game );
	game.addBinary(31);
	
	System.out.println( game );
    }

}//end class OrderedArrayList
 
