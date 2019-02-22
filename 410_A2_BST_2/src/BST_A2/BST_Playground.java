package BST_A2;

public class BST_Playground {
/*
 * you will test your own BST implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create BST objects,
 * put data into them, take data out, look for values stored
 * in it, checking size and height, and looking at the BST_Nodes
 * to see if they are all linked up correctly for a BST
 * 
*/
  
  public static void main(String[]args){

   // you should test your BST implementation in here
   // it is up to you to test it thoroughly and make sure
   // the methods behave as requested above in the interface
  
   // do not simple depend on the oracle test we will give
   // use the oracle tests as a way of checking AFTER you have done
   // your own testing

   // one thing you might find useful for debugging is a print tree method
   // feel free to use the printLevelOrder method to verify your trees manually
   // or write one you like better
   // you may wish to print not only the node value, and indicators of what
   // nodes are the left and right subtree roots,
   // but also which node is the parent of the current node
	  
	  //test1();
//	  myTest();
 
  }
  
/*  public static void myTest() {
		int a = 5;
		int b = 2;
		int c = a / b;
		System.out.print(c) ;	
	}
*/

  static void printLevelOrder(BST tree){ 
  //will print your current tree in Level-Order...
  //https://en.wikipedia.org/wiki/Tree_traversal
    int h=tree.getRoot().getHeight();
    for(int i=0;i<=h;i++){
      printGivenLevel(tree.getRoot(), i);
    }
    
  }
  static void printGivenLevel(BST_Node root,int level){
    if(root==null)return;
    if(level==0)System.out.print(root.data+" ");
    else if(level>0){
      printGivenLevel(root.left,level-1);
      printGivenLevel(root.right,level-1);
    }
  }
  static void printInOrder(BST_Node root){
  //will print your current tree In-Order
  if(root!=null){
    printInOrder(root.getLeft());
    System.out.print(root.getData() + " ");
    printInOrder(root.getRight());
  }
  }
  
  
  
  //my test
  static String a = "a";
  static String b = "b";
  static String c = "c";
  static String d = "d";
  static String e = "e";
  static String f = "f";
  public static void test1() {
	  BST b1 = new BST();
	  //System.out.println(b1.size); //0
	  //System.out.println(b1.empty()); //true
	  b1.insert("0");
	  b1.insert("c");
	  b1.insert("a");
	  b1.insert("b");
	  b1.insert("e");
	  b1.insert("d");
	  b1.remove("c");
	  b1.remove("a");
	  b1.remove("d");
	  b1.remove("b");
	  b1.remove("e");
	
	 
	  
	   /* 
	  b1.insert(f);
	  b1.insert(a);	
	  b1.insert(e);	
	  */
	  //System.out.println(b1.contains(c)); //true

	  //b1.remove(b);
	  
	  //System.out.println(b1.root.parent);
	  //System.out.println(b1.root.right);
	  //b1.remove(a);
	  System.out.println(b1.contains(c)); //false
	  //System.out.println(b1.size);//1
	  //printInOrder(b1.root);
	 
	  //b1.insert(d);
	  //b1.remove(d);
	  
	  //System.out.println(b1.findMax()); //f
	  //System.out.println(b1.findMin()); //a
	  //System.out.println(b1.size); //5
	  
	  //System.out.println(b1.height()); //2
	
	  
	  System.out.println(b1.root);
	  printInOrder(b1.root);

	  //ystem.out.println(b1.size); //4
	  //b1.remove(a);
	  //System.out.println(b1.contains(b)); //false
	  //System.out.println(b1.size); //4
	  /*
	  System.out.println(b1.height());
	  System.out.println(b1.findMax());
	  System.out.println(b1.findMin());
	  printInOrder(b1.root);
	  */	  
  }
  
}



