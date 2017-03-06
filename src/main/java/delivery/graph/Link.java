package delivery.graph;

import delivery.unit.Hard;

/**
 * @author YasserAlejandro
 * 
 * A class that represents the Links or Edges in graph.
 * @param <T1> a parameter that represents the points being connected.
 * @param <T2> a parameter that represents the distance or weight between points.
 */
public class Link<T1,T2 extends Hard> {
	
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
