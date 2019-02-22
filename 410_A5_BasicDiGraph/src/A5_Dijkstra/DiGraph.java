package A5_Dijkstra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class DiGraph implements DiGraph_Interface {
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
//rest of your code to implement the various operations
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
	DiNode temp;
	if (idNum < 0) return false; //idNum equal or greater than 0
	if (nodes.containsKey(sLabel)) {temp = nodes.get(sLabel);} //source node exists
	else return false;
	if (temp.outEdgeId.contains(idNum)) return false; //id not unique
	if(! nodes.containsKey(dLabel)) return false; //destination nodes not exist
	if (temp.outEdge.containsKey(dLabel)) return false; //the edge already exist
	else {
		temp.outEdge.put(dLabel, new DiEdge(idNum, sLabel, dLabel, weight, eLabel));
		nodes.get(dLabel).inEdge.add(sLabel);
		temp.outEdgeId.add(idNum);
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
		edgeNum -= temp.inEdge.size();
		temp.inEdge.forEach((i)->nodes.get(i).outEdge.remove(label)); //delete the edge going to this node
		this.edgeNum -= temp.outCount; // deduct the edge number
		nodes.remove(label);
		nodeNum -= 1;
		return true;
	}
	else return false;
}

@Override
public boolean delEdge(String sLabel, String dLabel) {
	if (nodes.containsKey(sLabel)) {
		DiNode temp = nodes.get(sLabel);
		if(temp.outEdge.containsKey(dLabel)) {
			temp.outEdgeId.remove(temp.outEdge.get(dLabel).idNum);
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
public long numNodes() {return nodeNum;}

@Override
public long numEdges() {return edgeNum;}

@Override
public ShortestPathInfo[] shortestPath(String label) {
	if (!nodes.containsKey(label)) return null;
	nodes.get(label).totalWeight = 0;
	PriorityQueue<DiNode> pq = new PriorityQueue<DiNode>();	
	pq.add(nodes.get(label));
	ShortestPathInfo[] pathArray = new ShortestPathInfo[nodeNum];
	int i = 0;
	while (!pq.isEmpty()) {
		DiNode temp = pq.poll(); //retrieve and remove the head of the priority queue -> temp
		if (temp.known) continue;
		temp.known = true;
		pathArray[i] = new ShortestPathInfo(temp.label, temp.totalWeight);
		for (String e_label: temp.outEdge.keySet()) { //e_label iterate all the destination node
			DiNode adjTemp = nodes.get(e_label);
			if (!adjTemp.known) { //node is not known
				long tempWeight = temp.totalWeight + temp.outEdge.get(e_label).weight;
				if (adjTemp.totalWeight < 0) adjTemp.totalWeight = tempWeight;
				else adjTemp.totalWeight = Math.min(adjTemp.totalWeight, tempWeight);
				pq.add(adjTemp);
			}			
		}
		i++;
	}
	while (i < nodeNum) { //node label cannot reach all the rest nodes
		for (String n_label: nodes.keySet()) {
			DiNode temp = nodes.get(n_label);
			if (temp.totalWeight < 0) {
				pathArray[i] = new ShortestPathInfo(temp.label, temp.totalWeight);
				i++;
			}
		}
	}
	return pathArray;
}
public void print() {}
}