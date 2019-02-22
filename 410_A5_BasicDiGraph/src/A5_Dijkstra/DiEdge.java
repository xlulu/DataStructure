package A5_Dijkstra;

public class DiEdge {
	long idNum;
	String sLabel;
	String dLabel;
	String eLabel; //the label for the edge, can be null
	long weight;
	
	public DiEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		this.idNum = idNum;
		this.sLabel = sLabel;
		this.dLabel = dLabel;
		this.weight = weight;
		this.eLabel = eLabel;		
	}
}
