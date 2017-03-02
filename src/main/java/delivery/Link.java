package delivery;

public class Link<T1,T2 extends Number> {
	
	private T1 source;
	
	private T1 destination;
	
	private T2 length;

	public T2 getLength() {
		return length;
	}

	public void setLength(T2 length) {
		this.length = length;
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
	
	
	

}
