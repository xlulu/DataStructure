package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  
  
  @Override
public boolean insert(String s) {
	// TODO Auto-generated method stub
	//make sure the root's parent is null, better for remove and insert  
	  if (size == 0) {
		  root = new BST_Node(s);
		  root.parent = null;
		  size += 1;
		  return true;
	  }
	  else {
		  if (root.insertNode(s) == true) {
			  size += 1;
			  return true;
		  }
		  else {
			  return false;
		  }
		}	
}



@Override
public boolean remove(String s) {
	// TODO Auto-generated method stub
	if (size == 0) {return false;}
	//root will be removed
	else if (root.data == s) {
		//root with only left child
		if (root.left != null && root.right == null){
			//root.left.parent = null;
			root = root.left;
			root.parent = null;
		}
		//root with only right child
		else if (root.left == null && root.right != null) {
			//root.right.parent = null;
			root = root.right;
			root.parent = null;
		}
		//root with no children
		else if (size == 1) {
			root = null;
		}
		//root with both children is only replaced by value, so not to consider
		else {
			root.removeNode(s);
		}
		size -= 1;
		return true;
	}
	else {
		if (root.removeNode(s) == true) {
			size -= 1;
			return true;
		}
		else {
			return false;
		}
	}
}



@Override
public String findMin() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	}
	else {
		return root.findMin().data;
	}
}



@Override
public String findMax() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	}
	else {
		return root.findMax().data;  //??? root or this?
	}
}



@Override
public boolean empty() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return true;
	}
	else {
		return false;
	}
}



@Override
public boolean contains(String s) {
	// TODO Auto-generated method stub
	if (size == 0) {
		return false;
	}
	else {
		return root.containsNode(s);
	}
}



@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}



@Override
public int height() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return -1;
	}
	else {
		return root.getHeight();
	}
}



@Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

}
