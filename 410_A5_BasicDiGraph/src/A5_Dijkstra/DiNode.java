package A5_Dijkstra;

import java.util.HashMap;
import java.util.HashSet;


public class DiNode implements Comparable<DiNode>{
	long idNum;
	String label;
	long outCount;
	long totalWeight;
	boolean known;
	HashMap<String, DiEdge> outEdge;
	HashSet<Long> outEdgeId;
	HashSet<String> inEdge;
	
	
	public DiNode(long idNum, String label) {
		this.idNum = idNum;
		this.label = label;
		this.outCount = 0;
		this.known = false;
		this.totalWeight = -1;
		outEdge = new HashMap<String, DiEdge>();
		outEdgeId = new HashSet<Long>();
		inEdge = new HashSet<String>();
	}
	@Override
	public int compareTo(DiNode other) {
		if (this.totalWeight == other.totalWeight) return 0;
		else if (this.totalWeight > other.totalWeight) return 1;
		else return -1;
	}
}
