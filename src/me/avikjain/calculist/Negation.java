package me.avikjain.calculist;

public class Negation extends Function {
	
	public Negation(Function a){
		super(a);
	}
	
	@Override
	public double evaluate() {
		return 0-arguments[0].evaluate();
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Negation(arguments[0].derivative(indVar));
	}

	@Override
	public Function copy() {
		return new Negation(arguments[0].copy());
	}
	
	@Override
	public String toString(){
		return String.format("(-%s)", arguments[0]);
	}
	
	@Override
	protected Function implementSimplify(){
		if(arguments[0] instanceof Constant){
			return new Constant(0-arguments[0].evaluate());
		}
		return this;
	}

}
