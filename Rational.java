/*
Eric Li
APCS1 pd4
HW #36: Be Rational
2016-11-28 
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

    public static void main( String[] args )
    {

	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r);


    }






}
