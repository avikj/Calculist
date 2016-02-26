package me.avikjain.calculist;

public class Subtraction extends BinaryOperator {

	public Subtraction(Function a, Function b) {
		super(a, b);
	}

	@Override
	protected String getSymbol() {
		return "-";
	}

	@Override
	public double evaluate() {
		return arguments[0].evaluate() - arguments[1].evaluate();
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Subtraction(arguments[0].derivative(indVar), arguments[1].derivative(indVar));
	}

	@Override
	public Function copy() {
		return new Subtraction(arguments[0], arguments[1]);
	}

	@Override
	protected Function implementSimplify(){
		if(arguments[0].simplify().equals(Constant.ZERO))
			return new Negation(arguments[1].simplify()).simplify();
		if(arguments[1].simplify().equals(Constant.ZERO))
			return arguments[0].simplify();
		return this.copy();
	}
}
