package delivery.graph;

/**
 * 
 * @author YasserAlejandro
 * 
 * A class that encapsulates a Node in order to give it a priority dimension. It needs
 * to implement the Comparable interface.
 */
public class PrioNode implements Comparable {
	
	private Node node;
	
	private Number priority;
	
	public PrioNode(Node node,  Number priority) {
		this.node = node;
		this.priority = priority;
	}
	
	public PrioNode(Node node) {
		this.node = node;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public Number getPriority() {
		return priority;
	}

	public void setPriority(Number priority) {
		this.priority = priority;
	}
	
	@Override
	public int hashCode(){
		return this.node.hashCode();
	}
	
	@Override
	public boolean equals(Object input){
		if (input==this){
			return true;
		}
		if (!(input instanceof PrioNode)){
			return false;
		}
		PrioNode otherNode = ( (PrioNode) input);
		return otherNode.node.equals(this.node);
	}

	@Override
	public int compareTo(Object arg0) {
		Double thisDouble = this.priority.doubleValue();
		PrioNode other = ((PrioNode) arg0);
		Double otherDouble = other.priority.doubleValue();
		return thisDouble.compareTo(otherDouble);
	}
	
	
	
	

}
