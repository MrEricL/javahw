public class codingbat {

public int factorial(int n) {
    if (n==1) return 1;
    else return n * factorial(n-1);
}
public int bunnyEars(int bunnies) {
    if (n==0) return 0; //replace n with bunnies
    else if (n==1) return 2;
    else return 2+bunnyEars(bunnies-1);
}
public int fibonacci(int n) {
    if (n==0) return 0;
    else if (n==1) return 1;
    else return n + fibonacci(n-1);  
}



}
