public class MySorts{
    // helper functions
    public Comparable intSort (Comparable x){
	return bubbleSort(x);	
    }

    //Bubble sort
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
    }//end bubbleSort

    //Insertion sort
    public static void insertionSortV( ArrayList<Comparable> data ) 
    {
	for( int partition = 1; partition < data.size(); partition++ ) {
            //partition marks first item in unsorted region

            //diag:
            System.out.println( "\npartition: " + partition + "\tdataset:");
            System.out.println( data ); 

            //traverse sorted region from right to left
            for( int i = partition; i > 0; i-- ) {

                // "walk" the current item to where it belongs
                // by swapping adjacent items
                if ( data.get(i).compareTo( data.get(i-1) ) < 0 ) {
                    //diag:
                    System.out.println( "swap indices "+(i-1)+" & "+i+"..." );
                    data.set( i, data.set( i-1, data.get(i) ) ); 
                }
                else 
                    break; 
            }
        }
    }
    public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) 
    {
	//declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();

        //copy input ArrayList into working ArrayList
        for( Comparable o : input )
            data.add( o );

        //sort working ArrayList
        insertionSortV( data );

        //return working ArrayList
        return data;
    }


    //selection sort


    public static void main( String[] args ) {
	Comparable sorted;
	


  }



}
