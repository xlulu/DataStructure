package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
	   EntryPair[] array; //load this array
	   int size;
	  private static final int arraySize = 10000; //Everything in the array will initially 
	                                              //be null. This is ok! Just build out 
	                                              //from array[1]

	  public MinBinHeap() {
	    this.array = new EntryPair[arraySize];
	    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
	                                             //of child/parent computations...
	                                             //the book/animation page both do this.
	    size = 0;
	  }
	    
	  //Please do not remove or modify this method! Used to test your entire Heap.
	  @Override
	  public EntryPair[] getHeap() { 
	    return this.array;
	  }


//EntryPair on array[i] bubble down to proper location, meet the order requirement
 public void bubble_down(int i) {
//	 EntryPair temp = array[i];
	 while (2*i+1 <= size) { //i has both children
		 if (array[2*i+1].priority > array[2*i].priority) { //if right is greater than left: [2i+1]>[2i]
			 if (array[i].priority > array[2*i].priority) { //if parent is greater than left
				 EntryPair temp1 = array[i];
				 array[i] = array[2*i];
				 array[2*i] = temp1;
				 i = 2 * 1;
			 }
			 else { 
				 break;
			 }
		 }
		 else { // if left is greater than right: [2i]>[2i+1]
			 if (array[i].priority > array[2*i+1].priority) { //if parent is greater than right
				 EntryPair temp2 = array[i];
				 array[i] = array[2*i+1];
				 array[2*i+1] = temp2;
				 i = 2 * 1 + 1;
			 }
			 else {
				 break;
			 }
		 }
	 }
//	 array[i] = temp;
	 if ((size-1)/2 < size/2) { //if size is even number, only has left child
		 						//i.e.the last one node is a single child
		 if (array[size].priority < array[size/2].priority) {
			 EntryPair e = array[size];
			 array[size] = array[size/2];
			 array[size/2] = e;
		 }
	 }
 }
  
  @Override
public void insert(EntryPair entry) {
	// TODO Auto-generated method stub    //problem: think about only has one or two!!!!!!!!!
	  int i = size + 1;
//	  System.out.print(i);
	  while (i > 1) { //have parent
		  if (entry.priority < array[i/2].priority) { //entry value less than its parent
			  array[i] = array[i/2]; //child to replace the parent
			  i = i/2; //index go up one level
		  }
		  else {
			  break;
		  }
	  }	  
	  array[i] = entry;
	  size += 1;
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	if (size > 1) {
		array[1] = array[size];
		array[size] = null;
		size -= 1;
		this.bubble_down(1);
	}
	else if (size == 1){
		array[1] = null;
		size -= 1;
	}
}

@Override
public EntryPair getMin() {
	// TODO Auto-generated method stub
	if (size == 0) {
		return null;
	}
	else {
		return array[1];
	}
}

@Override
public int size() {
	// TODO Auto-generated method stub
	return size;
}

@Override
public void build(EntryPair[] entries) {
	// TODO Auto-generated method stub
	// how to compare whether entries is null?
	size = entries.length;
	int i;
	for (i=0; i < entries.length; i++) {
		array[i+1] = entries[i];
	}	
	i = entries.length/2;
	for (i=entries.length/2; i>0; i--) {
//		System.out.println(i);
		bubble_down(i);
	}
}
	
}
  

  