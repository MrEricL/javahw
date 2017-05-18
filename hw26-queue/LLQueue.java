/*****************************************************
Eric Li
APCS2 pd3
HW26 -- The English Do Not Wait In Line
2017-03-29
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
 {
     _front=null;
     _end=null;

    }

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
{
    if (isEmpty()){
	_front=new LLNode(enQVal,null);
	_end=_front;
    }
    else if (_front.equals(_end)){
	_end= new LLNode (enQVal, _front);
    }
    else{
	LLNode<T> temp = new LLNode(enQVal,_end);
	_end=temp;	

    }

    
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
{
    T ret = peekFront();
    //one item

    if (_end.getNext()==null) _front=_end=null;
 

    else{
	LLNode<T> temp = _end;
	while (temp.getNext()!=null){
	    if (temp.getNext().getValue().equals(ret)){
		_front=temp;
	    }
	    temp=temp.getNext();	    
	}
    }
    System.out.println ("front "+_front+ " back " + _end);
    return ret;
    }//O(1)


    // means of peeking at thing next in line for removal
    public T peekFront() 
{
    return _front.getValue();

    }//O(?)


    public boolean isEmpty() 
{
    if (_front==null) return true;
    else return false;

    }//O(1)


    // print each node, separated by spaces
    public String toString() 
{ 
    String ret="";
    LLNode<T> temp = _end;
    while (temp!=null){
	ret+=temp.getValue()+"->";
	temp=temp.getNext();
    }
    return ret;


  
    }//O(n)



    public static void main( String[] args ) {


	Queue<String> LLQueuelJ = new LLQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( LLQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );
		/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
