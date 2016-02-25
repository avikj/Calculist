package me.avikjain.calculist;

public class Subtraction extends Addition {

	public Subtraction(Function a, Function b){
		super(a, new Negation(b));
	}
	
	@Override
	public Function copy(){
		return new Subtraction(arguments[0].copy(), arguments[1].copy());
	}
	
	@Override
	public String getSymbol(){
		return "-";
	}
	
}
