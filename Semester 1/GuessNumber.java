import cs1.Keyboard;
public class GuessNumber {

    private int number;
    private int max;
    private int min;
    private int tries;
    
    public GuessNumber(){
	number = (int)( Math.random()*100);
	max = 100;
	min =0;
	tries = 0;
    }

    public static void main (String[] args){
	GuessNumber game = new GuessNumber();
	boolean checks=false;
        while (!checks ){
	    System.out.println ("\n\nGuess a number from " + game.min + " - "+ game.max+"\n\n");
	    int x=0;
	    try {
		x= Keyboard.readInt();
		if (x > game.number){
		    game.max=x;
		    System.out.println("Too big!");
		
		}
		else if  (x < game.number ) {
		    game.min=x;
		    System.out.println ("Too small!");
		}
	    
		else {
		    checks=true;
		    System.out.println("YOU GOT IT!!!");
		}
	        
	    }
	    catch (Exception e){}
	    game.tries++;

	}
	System.out.println ("The number was : " + game.number +"\nNumber of tries : " + game.tries);
    }

}
