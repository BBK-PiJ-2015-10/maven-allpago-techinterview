package delivery;

public class Link {
	
	private Node source;
	
	private Node destination;
	
	private int length;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
		
	public void setSource(Node source) {
		this.source = source;
	}

	public void setDestination(Node destination) {
		this.destination = destination;
	}

	public Node getOther(Node input){
		if (input.equals(source)){
			return destination;
		}
		else if (input.equals(destination)){
			return source;
		}
		return null;
	}
	
	
	

}
