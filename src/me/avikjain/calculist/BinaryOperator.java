package me.avikjain.calculist;

public abstract class BinaryOperator extends Function {

	public BinaryOperator(Function a, Function b) {
		super(a, b);
	}

	protected abstract String getSymbol();
	
	@Override
	public final String toString(){
		return String.format("(%s%s%s)", arguments[0], getSymbol(), arguments[1]);
	}
}
