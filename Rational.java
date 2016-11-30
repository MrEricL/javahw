/*
Eric Li
APCS1 pd4
HW #37: Be More Rational
2016-11-30
 */


public class Rational {
    private int numerator;
    private int denominator;
    // sets it as zero
    public Rational(){
	numerator=0;
	denominator=1;
    }
    //checks the denom, if it's 0 forces it to eb 0
    public Rational (int num, int denom){
	if (denom==0){
	    denom=1;
	    num=0;
	    System.out.println("No zero denom, value is now 0/1");
	}
	numerator=num;
	denominator=denom;
    }
    //return each component seperately
    public String toString (){

	return "Your number is: "+numerator+ "/"+denominator;

    }
    // divides the two numbers and returns it using double
    public double floatValue(){
	double numb;
	numb=numerator/denominator;
	return numb;

    }
    // multiplies using the other object denom by denom, num by num
    public void multiply(Rational x){
        denominator=x.denominator*denominator;
	numerator=x.numerator*numerator;

    }
    // same as multiply but reversed
    public void  divide(Rational x){
        denominator=denominator*x.numerator;
	numerator=x.denominator*numerator;

    }
    // just takes the numerators and multiply by the other numbers denom and adds
    // denom is just denom miltiplied by other denom
    public void add (Rational x){
       numerator= (numerator*x.denominator)+(x.numerator*  denominator);
       denominator=denominator *x.denominator;
    }
    // same as add but with a subtract
    public void subtract (Rational x){
       numerator= (numerator*x.denominator)-(x.numerator*  denominator);
       denominator=denominator *x.denominator;
    }
    // Euclid's GDC, checks if one is 0
    // Recurisvely passes the second number and the modulo
    public static int gcd(int x, int y) {
        if (y == 0){
	    return x;
	}
        else{
	    return gcd(y, x % y);
	}
    }
    // creates local var called dGCD and divides the num and denom
    public void reduce (){
	int  dGCD= gcd (numerator, denominator);
	numerator/= dGCD;
	denominator/=dGCD;

    }
    public static void main( String[] args )
    {
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
	System.out.println(r);
	System.out.println(s);
	t.reduce(); //Changes t to 2/9
	System.out.println(t);


    }






}
