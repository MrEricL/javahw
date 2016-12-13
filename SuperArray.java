/*
Eric Li
APCS1 pd4
HW44--In America, the Driver Sits on the Left
2016-12-12

 */





/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion on-demand, and read/write capability on elements.
  ==================================================*/

public class SuperArray implements List{
    private Object[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    {	_data = new Object[10];
	_lastPos = -1;
	_size = 0;	
    }

    //-------------------------------------------- Methods--------------------------------------------------------
    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	Object[] temp = new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor method -- return value at specified index
    public Object get( int index ) 
    {
	return _data[index];
    }


    //mutator method -- set index to newVal, return old value at index
    public Object set( int index, Object newVal ) 
    {
 	Object temp = _data[index];
	_data[index] = newVal;
	return temp;
    }
    // implmented stuff
    public boolean add( Object newVal )   // FIX 
    {if ( _size >= _data.length )
	    expand(); 
	_data[_lastPos+1] = newVal;
	_lastPos+=1;
	_size+=1;
	return true;
    }

    // adds and shifts
    public boolean  add( int index, Object newVal )  // FIX
    {
	if ( _size >= _data.length )
	    expand();
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; 
	} 
	_data[index] = newVal;
	_lastPos+=1;
	_size+=1;
	return true;
    }


    //removes the item at an index
    public Object remove( int index ) 
    { Object  z=null;
	for( int i=index; i < _size - 1; i++ ) {
	    z=_data[i];
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = 0; 
	_size-=1;
	_lastPos-=1;
	return z;
    }

    //returns the size
    public int size() 
    { 
	return _size;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	//	Object  mayf = new SuperArray();
	SuperArray mayfield = new SuperArray();

	System.out.println("Printing empty ListInt mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated ListInt mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing LisInt mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing ListInt mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);  //Q: Significance of this test call? out of meaningful # index
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing ListInt mayfield post-insert...");
	System.out.println(mayfield);

	//	Object[] eric = {1,2,3,"bob"};
	//	System.out.println(eric[3]);
    }//end main()

}//end class SuperArray
