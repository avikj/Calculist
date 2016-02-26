package me.avikjain.calculist;

public class Cos extends Function{

	public Cos(Function arg){
		super(arg);
	}
	
	@Override
	public double evaluate() {
		return Math.cos(arguments[0].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Multiplication(
			new Negation(
				new Sin(arguments[0])
			), 
			arguments[0].derivative(indVar)
		);
		
	}

	@Override
	public Function copy() {
		return new Cos(arguments[0]);
	}

}
