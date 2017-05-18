/*
Eric L
APCS2 pd 3
HW #02: I Am Still Searching
2017-2-2


 */




public class MatrixFinder {

    public static boolean find( int[][] x, int y){
	int col=0;
	int row=x.length-1;
	int location = x[row][col];
	boolean bol=false;
	while (!bol && row >= 0 && col >= 0 && row < x.length && col < x.length){
	    location=x[row][col];
	    if (col==x.length-1 && row == 0 && location!=y) break;
	    if (location > y) row--;
	    else if (location < y) col++;
	    if (location == y){
		bol=true;
		break;
	    }
	}
	return bol;
    }

    public static void main (String[] args){
	int[][] bey = {
	    { 1,  3,  5 }, 
	    { 3,  7,  8 },
	    { 5, 12, 15 },
	};
	System.out.println(find(bey,0)); //f
	System.out.println(find(bey,7));//t
	System.out.println(find(bey,5));//t
	int[][] test = {
	    {1, 5, 8, 10, 13},
	    {3, 7, 9, 11, 15},
	    {6, 12, 13, 16, 17},
	    {11, 13, 15, 19, 21},
	    {14, 17, 18, 22, 30}
	};
	System.out.println(find(test,0));//f
	System.out.println(find(test,7));//t
	System.out.println(find(test,17));//t

	int [][] pes  = {
	    {-100, -80, -13, -6, 0},
	    {-99, -79, -10, 0, 16},
	    {-75, -1, 0, 53, 62},
	    {-70, 1, 2, 245, 1421},
	    {-10, 2, 3, 365, 1441}
	};
	System.out.println(find(pes,-1000));//f
	System.out.println(find(pes,-79));//t
	System.out.println(find(pes,20));//f
	
	int[][] momo = {
	    { 1, 8, 9, 16 },
	    { 3, 9, 11, 17 },
	    { 6, 10, 14, 20 },
	    { 8, 14, 16, 22 }
	};
	System.out.println(find(pes,22));//t
	System.out.println(find(pes,14));//t
	System.out.println(find(pes,1));//t	

    }
}
