package me.avikjain.calculist;

public abstract class Function {
	protected Function[] arguments;
	
	public Function(Function... arguments){
		this.arguments = arguments;
	}
	public abstract double evaluate();
	public abstract Function derivative();
	public boolean isConstant(){
		return this instanceof Constant;
	}
}
