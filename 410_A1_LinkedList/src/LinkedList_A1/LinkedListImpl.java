/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

@Override
public boolean insert(double elt, int index) {
	Node curr = sentinel;
	Node temp = new Node(elt);
	int size = size();
	if (index > size || index < 0) {
		return false;
	}
	else if (size == 0) {	//insert the 1st cell to empty list
		temp.prev = temp.next = sentinel;
		sentinel.prev = sentinel.next = temp;
		return true;
	} 
	else { 
		if (index < size) { //append the cell in the middle
			for (int ct = 0; ct <= index; ct ++) {
				curr = curr.next;
			}
		}
		curr.prev.next = temp;
		temp.prev = curr.prev;
		temp.next = curr;
		curr.prev = temp;
		return true;
	}
}
	
/*
   if (index == size()) {
		temp.prev = sentinel.prev;
		temp.next = sentinel;
		sentinel.next=sentinel.prev = temp;
		return true;
	}
	else if (index >= 0 && index < size()) {
		for (int ct = 0; ct <= index; ct ++) {
			curr = curr.next;
		}
		temp.prev = curr.prev;
		temp.next = curr;
		curr.prev = temp;
		return true;
	}
	else {
		return false;
	}
}
*/
@Override
public boolean remove(int index) {
	Node curr = sentinel;
	if (index >= 0 && index == size()-1) {
		sentinel.prev.prev.next = sentinel;	//link the new end to sentinel
		sentinel.prev = sentinel.prev.prev;	//link the sentinel to the new end
		return true;
	}
	else if (index >= 0 && index < size()-1) {
		for (int ct = 0; ct <= index; ct++) {
			curr =curr.next;
		}
		curr.prev.next = curr.next;
		curr.next.prev = curr.prev;
		return true;
	}
	else {
	return false;
	}
}

@Override
public double get(int index) {
	if (index >= 0 && index < size()) {
		Node curr = sentinel;
		for (int ct = 0; ct <= index; ct ++) {
			curr = curr.next;
		}
		return curr.data;
	}
	else {
		return Double.NaN;
	}
}

@Override
public int size() {
	int size = 0;
	Node curr = sentinel;
	if (sentinel.next != null){		//new sentinel cell doesnt point to itself
		while (curr.next != sentinel) {
			size += 1;
			curr = curr.next;
		}
	}
	return size;
}

@Override
public boolean isEmpty() {
	if (size() == 0) {
		return true;
	}
	return false;
}

@Override
public void clear() {
	if (size() != 0) {
	sentinel.next = sentinel;
	sentinel.prev = sentinel;
	}
}
}

