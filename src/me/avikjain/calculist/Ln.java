package me.avikjain.calculist;

public class Ln extends Function {
	
	public Ln(Function arg){
		super(arg);
	}
	
	@Override
	public double evaluate() {
		return Math.log(arguments[0].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Division(arguments[0].derivative(indVar), arguments[0]);
	}

	@Override
	public Function copy() {
		return new Ln(arguments[0]);
	}

	@Override
	public Function implementSimplify(){
		if(arguments[0].equals(Constant.E))
			return Constant.ONE;
		if(arguments[0] instanceof Power){
			Power arg0 = (Power)arguments[0];
			return new Multiplication(arg0.arguments[1], new Ln(arg0.arguments[1]));
		}
		return this.copy();
	}
}
