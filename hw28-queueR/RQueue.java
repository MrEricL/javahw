/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/


public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    _front=null;
	    _end=null;
	    _size=0;
	}


    public void enqueue( T enQVal ) 
    {
	LLNode<T> temp;
    if (isEmpty()){
	_front=new LLNode(enQVal,null);
	_end=_front;
    }
    else if (_front.equals(_end)){
	temp = new LLNode (enQVal,null);
	_end= temp;
    }
    else{
        temp = new LLNode(enQVal,_front);
	_end=temp.getNext();
    }
	_size+=1;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    {
	T ret = peekFront();

	sample();
        _size-=1;
	return ret;
    }


    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * 
     * 
     ******************************************/
    public void sample () 
    {
	//	_front.setValue(null);
	LLNode<T> temp = new LLNode(_front,null);
        int x = (int)(Math.random()*_size-2);
	while (x > 0) {
	    temp=temp.getNext();
	    x--;
	}
	_front.setValue(temp.getValue());
	
    }


    public boolean isEmpty() 
    { 
	return (_size==0);
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
    String ret="FRONT->";
    LLNode<T> temp = _front;
    while (temp!=null){
	ret+=temp.getValue()+"->";
	temp=temp.getNext();
    }
    ret+="END";
    return ret;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( PirateQueue.dequeue() );
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main

}//end class RQueue
