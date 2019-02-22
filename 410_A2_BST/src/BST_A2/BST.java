package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size;
  
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

@Override
public boolean insert(String s) {
	// TODO Auto-generated method stub
	if (root.insertNode(s) == true) {
		size += 1;
		//make sure the root's parent is null, better for remove and insert
		if (size == 1) {
			root.parent = null;
		}
	} 
	return root.insertNode(s);
}

@Override
public boolean remove(String s) {
	// TODO Auto-generated method stub
	if (size == 0) {return false;}
	else {
		if (root.removeNode(s) == true) {
			size -= 1;
		}
		return root.removeNode(s);
	}
		
}

@Override
public String findMin() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	}
	else {
		return this.findMin();
	}
}

@Override
public String findMax() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	}
	else {
		return this.findMax();  //??? root or this?
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
	if (root == null) {
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
	if (root == null) {
		return -1;
	}
	else {
		return root.getHeight();
	}
}

}
