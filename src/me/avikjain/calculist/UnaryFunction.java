package me.avikjain.calculist;

public abstract class UnaryFunction extends Function {
	
	public UnaryFunction(Function arg){
		super(arg);
	}

	public abstract Function basicDerivative();
	public String getFunctionName(){
		return getClass().getSimpleName().toLowerCase();
	}
	
	@Override
	public Function derivative(Variable indVar) {
		return new Multiplication(basicDerivative(), arguments[0].derivative(indVar));
	}
	
	@Override
	public String toString(){
		return String.format("%s(%s)", getFunctionName(), arguments[0]);
	}
}
