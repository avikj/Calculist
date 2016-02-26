package me.avikjain.calculist;

public class Sin extends Function {

	public Sin(Function arg){
		super(arg);
	}
	
	@Override
	public double evaluate() {
		return Math.sin(arguments[0].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {
		return new Multiplication(
			new Cos(
				arguments[0]
			),
			arguments[0].derivative(indVar)
		);
	}

	@Override
	public Function copy() {
		return new Sin(arguments[0]);
	}

}
