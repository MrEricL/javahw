import java.util.ArrayList;
public class MySorts{
    // helper functions
    public ArrayList inSort (Comparable x){
	return bubbleSort(x);	
    }
    public static ArrayList generate(){
	ArrayList<Integer> ran = new ArrayList<Integer>();
	int length= 10 + (int)(Math.random()*20);
	while (length > 0){
	    ran.add((int)(Math.random() * 10001)); //randomly adds an int from 0 -10000
	    length--;
	}
	return ran;
    }

    public static int[]  passPrint(Comparable x){
	int[] results = new int[3];
	//	System.out.println("Passes for bubble sort is: " + bubbleSort(x));
	results[0]= bubbleSort(x);
	//	System.out.println("Passes for bubble sort is: " + insertionSort(x));
	results[1]=insertionSort(x);
	//	System.out.println("Passes for bubble sort is: " + selectionSort(x));
	results[2]= selectionSort(x);
	return results;
    }

    //Bubble sort--------------------------------------------------------------------------------------------------------------------
    public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
	Comparable a;
	Comparable b;
        for (int i = 0; i < data.size() - 1; i ++){
	    for (int x = 0; x < data.size() - 1; x ++){
	        a = data.get(x);
	        b = data.get(x + 1);
		if (b.compareTo(a) < 0){
		    data.set(x, b);
		    data.set(x + 1, a);
		}
	    }
	}
    }
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable>  ret = input;
	bubbleSortV(ret);
	return ret;	
    }//end bubbleSort-------------------------------------------------------------------------------------------------------------------

    //Insertion sort_____________________________________________________________________________________
 
 // end insertion sort __________________________________________________________________________________

    //selection sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // end selection sort~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static void main( String[] args ) {
        ArrayList sorted;
	ArrayList data;
	int iterator=0;
	double avgB=0;
	double  avgI=0;
	double avgS=0;
	int[] results;
	while (iterator < 100){
	    data=generate();
	    sorted=inSort();
	    results=passPrint(data);
	    avgB+= results[0];
	    avgI+=results[1];
	    avgS+=results[2];
	    System.out.println("\n\n-----------------------------------------------------------------------\n\n");
	}
	avgB/=100;
	avgI/=100;
	avgS/=100;
	System.out.println(avgB+"\n"+avgl+"\n"+avgS);

  }



}
