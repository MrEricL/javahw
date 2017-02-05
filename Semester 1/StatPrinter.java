/***
Eric Li
APCS1 pd4
HW #55: His Toe Grammar
2017-01-04

    An AP-style question, for practice...

    Write the StatPrinter class below. The StatPrinter Object receives an
    ArrayList of nonnegative integers, then builds a frequency ArrayList where
    the index values are the data and the entry at the index is the frequency.
    For example, if the received data is : 2,3,2,5,1,3 then the frequency 
    list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
    2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
    the maximum value of the data.

    A capability of the class is to calculate local modes from the frequency 
    list. A local mode is a value that is greater than the value at index - 1 
    and greater than the value at index + 1. A local mode is never at the end
    points of the list. For example if the frequency list is [1,2,1,4,2,3,5] 
    then the local modes are: 2 and 4.



    This class is also capable of printing a histogram of the frequencies, using
    ‘*’ to indicate a frequency amount. To print a histogram, the user specifies
    the longest sequence of ‘*’s used and then all other values are printed in 
    proportion to this value. For example, if longest bar is 10 and the frequency
    list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

    0 : **
    1 : ****
    2 : **
    3 : ********
    4 : ****
    5 : ******
    6 : **********

    For each method, state the run time efficiencies using Big O notation.
    =======================================
    Tip:
    * Develop 1 fxn at a time, test it, then move to next.
    * Look over all, think a bit, decide which to tackle first.
    ( Simplest?  Prerequisite? . . . )
    * Coding today, what extra code do you need to get past Mr. Compiler?
    ***/

import java.util.ArrayList;

public class StatPrinter 
{

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency = new ArrayList <Integer>();


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]

    // O(n) constant maybe 2n since there is two loops
    public StatPrinter( ArrayList <Integer> data ) 
    {
	int length = max (data)+1;  //sets the length of the inst var
	while (length > 0){
	    _frequency.add(0);
	    length--;
	}

	for (int i = 0; i < data.size(); i++){ // takes the goes to that number's index and adds one
	    int index  = data.get(i);
	    int numb= _frequency.get(index);
	    _frequency.add(index,numb+1);
	    _frequency.remove(index+1); 
	}
    }


    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data

    // O(n) is linear
    public Integer max( ArrayList <Integer> data ) 
    { 
	int big=0;
	for (int i=0; i < data.size();  i++) {
	    if (data.get(i) > big) big = data.get(i);
	}
	return big;
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    public boolean isLocalMode( int i ) 
    { 
        boolean ret;
	System.out.println (_frequency);
	if (i > 0 && i < _frequency.size() - 1) {
	    if (_frequency.get( i - 1 ) < _frequency.get( i ) && _frequency.get( i + 1 ) < _frequency.get( i )) ret = true;
	    else ret = false;
	    // System.out.println("frequency at index "+ i + " is " + _frequency.get(i));
	    // System.out.println("ret is " + ret);
	    //  System.out.println();
	    //    System.out.println();
	    
	}
	else ret = false;
	
	return ret;
    }


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    // O(1) constant
    public ArrayList <Integer> getLocalModes() 
    {
	ArrayList modes = new ArrayList < Integer> ();
	for (int i = 0; i < _frequency.size(); i++){
	    if (isLocalMode(i)) modes.add(i);
	}
	return modes;
    }//O(?)


    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    // O(n^2) double nested loop
    public void printHistogram( int longestBar ) 
    {
	long z = System.nanoTime();
        int scale = (int) (longestBar / max(_frequency));
	for (int i = 0; i < _frequency.size(); i++){
	    System.out.print(i+": ");
	    for (int x = 0 ; x < (_frequency.get(i) * scale) ; x++){
		System.out.print("*");
	    }
	    System.out.println();
	}
	System.out.println (System.nanoTime() - z); // TIMER
       
    }//O(?)
    public static void main (String args[]){
	ArrayList <Integer> rob = new ArrayList  <Integer> ();
	rob.add(2);
	rob.add(0);
	rob.add(3);
	rob.add(1);	
	rob.add(2);
	rob.add(1);
	rob.add(1);
	rob.add(1);
	rob.add(2);
	rob.add(0);
	rob.add(3);
	rob.add(1);	
	rob.add(2);
	rob.add(1);
	rob.add(1);
	rob.add(1);	
	StatPrinter bob = new StatPrinter (rob);
	bob.printHistogram (20);


    }
 
}//end class StatPrinter
