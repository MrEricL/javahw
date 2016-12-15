import cs1.Keyboard;
public class GuessNumber {

    private int number;
    private int max;
    private int min;
    private int tries;
    private int guess;
    
    public GuessNumber(){
	number = (int)( Math.random()*100);
	max = 100;
	min =0;
	tries = 0;
	guess = -1;
    }
    public void check (int x){
	if (x > 
    }

    public static void main (String[] args){
	GuessNumber game = new GuessNumber();
        while ( game.number != game.guess){
	    System.out.println ("Guess a number from " + game.max + "-"+ game.min);
	    try {
		check(Keyboard. readWord());}
	    catch (Exception e){}

	}
    }





}
