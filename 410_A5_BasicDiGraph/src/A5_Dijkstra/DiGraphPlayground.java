package A5_Dijkstra;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      //exTest();
	  milTest();
//	  shortestTest2();
//	  shortestTest4();
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(1, "f");
      d.addNode(3, "s");
      d.addNode(7, "t");
      d.addNode(0, "fo");
      d.addNode(4, "fi");
      d.addNode(6, "si");
      d.addEdge(0, "f", "s", 0, null);
      d.addEdge(0, "f", "si", 0, null);
      d.addEdge(2, "s", "t", 0, null);
      d.addEdge(3, "fo", "fi", 0, null);
      d.addEdge(4, "fi", "si", 0, null);
//      d.delEdge("fo", "fi");
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
//      d.delNode("si");
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
    }
    
    public static void milTest(){
    	DiGraph d = new DiGraph();
    	for (long i=0;i<1000000; i++) {
    		d.addNode(i, Long.toString(i));
    		if (i >0) {d.addEdge(i, Long.toString(i-1), Long.toString(i), 0, null);}
    	}
    	d.shortestPath("0");
    	System.out.println("numEdges: "+d.numEdges());
    	System.out.println("numNodes: "+d.numNodes());
    }
   
    public static void shortestTest4() {
    	DiGraph d = new DiGraph();
    d.addNode(0, "1");
    d.addNode(1, "2");
    d.addNode(2, "3");
    d.addNode(3, "4");
    d.addNode(4, "5");
    d.addNode(5, "6");
    d.addEdge(0, "4", "5",2, null);
    d.addEdge(1, "0", "5",3, null);
    d.addEdge(2, "3", "2",6, null);
    d.addEdge(3, "6", "1",4, null);
    d.addEdge(4, "4", "0",1, null);
    	ShortestPathInfo[] sPath = d.shortestPath("0");
    	for (int i=0; i<6; i++) {System.out.println(sPath[i].toString());}
    }
    
    public static void shortestTest3() {
    	DiGraph d = new DiGraph();
    d.addNode(0, "a");
    d.addNode(1, "p");
    d.addNode(2, "g");
    d.addNode(3, "e");
    d.addEdge(0, "p", "a",10, null);
    d.addEdge(1, "a", "g",12, null);
    d.addEdge(2, "g", "e",1, null);
    d.addEdge(3, "e", "p",6, null);
    d.addEdge(4, "p", "g",4, null);
    d.addEdge(5, "a", "e",100, null);
    d.addEdge(6, "a", "p",9, null);
    d.addEdge(7, "e", "a",3, null);
    d.addEdge(8, "g", "a",15, null);
    d.addEdge(9, "p", "e",8, null);
    d.addEdge(10, "g", "p",2, null);
    	ShortestPathInfo[] sPath = d.shortestPath("p");
    	for (int i=0; i<4; i++) {System.out.println(sPath[i].toString());}
    }
    public static void shortestTest2() {
    	DiGraph d = new DiGraph();
    d.addNode(0, "a");
    d.addNode(1, "b");
    d.addNode(2, "c");
    d.addNode(3, "d");
    d.addEdge(0, "a", "b",1, null);
    d.addEdge(1, "b", "c",2, null);
    d.addEdge(2, "c", "a",3, null);
    d.addEdge(3, "c", "d",2, null);
    d.addEdge(4, "d", "b",2, null);
    	ShortestPathInfo[] sPath = d.shortestPath("a");
    	for (int i=0; i<4; i++) {System.out.println(sPath[i].toString());}
    }
    
    
}