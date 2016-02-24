package me.avikjain.calculist;

public class Subtraction extends Function {

	public Subtraction(Function a, Function b){
		super(a, b);
	}
	
	@Override
	public double evaluate() {
		return arguments[0].evaluate() - arguments[1].evaluate();
	}

	@Override
	public Function derivative() {
		return new Subtraction(arguments[0].derivative(), arguments[1].derivative());
	}
	
	@Override
	public String toString(){
		return String.format("(%s - %s)", arguments[0], arguments[1]);
	}
}
