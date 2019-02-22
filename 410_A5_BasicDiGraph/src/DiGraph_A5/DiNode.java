package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;


public class DiNode {
	long idNum;
	String label;
	long outCount;
	HashMap<String, DiEdge> outEdge;
	HashSet<String> inEdge;
	
	
	public DiNode(long idNum, String label) {
		this.idNum = idNum;
		this.label = label;
		this.outCount = 0;
		outEdge = new HashMap<String, DiEdge>();
		inEdge = new HashSet<String>();
	}
}
