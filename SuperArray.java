public class SuperArray{

    public static void add (byte[] a, int n){
	byte[] b = new byte[a.length+n];
	for (int i=0; i < b.length; i++){
	    if (i < a.length) b[i]=a[i];
	}
	a=b;
    }
    public static void main (String[] args){
	byte [] a = {1,2,3,4};
	add(a,10);

    }
}


