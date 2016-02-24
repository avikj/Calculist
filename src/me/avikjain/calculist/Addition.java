package me.avikjain.calculist;

public class Addition extends Function {
	public Addition(Function a, Function b){
		super(a, b);
	}
	
	@Override
	public double evaluate() {
		return arguments[0].evaluate() + arguments[1].evaluate();
	}

	@Override
	public Function derivative() {
		return new Addition(arguments[0].derivative(), arguments[1].derivative());
	}
	
	@Override
	public String toString(){
		return String.format("(%s + %s)", arguments[0], arguments[1]);
	}

}
