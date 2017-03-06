package delivery.unit;

public class Hard<T extends Number> {

	private T hardUnit;
	
	public Hard(T hardUnit){
		this.hardUnit=hardUnit;
	}

	public T getHardUnit() {
		return hardUnit;
	}

	public void setHardUnit(T hardUnit) {
		this.hardUnit = hardUnit;
	}
	
	@Override
	public int hashCode(){
		return hardUnit.hashCode();
	}
	
	@Override
	public boolean equals(Object input){
		if (input == this){
			return true;
		}
		if (!(input instanceof Hard)){
			return false;
		}
	    Number other = ((Hard)input).getHardUnit();
		return this.hardUnit.equals(other);
	}
	
	
}
