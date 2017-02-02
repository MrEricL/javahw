public class MatrixFinder {

    public static boolean find( int[][] x, int y){
	int col=0;
	int row=x.length-1;
	int location = x[row][col];
	boolean bol=false;
	while (!bol && row >= 0 && col >= 0){
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
	System.out.println(find(bey,0));
	System.out.println(find(bey,7));
	System.out.println(find(bey,5));
	int[][] test = {
	    {1, 5, 8, 10, 13},
	    {3, 7, 9, 11, 15},
	    {6, 12, 13, 16, 17},
	    {11, 13, 15, 19, 21},
	    {14, 17, 18, 22, 30}
	};
	System.out.println(find(test,0));
	System.out.println(find(test,7));
	System.out.println(find(test,17));

    }
}
