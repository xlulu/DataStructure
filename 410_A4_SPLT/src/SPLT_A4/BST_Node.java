package SPLT_A4;

public class BST_Node {
  String data;
  BST_Node left;
  BST_Node right;
  BST_Node par; //parent...not necessarily required, but can be useful in splay tree
  boolean justMade; //could be helpful if you change some of the return types on your BST_Node insert.
            //I personally use it to indicate to my SPLT insert whether or not we increment size.
  
  BST_Node(String data){ 
    this.data=data;
    this.justMade=true;
  }
  
  BST_Node(String data, BST_Node left,BST_Node right,BST_Node par){ //feel free to modify this constructor to suit your needs
    this.data=data;
    this.left=left;
    this.right=right;
    this.par=par;
    this.justMade=true;
  }

  // --- used for testing  ----------------------------------------------
  //
  // leave these 3 methods in, as is (meaning also make sure they do in fact return data,left,right respectively)

  public String getData(){ return data; }
  public BST_Node getLeft(){ return left; }
  public BST_Node getRight(){ return right; }

  // --- end used for testing -------------------------------------------

  
  // --- Some example methods that could be helpful ------------------------------------------
  //
  // add the meat of correct implementation logic to them if you wish

  // you MAY change the signatures if you wish...names too (we will not grade on delegation for this assignment)
  // make them take more or different parameters
  // have them return different types
  //
  // you may use recursive or iterative implementations

  
  public BST_Node containsNode(String s){ //if found, return it; return the last node reached
		//data=s: rt=0; data>s, rt>0; data<s, rt<0
	  if (this.data.compareTo(s) == 0) {
		  return this; //found it
	  }
	  else if (this.data.compareTo(s) > 0) {
		  //data>s, s might be in left sub tree of current node
		  if (this.left == null) {return this;} //used to: null
		  else {return this.left.containsNode(s);}			  
	  }
	  else {
		  //s might be in right sub tree of current node
		  if (this.right == null) {return this;} //used to: null
		  else {return this.right.containsNode(s);}
	  } 
  } //note: I personally find it easiest to make this return a Node,(that being the node splayed to root), you are however free to do what you wish.
 
  
  public BST_Node insertNode(String s){
	  //found it, not insert
	  if (this.data.compareTo(s) == 0) {return null;}
	  // data > s, insert in the left subtree
	  else if (this.data.compareTo(s) > 0) {
		  //insert in the left subtree
		  if (this.left == null) {
			 this.left = new BST_Node(s);
			 this.left.par = this;
			 return this.left; //not sure????
		  }
		  else {return this.left.insertNode(s);}
	  }
	  else {
		  //data<s, insert in the right subtree
		  if (this.right == null) {
			  this.right = new BST_Node(s);
			  this.right.par = this; 
			  return this.right;
		  }
		  else {return this.right.insertNode(s);}
	  } 
  } //Really same logic as above note
  
  
  public BST_Node findMin(){
		//the most left node
	  if (this.left == null) {
		  return this;
	  }
	  return this.left.findMin();
  } 
  
  public BST_Node findMax(){
		//the most right node
	  if (this.right == null) {
		  return this;
	  }
	  return this.right.findMax();
  }
  
  
  public int getHeight(){
	  int l = 0;
	  int r = 0;
	  if (this.left != null) {l+= left.getHeight()+1;}
	  if (this.right != null) {r+= right.getHeight()+1;} 
	  return Integer.max(l, r);
  }

  public void splay_right(BST_Node toSplay) { //basic splay rotation
	  if (toSplay.par.par != null) {
		  BST_Node temp = toSplay.par.par;
		  if (temp.left == toSplay.par) {temp.left = toSplay;}
		  else {temp.right = toSplay;}
	  }
	  toSplay.par.right = toSplay.left;
	  toSplay.left = toSplay.par;
	  toSplay.par = toSplay.par.par;
	  toSplay.left.par = toSplay;
	  if (toSplay.left.right != null) toSplay.left.right.par = toSplay.left;//new added
  }
  
  public void splay_left(BST_Node toSplay) { //basic splay rotation
	  if (toSplay.par.par != null) {
		  BST_Node temp = toSplay.par.par;
		  if (temp.left == toSplay.par) {temp.left = toSplay;}
		  else {temp.right = toSplay;}
	  }
	  toSplay.par.left = toSplay.right;
	  toSplay.right = toSplay.par;
	  toSplay.par = toSplay.par.par;
	  toSplay.right.par = toSplay;
	  if (toSplay.right.left != null) toSplay.right.left.par = toSplay.right;//new added
  }
  
  public BST_Node splay(BST_Node toSplay) {
	  if (toSplay.par == null) {return toSplay;} //no parent
	  else if (toSplay.par.par == null) { //with parent, no grandparent
		  if (toSplay.par.left == toSplay) splay_left(toSplay);
		  else splay_right(toSplay);
		  return toSplay;
	  }
	  else { //with grandparent
		  if (toSplay.par.left == toSplay) { //toS is left child
			  if (toSplay.par.par.left == toSplay.par) { //LL
				  splay_left(toSplay.par);
				  splay_left(toSplay);
			  }
			  else { //LR
				  splay_left(toSplay);
				  splay_right(toSplay);
			  }
		  }
		  else { //toS is right child
			  if (toSplay.par.par.right == toSplay.par) { //RR
				  splay_right(toSplay.par);
				  splay_right(toSplay);
			  }
			  else { //RL
				  splay_right(toSplay);
				  splay_left(toSplay);
			  }
		  }
		  return splay(toSplay);		  
	  }	  
  } //you could have this return or take in whatever you want..so long as it will do the job internally. As a caller of SPLT functions, I should really have no idea if you are "splaying or not"
                        //I of course, will be checking with tests and by eye to make sure you are indeed splaying
                        //Pro tip: Making individual methods for rotateLeft and rotateRight might be a good idea!
  

  // --- end example methods --------------------------------------

  
  

  // --------------------------------------------------------------------
  // you may add any other methods you want to get the job done
  // --------------------------------------------------------------------
  
  
}
