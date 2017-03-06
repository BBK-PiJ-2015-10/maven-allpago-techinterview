package delivery.graph;

import java.util.Set;
import java.util.HashSet;

/**
 * 
 * @author YasserAlejandro
 * A Node represents a point in graph.
 * @param <T> a Class that will serve as the nodeID.
 */
public class Node<T> {
	
	//An field that uniquely identifies a node.
	private T nodeID;
	
	//The links that the node has
	private Set<Link> links;
	
	public Node(T nodeID){
		this.nodeID=nodeID;
		links = new HashSet();
	}
		
	public T getnodeID(){
		return this.nodeID;
	}
	
	public Set<Link> getLinks() {
		return links;
	}
	
	public void addLink(Link newLink){
		links.add(newLink);
	}

	@Override
	public int hashCode(){
		return nodeID.hashCode();
	}
	
	@Override
	public boolean equals(Object input){
		if (input==this){
			return true;
		}
		if (!(input instanceof Node)){
			return false;
		}
		Node otherNode = ( (Node) input);
		return otherNode.nodeID.equals(this.nodeID);
	}
	
	@Override
	public String toString(){
		return nodeID.toString();
	}


}
