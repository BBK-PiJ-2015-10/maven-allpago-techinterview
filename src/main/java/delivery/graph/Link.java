package delivery.graph;

public class Link<T1,T2 extends Number> {
	
	private T1 source;
	
	private T1 destination;
	
	private T2 weight;

	public T2 getWeight() {
		return weight;
	}

	public void setLength(T2 weight) {
		this.weight = weight;
	}
		
	public void setSource(T1 source) {
		this.source = source;
	}

	public void setDestination(T1 destination) {
		this.destination = destination;
	}

	public T1 getOther(T1 input){
		if (input.equals(source)){
			return destination;
		}
		else if (input.equals(destination)){
			return source;
		}
		return null;
	}
	
	public String toString(){
		String result;
		result ="From " +source.toString() +" to " +destination.toString() +" with a link of " +weight;
		return result;
	}
	
	

}
