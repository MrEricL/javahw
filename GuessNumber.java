import cs1.Keyboard;
public class GuessNumber {

    private int number;
    private int max;
	private boolean checker;
    private int min;
    private int tries;
    private int guess;
	
    
    public GuessNumber(){
	number = (int)( Math.random()*100);
	max = 100;
	min =0;
	checker=false;
	tries = 0;
	guess = -1;
    }
    public void check (int x){
	if (x > number){
		min=x;
		System.out.println("Too big!");
		
	}
	else if  (x < number) {
		max = x;
		System.out.println ("Too small!);
	}
	    
	else {
		checker= true;
		System.out.println("YOU GOT IT!!!");
	}
	    
    }

    public static void main (String[] args){
	GuessNumber game = new GuessNumber();
        while ( !checker ){
	    System.out.println ("Guess a number from " + game.max + "-"+ game.min);
	    try {
		check(Keyboard. readWord());}
	    catch (Exception e){}

	}
    }





}
