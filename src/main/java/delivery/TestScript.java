package delivery;

public class TestScript {

	public static void main(String[] args) {
		
		VolumetricWeightCalc calc = new VolumetricWeightCalcImpl();
		System.out.println(calc.calculateVolWeight(26,10,11));
		
		//System.out.println(calc.calculateVolWeight(25,20,21));
		//System.out.println(calc.calculateVolWeight(10,10,11));
		System.out.println(calc.calculateVolWeight(21,21,21));
		
		
		NormalizedWeightCalc calcf = new NormalizedWeightCalcImpl(calc);
		System.out.println(calcf.calculateVolWeight(26,10,11,6));

	}

}
