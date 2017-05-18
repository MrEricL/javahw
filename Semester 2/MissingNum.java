/*
Eric and Herman
Team HE
APCS2 pd3
HW#04: Where In the Array Is Carmen San Numero?  Or San Diego?
2017-2-5


Explanation

If you multipy the array and the ideal array and divide, you should get the duplicate/missing.
However you have to simplify it while making sure say a duplicate of 2 and a missing of 4 doesn't get simplified.
So I made a loop from 2 to the length of x, checked the mod of each with the duplicate and missing to divide.
This way it doesn't get simplified too much and return the missing.


Find 2 just uses a BigNumber so larger numbers that have say 99!*99 and 100! products are dealt with correctly
 */




import java.math.BigInteger;
public class MissingNum{

    public static void find (int[] x){
	double p=1;
	double ip=1;
	int rep=0;
	
	for (int i = 0; i < x.length; i++){
	    p*=x[i];
	    ip*=i+1;
	}
	int div=2;

	while (div <= x.length){
	    if (ip%div==0 && p%div==0){
		ip/=div;
		p/=div;
	    }
	    div++;
	}	
	System.out.println((int)ip);
    }

    public static void find2 (int[] x){
        BigInteger p = BigInteger.valueOf(1);
        BigInteger ip = BigInteger.valueOf(1);
	String ret = "";
	
	for (int i = 0; i < x.length; i++){
 	    p=p.multiply(BigInteger.valueOf((long)x[i]));
 	    ip=ip.multiply(BigInteger.valueOf((long)i+1));
	}

	BigInteger div=BigInteger.valueOf(2);
	BigInteger len=BigInteger.valueOf(x.length);

	while (div.compareTo(len) != 1){
	    if (ip.mod(div)==BigInteger.valueOf(0) && p.mod(div)==BigInteger.valueOf(0)){
		ip=ip.divide(div);
		p=p.divide(div);
	    }

	    div=div.add(BigInteger.valueOf(1));
	}

	ret+="The missing number is " + ip;
	System.out.println(ret);

    }
    

    public static void main (String[] args){
	int[] TomatoCale={6,3,5,4,5,2};
	find(TomatoCale);
	int[] carrots = {5, 3, 2, 4, 5};
	find(carrots);

	int[] mop = {1,2,2,4};
	find (mop);

	int[] crow = {1,2,3,3,4,5};
	find(crow);

	int[] cof ={6,2,10,27,49,21,5,16,34,50,31,2,11,38,14,25,28,36,12,1,3,43,22,40,4,44,7,17,18,29,41,8,33,19,46,9,45,20,13,23,24,42,39,30,15,35,26,32,37,47};
	find2(cof);
	    


    }




}
