import cs1.Keyboard;
public class Swapper {
    /*
      The goal of the swapper is to print out the predetermined array with the index of rows and columns.
      The user inputs 4 ints (the row and column of the two words) and swaps it
      Other version allows the user to choose the words directly- caps sensitive and swap by finsing the cor
      Then uses then uses the same one to swap

     */
    public static void print(String[][] a){
	System.out.println("\n");
	System.out.print( "\t");
	for (int m=0; m<a[0].length; m++){
	    System.out.print (" "+m+"\t");
	}
	System.out.println("\n");
	for (int i=0;i<a.length;i++){
	    System.out.print (i +"\t");
	    for (int x=0;x<a[i].length;x++){
		System.out.print(a[i][x]+"\t");}
	    System.out.println("\n");}
	System.out.println("\n");
    }
    public static void  corSwap(String[][] a){
	System.out.println("Type the row number for the first word");
        int y=0;
	// y cor
	
	try {
	    y=Keyboard.readInt();
	    if (y > a.length || y < 0){
		System.out.println ("Invalid input, try again");
		corSwap(a);
	         }  
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    corSwap(a);}
	// x cor
	
	System.out.println("Type the column  number for the first word");
        int x=0;
	try {
	    x=Keyboard.readInt();
	    if (x > a[0].length || x < 0){
		System.out.println ("Invalid input, try again");		
		corSwap(a);
	    }  
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    corSwap(a);}

	// y1 cor
	System.out.println("Type the row number for the second word");
        int y1=0;
	
	try {
	    y1=Keyboard.readInt();
	    if (y1 > a.length || y1 < 0){
		System.out.println ("Invalid input, try again");
		corSwap(a);
	         }  
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    corSwap(a);}

	//x1 cor 
	System.out.println("Type the column  number for the second  word");
        int  x1=0;
	try {
	    x1=Keyboard.readInt();
	    if (x1 > a[0].length || x1 < 0){
		System.out.println ("Invalid input, try again");		
		corSwap(a);
	    }  
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    corSwap(a);}
	
	intSwap (y,x,y1,x1,a);
    }

    public static void intSwap (int y, int x, int y1, int x1, String [][] a){
	String m = a[y][x];
	String n= a[y1][x1];
	a[y][x]= n;
	a[y1][x1]=m;

    }
    public static void wordSwap (String[][] a, String [] master){

	String f="";
	String g="";
	Boolean check=false;
	System.out.println ("Enter in the first word to swap");
	try {
	    f=Keyboard.readWord();
	    for (int i=0; i<master.length;i++){
		if( master[i].equals (f)){
		    check=true;}
	    }
	    if (check != true){
		System.out.println ("Invalid word. \n  THIS IS CASE SENSITIVE.\n Try again");
		wordSwap(a,master);
	    }
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    wordSwap(a,master);}
	check=false;
	System.out.println ("Enter in the second  word to swap");	
	try {
	    g=Keyboard.readWord();
	    for (int i=0; i<master.length;i++){
		if( master[i].equals (g)){
		    check=true;}
	    }
	    if (check != true){
		System.out.println ("Invalid word. \n  THIS IS CASE SENSITIVE.\n Try again");
		wordSwap(a,master);
	    } 
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    wordSwap(a,master);}
	swap (f,g,a);
    }
    public static  void swap (String x, String y, String[][] a){
        String f= x;
	String g=y;
	int xcor=0;
	int ycor=0;
	int xcor2=0;
	int ycor2=0;
       	for (int i=0;i<a.length;i++){
	    for (int o=0;o<a[i].length;o++){
		if ( a[i][o].equals(x)){
		    ycor=i;
		    xcor=o;
		}
	    }
	    }

      	for (int v=0;v<a.length;v++){
	    for (int b=0;b<a[v].length;b++){
		if ( a[v][b].equals(y)){
		    ycor2=v;
		    xcor2=b;
		}
	    }
	    }

	 intSwap(ycor, xcor, ycor2, xcor2, a);
	
    }
    public static void start (String[][] a, String [] master){

	int choice=0;
	int tries=0;
        System.out.println("How many times do you want to swap?");
	try {
	    tries= Keyboard.readInt();	
	    }
	catch (Exception exception) 
	  {	System.out.println("ENTER THE CORRECT THING");}	 	
        System.out.println("\n1. Enter coordinates of the word \n2. Enter the words\n");
	    try {
		choice= Keyboard.readInt();
		if (choice ==1){
		    for (int i=0; i<tries;i++){
			corSwap(a);
			print (a);
		    }
		}
		else if (choice==2){
		    for (int i=0;i<tries;i++){
			wordSwap(a,master);
		        print(a);
		    }
		}
		
		else{
		    System.out.println("ENTER THE CORRECT THING");
		    start(a,master);
		}

	    }
	    catch (Exception exception) 
		{
		    System.out.println("ENTER THE CORRECT THING");
		    start (a, master);
		}
    }

    public static void inti(){
	int rows=0;
	int cols=0;
	System.out.println ("How many rows do you want?");
	try {
	    rows=Keyboard.readInt();
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    inti();}	

	System.out.println("How many columns do you want?");
	try {
	    cols=Keyboard.readInt();
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    inti();}
	//int the arrays
	String [][] a = new String [rows][cols];
	String[]  master = new String [rows * cols];

	System.out.println ("Type as many words as columns by rows. This is case sensitive.");
	for (int i=0; i<(rows*cols);i++){
	    String word="";
	    try {
		word=Keyboard.readWord();
	    }
	    catch (Exception e){
		System.out.println ("Invalid input, try all again");
		inti();}
	    master[i]=word;	    
	}
	//populates it
	int z=0;
	for (int i=0;i<a.length;i++){
	    for (int x=0;x<a[i].length;x++){
	        a[i][x]=master[z];
		z+=1;

	    }
	    
	}
	print (a);
	start(a,master);

    }
    public static void main( String[] args ){
	String [][] a = {{"dog","cat","mop"},{"boy","bin","dig"}};
	String [] master = {"dog","cat","mop","boy","bin","dig"};
        int which=0;
	
	System.out.println("\n1- Default settings\n2- Build your own array");
	try {
	    which=Keyboard.readInt();
	    if (which>2 || which <= 0){
		System.out.println ("Invalid input, try again");		
	    }
	}
	catch (Exception e){
	    System.out.println ("Invalid input, try again");
	    }	
	if (which==1){
	    start(a,master);}
	else{
	    inti();
	}
	
    }
    
}
