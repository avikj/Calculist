package me.avikjain.calculist;

public class Constant extends Function {
	
	public static final Constant ONE = new Constant(1.0);
	public static final Constant ZERO = new Constant(0.0);
	public static final Constant NEGATIVE_ONE = new Constant(-1.0);
	
	private double value;
	
	public Constant(double argument) {
		super();
		value = argument;
	}

	@Override
	public double evaluate() {
		return value;
	}

	@Override
	public Function derivative() {
		return new Constant(0.0);
	}

	@Override
	public String toString(){
		return value >= 0 ? value + "" : "("+value+")";
	}
}
