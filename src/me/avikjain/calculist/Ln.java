package me.avikjain.calculist;

public class Ln extends Function {
	
	public Ln(Function arg){
		super(arg);
	}
	
	@Override
	public double evaluate() {
		return Math.log(arguments[0].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Division(arguments[0].derivative(indVar), arguments[0]);
	}

	@Override
	public Function copy() {
		return new Ln(arguments[0]);
	}

}
