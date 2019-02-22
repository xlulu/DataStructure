package SPLT_A4;

public class SPLT implements SPLT_Interface{
  private BST_Node root;
  private int size;
  
  public SPLT() {
    this.size = 0;
  } 
  
  public BST_Node getRoot() { //please keep this in here! I need your root node to test your tree!
    return root;
  }

@Override
public void insert(String s) {
	if (size == 0) {
		root = new BST_Node(s);
		root.par = null;
		size += 1;
	}
	else {
		if (! root.containsNode(s).getData().equals(s)) { //node with s not exist
			root = root.splay(root.insertNode(s)); //insert successfully
			size += 1;
		}
		else root = root.splay(root.containsNode(s)); //node with s exists
	}	
}

@Override
public void remove(String s) {
	if (contains(s)) { //node with s moved to the root
		size -= 1;
		if (root.left == null) {
			if (root.right == null) root = null; //root with no children
			else { //root with only right child
				root = root.right;
				root.par = null;
			} 
		}
		else {
			if (root.right == null) { //root with only left child
				root = root.left;
				root.par = null;
			} 
			else { //root with both children
				root.data = root.left.findMax().data;
				if (root.left.right == null) {
					root.left = root.left.left;
					if (root.left != null) root.left.par = root;
				}
				else {
					root.left.findMax().par.right = root.left.findMax().left;
					if (root.left.findMax().left != null) root.left.findMax().left.par = root.left.findMax();
				}
			}
		}	
	}
}


@Override
public String findMin() {
	if (size == 0) {return null;}
	root = root.splay(root.findMin());
	return root.data;
}

@Override
public String findMax() {
	if (size == 0) {return null;}
	root = root.splay(root.findMax());
	return root.data;
}

@Override
public boolean empty() {
	if (size == 0) {return true;}
	return false;
}

@Override
public boolean contains(String s) {
	if (size == 0) {return false;}
	if (root.containsNode(s).getData().equals(s)) {
		root = root.splay(root.containsNode(s));
		return true;
	}
	root = root.splay(root.containsNode(s));
	return false;
}

@Override
public int size() {
	return size;
}

@Override
public int height() {
	if (size == 0) {return -1;}
	else {return root.getHeight();}
}  
}