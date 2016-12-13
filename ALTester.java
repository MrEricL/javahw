/*
Eric Li
APCS1 -pd 4
HW #45: Al<B> Sorted!. 
2016-12-13
 */
import java.util.ArrayList;

public class ALTester{

    public static boolean check (ArrayList<Integer> list){
	boolean sorted=true;
	for (int i=0; i< list.size()-1; i++){
	    if (list.get(i)>list.get(i+1)){
		sorted=false;
		break;
	    }
	    
	}
	return sorted;


    }
    public static void main( String [] args ) 
    {
	ArrayList<Integer> list = new ArrayList<Integer>();
	//populates
        for (int i=0; i<23; i++){
	    list.add((int)(Math.random()*100)); // for random
	     // list.add(i); //for ordered
	}

	//checks if it's sorted
	System.out.println(check (list));
	//prints the list
	System.out.println(list);

    }
}
