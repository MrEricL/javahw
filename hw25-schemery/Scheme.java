//Eric Li
//APCS pd3
//HW #25: What a Racket
//2017-03-28


/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *
 * Check for nested parens. Check by searching for "(" then ")" and recursively evaluate it first. Rinse and repeat.
 * The nested values have a helper function to "add".
 * Evaluate by splitting string into array before pushing that backwards into an ALStack.
 * If nested value exist push that first.
 * Pop to find the sign and apply the sign until ALStack is empty.
 * Return the final value!
 *
 * 
 * STACK OF CHOICE: ArrayList
 * b/c ... ArrayList are nice
 ******************************************************/

public class Scheme 
{

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/

    
    public static String evaluate( String expr ) 
    {
        Stack<String> stacky = new ALStack<String>();
	
	expr=expr.substring(2,expr.length()-2); //rid of outtermost paren
	//	System.out.println("Eval: "+expr);
	//checks for nested parens
	int parencheck=0;
	int index=0;
	int index2=0;
	String ref;
	String nest="";
	for (int i=0;i<expr.length();i++){
	    ref=expr.substring(i,i+1);
	    if (parencheck==1 && ref.equals(")")){
		index2=i;
		nest=nestAdd(nest,evaluate(expr.substring(index,index2+1)));
	        expr=expr.substring(0,index)+expr.substring(index2+1);
		i=0; //resets values for new checl
		parencheck=0;
		index=0;
		index2=0;
	    }
	    else if (ref.equals("(")) {
		index=i;
		parencheck+=1;
	    }
	}
	//real evaluation
	String[] spl = expr.split("\\s+");
	//	System.out.print("Split:\t");
	for (int i = spl.length-1; i >= 0; i--){
	    //    System.out.print(spl[i]+" ");
	    stacky.push(spl[i]);
	}


	String op = stacky.pop();
	//	System.out.println("\nOP "+op);
	if (nest.length() > 0) stacky.push(nest); //all the nested values	

	
	if (op.equals("+")) return unload (1, stacky);
	else if (op.equals("-")) return unload (2, stacky);
	else  return unload (3, stacky);

	
    }
    
    //helper function for multiple nested parens
    public static String nestAdd(String nest, String add){
	int total;
	if (nest=="") total=0;
	else total= Integer.parseInt(nest);
	total+= Integer.parseInt(add);
	return Integer.toString(total);
    }
    
    public static String unload( int op, Stack<String> numbers ) 
    {
	/*	System.out.println("begin");
	while (!numbers.isEmpty()){
	    System.out.println(numbers.pop());	    

	    }*/

	    
	int total=0;
	int totalm=1;
	int num=0;
	if (op==2) total=Integer.parseInt(numbers.pop()); //since its subtract


        while (!numbers.isEmpty()){
	    num=Integer.parseInt(numbers.pop());

	    if (op==1){
		total+=num;
	    }
	    else if (op==2){
		total-=num;
	    }
	    else {
		totalm*=num;
	    }
	}
	if (totalm >1) return Integer.toString(totalm);
	return Integer.toString(total);	
    }



    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {

	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//main

}//end class Scheme
