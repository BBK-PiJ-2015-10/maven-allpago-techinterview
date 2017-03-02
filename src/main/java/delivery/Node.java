package delivery;

import java.util.Set;
import java.util.HashSet;

public class Node {
	
	private String nodeName;
	
	private Set<Link> links;
	
	public Node(String nodeName){
		this.nodeName=nodeName;
		links = new HashSet();
	}
	
	public String getName(){
		return this.nodeName;
	}
	
	public Set<Link> getLinks() {
		return links;
	}
	
	public void addLink(Link newLink){
		links.add(newLink);
	}

	@Override
	public int hashCode(){
		return nodeName.hashCode();
	}
	
	@Override
	public boolean equals(Object input){
		if (input==this){
			return true;
		}
		if (!(input instanceof Node)){
			return false;
		}
		String otherName = ((Node) input).getName();
		return otherName.equals(this.nodeName);
	}
	


}
