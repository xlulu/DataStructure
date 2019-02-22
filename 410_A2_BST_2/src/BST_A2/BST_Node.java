package BST_A2;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node parent;
  
  BST_Node(String data){ this.data=data; }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- fill in these methods ------------------------------------------
  //
  // at the moment, they are stubs returning false 
  // or some appropriate "fake" value
  //
  // you make them work properly
  // add the meat of correct implementation logic to them

  // you MAY change the signatures if you wish...
  // make the take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public boolean containsNode(String s) { 
	//data=s: rt=0; data>s, rt>0; data<s, rt<0
	  if (this.data.compareTo(s) == 0) {
		  return true; //found it
	  }
	  else if (this.data.compareTo(s) > 0) {
		  //data>s, s might be in left sub tree of current node
		  if (this.left == null) {return false;}
		  else {return this.left.containsNode(s);}			  
	  }
	  else {
		  //s might be in right sub tree of current node
		  if (this.right == null) {return false;}
		  else {return this.right.containsNode(s);}
	  } 
  }
  
  
  public boolean insertNode(String s) { 
	//found it
	  if (this.data.compareTo(s) == 0) {
		  return false;
	  }
	  // data > s, insert in the left subtree
	  else if (this.data.compareTo(s) > 0) {
		  //insert in the left subtree
		  if (this.left == null) {
			 this.left = new BST_Node(s);
			 this.left.parent = this;
			 return true;
		  }
		  else {return this.left.insertNode(s);}
	  }
	  else {
		  //data<s, insert in the right subtree
		  if (this.right == null) {
			  this.right = new BST_Node(s);
			  this.right.parent = this;
			  return true;
		  }
		  else {return this.right.insertNode(s);}
	  } 
  }
  
  
  // make sure after remove the parent points to the correct node!!!!
  public boolean removeNode(String s) { 
	//check whether the node is in the tree
	  if (this.containsNode(s) == false) {
		  return false;
	  }
	 //if s > node, go to right subtree
	  if (this.data.compareTo(s) < 0) {
		  return this.right.removeNode(s);
	  }
	  //if s < node, go to left subtree
	  else if (this.data.compareTo(s) > 0) {
		  return this.left.removeNode(s);
	  }
	  //find the node
	  else {
		//if the node has two children
		  //replace the data of the node to be deleted
		  if (this.left != null && this.right != null) {
			  this.data = this.right.findMin().data;
			  if (this.right.left == null) {
				  this.right = null;
			  }
			  else {
				  this.right.findMin().parent.left = null;
			  }
			//  this.right.findMin().parent.left = null;
			  	//return removeNode(this.right.findMin().data);
		  }
		  //if the node has no children
		  else if (this.left == null && this.right == null) {
			  //the node is on the left of its parent
			  if (this == this.parent.left) {
				  this.parent.left = null;
			  }
			  //the node is on the right of its parent
			  else {
				  this.parent.right =null;
			  }
		  }
		  // Or if the node has only left child
		  else if (this.right == null ) {
			  // the node is on the left of its parent
			  if (this == this.parent.left) {
				  this.parent.left = this.left;
				  this.left.parent = this.parent;
			  }
			  // the node is on the right of its parent
			  else {
				  this.parent.right = this.left;
				  this.left.parent = this.parent;
			  }
		  }
		  //if the node has only right child
		  else {
			// the node is on the left of its parent
			  if (this == this.parent.left) {
				  this.parent.left = this.right;
				  //rem_test7
                  this.right.parent = this.parent;
			  }
			  // the node is on the right of its parent
			  else {
				  this.parent.right = this.right;
				  this.right.parent = this.parent;
			  }
		  } 
		  return true;
	  }
	  
  }
  
  
  public BST_Node findMin() { 
	//the most left node
	  if (this.left == null) {
		  return this;
	  }
	  else {
		  return this.left.findMin();
	  } 
  }
  
  
  public BST_Node findMax() { 
	//the most right node
	  if (this.right == null) {
		  return this;
	  }
	  else {
		  return this.right.findMax();
	  } 
  }
  
  public int getHeight() { 
	//both children are not null
	  if (this.left != null && this.right != null) {
 		 return (1 + Math.max(this.left.getHeight(),this.right.getHeight()));
	  }
	  //only has left child
	  else if (this.left != null && this.right == null) {
		  return (1 + left.getHeight());
	  }
	  //only has right child
	  else if (this.left == null && this.right != null) {
		  return (1 + right.getHeight());
	  }
	  //has no children
	  else {
		  return 0;
	  } 
  }
  
  
  // --- end fill in these methods --------------------------------------


  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  public String toString(){
    return "Data: "+this.data+", Left: "+((this.left!=null)?left.data:"null")
            +",Right: "+((this.right!=null)?right.data:"null");
  }
}
