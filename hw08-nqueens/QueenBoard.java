/***
Eric Li
APCS2 pd 3
Hw 8 - [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
2017-2-26

 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */

public class QueenBoard 
{
    //2D array to represent n*n chessboard
    private int[][] _board;
    private int fail=0;

    //constructor allows for specifying size
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
	for (int i =0 ; i < _board.length; i++){
	    for (int j=0; j < _board[i].length; j++){
		_board[i][j]=0;
	    }
	}

	//	go();
	solve();
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * Program starts on the first colum and moves leftwards testing for spots where a queen can be placed. Spots that cannot be placed will be marked off. If n-number of queens can be place, than the solution is true. Otherwise it is false.
     */
    public boolean solve()
    {
	if (solveH(0)) return true; //start it at the first col
	
	for (int[] x: _board){
	    for (int y: x){
		x[y] = 0;
	    }

	}

	return false;
    }

    /* BETA Version of solveH
    public void go(){
	for (int i = 0; i < _board.length; i++){
	    for (int j = 0; j < _board[0].length; j++){
		if (_board[i][j] == 0 ){
		    addQueen(i,j);
		    toP(_board);
		    System.out.println();
		}
		
	    }
	}

	}*/

    
    private boolean solveH( int col ) 
    {
	for (int i = 0; i < _board.length; i++){
	    if (_board[i][col] == 0){ //checks the space
		addQueen(i,col); //places da queen
		if (col == _board.length -1 || solveH(col +1)) return true;            
		removeQueen(i, col);
	    }
	}
	return false;
	
    }


    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/

	String[][] x = new String[_board.length][_board[0].length];

	for (int i = 0; i < _board.length ; i ++){
	    for (int y =0; y < _board[i].length; y++){
		if (_board[i][y] > 0) x[i][y] = "Q";
		else x[i][y] = "_";
	    }
	}
	toP(x);
	System.out.println();
	
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Places queen on the spot and tells you if its allowed
     * precondition: Legitimate coordinates
     * postcondition: True with the queen added and spaces marked off, false if queen cannot be put there
     */
    private boolean addQueen(int row, int col)
    {
	// Where a queen cannot be placed
	if(_board[row][col] != 0){
	    return false;
	}

	// Places down the queen
	_board[row][col] = 1;

	// Helps determine range of queen- the distance to be placed
	int offset = 1;

	// Marks off range with negative
	while(col+offset < _board[row].length) {
	    // Marks off square next (left) of queen
	    _board[row][col+offset]--;

	    // Makes sure that its within the board size, than uses it to find the diagonals
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // increases offset for all the possibilities
	    offset++;
	}

	return true;
    }


    /***
     * Removes a queen from the following coordinate along with all it's blocked spaces
     * precondition: Coordinates are legitimate ie no 9,9 on a 5X5 board
     * postcondition: True if the program works, false if there is no queen to be removed
     */
    private boolean removeQueen(int row, int col)
    {
	// checks for queen
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// sets the queen
	int offset = 1;	        // used to help account for the extra col- useful for marking off spots

	// Uses offset to calculate and remove the queen's range
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * Tostring
     * precondition: Printing out a int[][]
     * postcondition: Prints it out
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    public void toP(String[][] x) 
    {
	for( int r = 0; r < x.length; r++ ) {
	    for( int c = 0; c < x[0].length; c++ ) {
		System.out.print(x[r][c]+"\t");
	    }
	    System.out.println();
	}
    }

    public void toP(int[][] x) 
    {
	for( int r = 0; r < x.length; r++ ) {
	    for( int c = 0; c < x[0].length; c++ ) {
		System.out.print(x[r][c]+"\t");
	    }
	    System.out.println();
	}
    }    

    //main method for testing...
    public static void main( String[] args )
    {
	System.out.println("\n\n---------------------------------");

	QueenBoard test = new QueenBoard(3);
	test.printSolution();
	System.out.println("---------------------------------");
	QueenBoard test2 = new QueenBoard(8);
	test2.printSolution();
	System.out.println("---------------------------------");
	QueenBoard test3 = new QueenBoard(6);
	test3.printSolution();	
	System.out.println("---------------------------------\n\n");
	/*
	*/
    }//end main()
    
}//end class
