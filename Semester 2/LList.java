//Eric Li
//APCS2 pd3
//HW17 -- Generically Speaking...
//2017-03-17

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of LLNodes.
 *****************************************************/

public class LList<T>  implements List<T>
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode<T> _head;
    private DLLNode<T> _back;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
	//	_head= new LLNode("HEAD",null);
	_size=0;
    }


    //--------------v  List interface methods  v--------------

    public boolean add(T x ){
	if (_head==null) _head= new DLLNode<T>(x,null);
	else	_head.setNext( new DLLNode<T>( x, null ) );
	_size+=1;
	return true;
    } 

    public T get( int i ){
	DLLNode<T> a = _head;

	for (int x = 0 ; x < i; x++){
	    a= a.getNext();
	}

	return a.getCargo(); }

    public T set( int i, String x ){
	DLLNode<T>  temp = _head;
	for (int y = 0; y <i; y++){
	    temp=temp.getNext();
	}
	temp.setCargo(x);
	return temp.getCargo();
    }   

    //return number of nodes in list
    public int size() { return _size; }

    //////////////////////////////////////////////////

    public void add (int index, T newVal){
	LLNode temp=new DLLNode(_head.getNext().getCargo(),null);
	
	for (int x =0; x < _size; x++){
	    if (x==0);
	    else if (temp==null) temp= new DLLNode<T>(_head.getNext().getCargo(),null);

	    else if (x==index) temp.setNext( new DLLNode<T>(newVal, null ) );	    
	    else temp.setNext( new DLLNode<T>( _head.getNext().getCargo(), null ) );

	}
	_head=temp;
	_size+=1;
    }
    public T remove (int index){
	DLLNode<T> temp=_head;
	String ret="";
	for (int x =0; x < _size; x++){
	    if (x==index) ret= _head.getNext().getCargo();
	    else  temp.setNext( new LLNode<T>( _head.getNext().getCargo(), null ) );
	}
	_size-=1;
	return ret;
    }
    

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {

	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 	
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class LList



