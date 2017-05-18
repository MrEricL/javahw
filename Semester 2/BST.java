/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{
    //instance variables / attributes of a BST:
    TreeNode tree;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	tree = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal )	
    {
	TreeNode temp=new TreeNode(newVal);
	if (tree==null){
	    tree=temp;
	    return;
	}
	else{
    
	    TreeNode temp = tree;
	    while (true){
		if (newVal.compareTo(temp.getValue()) < 0){
		    if (temp.getLeft()==null){
			temp.setLeft(new TreeNode (newVal));
			return;
		    }
		    else{
			temp.getLeft();
		    }
		}
		else{
		    if (temp.getRight()==null){
			temp.setRight(new TreeNode (newVal));
			return;
		    }
		    else{
			temp.getRight();
		    }
		}
		


	    }
	}
    }
    
    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
    	TreeNode temp = tree;

	while (true){
	    if (target==temp.getValue()) return temp;
	    else if (isLeaf(temp)) break;
	    else{
		if (target > temp.getValue()) temp=temp.getRight();
		else temp=temp.getLeft();
	    }

	}

	return null;
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
    }

    public int heightHelper(TreeNode node){
	if (isLeaf(node)) return 1;
	else{

	    return preH(tree);
	}


    }


    public int preH( TreeNode r){
	int l;
	int r;
        if (r!= null){
	    l=preH(r.getLeft());
	    r=preH(r.getRight());
	    if (l > r) return l+1;
	    else return r+1;

	}
	else return 0;

    }   


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
	return numLeavesHelper(tree);
    }

    public int numLeavesHelper(TreeNode node){
	if (isLeaf(node)) return 1;
	else {

	    return numLeavesHelper(node.getLeft()) + numLeavesHelper(node.getRight());
	}

    }

    public boolean isLeaf(TreeNode node){
	if (node.getLeft()==null && node.getRight()==null) return true;
	else return false;

    }




    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
	preHelper(tree);
    }


    public void preHelper( TreeNode r){
        if (r!= null){
	    System.out.print(" " + r.getValue());
	    preHelper(r.getLeft());
	    preHelper(r.getRight());

	}

    }

    public void inOrderTrav() 
    {
	inHelper(tree);
    }

   public void inHelper( TreeNode r){
        if (r!= null){

	    inHelper(r.getLeft());
	    System.out.print(" " + r.getValue());	    
	    inHelper(r.getRight());

	}
   }




    public void postOrderTrav() 
    {
	postHelper(tree);
    }



    public void postHelper(TreeNode r){
        if (r!= null){

	    postHelper(r.getLeft());    
	    postHelper(r.getRight());
	    System.out.print(" " + r.getValue());
	}


    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav();

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav();
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav();	

	  System.out.println(arbol.height);
	  System.out.println(arbol.numLeaves());
	  System.out.println(arbol.search(3));
	  System.out.println(arbol.search(0));	  	  
    }

}//end class
