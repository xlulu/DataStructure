package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;

public class DiGraph implements DiGraphInterface {
	int nodeNum;
	int edgeNum;
	HashMap<String, DiNode> nodes;
	HashSet<Long> ids;
	
  // in here go all your data and methods for the graph

  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	  nodeNum = 0;
	  edgeNum = 0; 
	  nodes = new HashMap<String, DiNode>();
	  ids = new HashSet<Long>(); //all idNums of nodes in graph
  }

@Override
public boolean addNode(long idNum, String label) {
	if (idNum < 0) return false;
	if (label == null) return false;
	if (nodes.containsKey(label) 
			|| ids.contains(idNum)) return false; // label or idNum not unique
	nodes.put(label, new DiNode(idNum, label));
	ids.add(idNum);
	this.nodeNum += 1;
	return true;
}

@Override
public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	// TODO Auto-generated method stub
	//DiEdge tempEdge = new DiEdge(idNum, sLabel, dLabel, weight, eLabel);
	DiNode temp;
	if (idNum < 0) return false; //idNum equal or greater than 0
	if (nodes.containsKey(sLabel)) {temp = nodes.get(sLabel);}
	else return false; //the source node not exist
//	if(! nodes.containsKey(dLabel)) return false; //the destination nodes not exist
	if (temp.outEdge.containsKey(dLabel)) return false; //the edge already exist
	else {
		temp.outEdge.put(dLabel, new DiEdge(idNum, sLabel, dLabel, weight, eLabel));
		nodes.get(dLabel).inEdge.add(sLabel);
		temp.outCount +=1;
		this.edgeNum += 1;
		return true;
	}
}

@Override
public boolean delNode(String label) {
	if (nodes.containsKey(label)) {
		DiNode temp = nodes.get(label);
		ids.remove(temp.idNum);
		// how to traverse arrayList inEdge to remove the edges to the node deleted
		edgeNum -= temp.inEdge.size();
		temp.inEdge.forEach((i)->nodes.get(i).outEdge.remove(label));
		this.edgeNum -= temp.outCount;
		nodes.remove(label);
		nodeNum -= 1;
		return true;
	}
	else return false;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	// TODO Auto-generated method stub
	if (nodes.containsKey(sLabel)) {
		DiNode temp = nodes.get(sLabel);
		if(temp.outEdge.containsKey(dLabel)) {
			temp.outEdge.remove(dLabel);
			temp.outCount -= 1;
			nodes.get(dLabel).inEdge.remove(sLabel);
			edgeNum -= 1;
			return true;
		}
	}
	return false;
}

@Override
public long numNodes() {
	return nodeNum;
}

@Override
public long numEdges() {
	return edgeNum;
}

@Override
public void print() {
	// TODO Auto-generated method stub
	
}
  

  
  // rest of your code to implement the various operations
}