package MinBinHeap_A3;

public class MinBinHeap_Playground {
  public static void main(String[] args){   
    //Add more tests as methods and call them here!!
//	  TestBuild();
	  mytest();
  }
  
  public static void TestBuild(){ 
    // constructs a new minbinheap, constructs an array of EntryPair, 
    // passes it into build function. Then print collection and heap.
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[8];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",5);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
    collection[5]=new EntryPair("f",5);
    collection[6]=new EntryPair("g",6);
    collection[7]=new EntryPair("h",17);
    mbh.build(collection);
    printHeapCollection(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    //this will print the entirety of an array of entry pairs you will pass 
    //to your build function.
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    //pass in mbh.getHeap(),mbh.size()... this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void mytest() {	  MinBinHeap mb = new MinBinHeap ();
	  EntryPair a = new EntryPair("a",4);
	  EntryPair b = new EntryPair("b",1);
	  EntryPair c = new EntryPair("c",2);
	  EntryPair d = new EntryPair("d",0);
	  EntryPair e = new EntryPair("e",3);
	  EntryPair f = new EntryPair("f",7);
	  EntryPair g = new EntryPair("g",0);
	  mb.insert(a);
	  mb.insert(b);
	  mb.insert(c);
	  printHeap(mb.array, mb.size);
	  mb.delMin();
	  printHeap(mb.array, mb.size);
	  mb.insert(d);
	  mb.insert(e);
	  mb.insert(f);
	  printHeap(mb.array, mb.size);
	  mb.delMin();
	  printHeap(mb.array, mb.size);
	  mb.insert(g);
	  printHeap(mb.array, mb.size);
//	  TestBuild();
//	  printHeap(mb.array, mb.size);
//	  System.out.println(mb.array[0].priority);
  }
  
} 