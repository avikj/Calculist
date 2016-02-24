package me.avikjain.calculist;

public class Multiplication extends Function {

	public Multiplication(Function a, Function b){
		super(a, b);
	}
	
	@Override
	public double evaluate() {
		return arguments[0].evaluate() * arguments[1].evaluate();
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Addition(
			new Multiplication(arguments[0], arguments[1].derivative(indVar)), 
			new Multiplication(arguments[0].derivative(indVar), arguments[1])
		);
	}
	
	@Override
	public String toString(){
		return String.format("(%s * %s)", arguments[0], arguments[1]);
	}
}
