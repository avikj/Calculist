package me.avikjain.calculist;

public class Division extends BinaryOperator {

	public Division(Function a, Function b) {
		super(a, b);
	}

	@Override
	protected String getSymbol() {
		return "/";
	}

	@Override
	public double evaluate() {
		return arguments[0].evaluate()/arguments[1].evaluate();
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Multiplication(arguments[0], new Power(arguments[1], Constant.NEGATIVE_ONE)).derivative(indVar);
	}

	@Override
	public Function copy() {
		return new Division(arguments[0], arguments[1]);
	}
	
}
