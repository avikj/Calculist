package me.avikjain.calculist;

public class Variable extends Function{
	private String name;
	private int value;
	public Variable(String name) {
		this.name = name;
		this.value = 0;
	}
	
	public Variable(String name, int value){
		this.name = name;
		this.value = value;
	}
	
	@Override
	public double evaluate() {
		return value;
	}
	
	@Override
	public String toString(){
		return name;
	}

	@Override
	public Function derivative(Variable indVar) {
		return this.equals(indVar) ? Constant.ONE : Constant.ZERO;
	}
}
