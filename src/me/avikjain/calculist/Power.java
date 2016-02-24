package me.avikjain.calculist;

public class Power extends Function {
	
	public Power(Function base, Function exponent){
		super(base, exponent);
	}
	
	@Override
	public double evaluate() {
		return Math.pow(arguments[0].evaluate(), arguments[1].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {	
		return new Multiplication(
			new Multiplication(
				arguments[1], 
				new Power(
					arguments[0], 
					new Subtraction(
						arguments[1],
						Constant.ONE
					)
				)
			),
			arguments[0].derivative(indVar)	//apply chain rule
		);
	}
	
	@Override
	public String toString(){
		return String.format("(%s ^ %s)", arguments[0], arguments[1]);
	}

}
