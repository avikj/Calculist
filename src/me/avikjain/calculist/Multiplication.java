package me.avikjain.calculist;

public class Multiplication extends BinaryOperator {

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
	public Function copy(){
		return new Multiplication(arguments[0].copy(), arguments[1].copy());
	}
	
	@Override
	public Function implementSimplify(){
		if(arguments[0].equals(Constant.ONE))
			return arguments[1];
		if(arguments[1].equals(Constant.ONE))
			return arguments[0];
		
		if(arguments[0].equals(Constant.NEGATIVE_ONE))
			return new Negation(arguments[1]);
		if(arguments[1].equals(Constant.NEGATIVE_ONE))
			return new Negation(arguments[0]);
		return this;
	}

	@Override
	protected String getSymbol() {
		return "*";
	}
}
