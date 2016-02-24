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
	public Function derivative() {	
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
			arguments[0].derivative()	//apply chain rule
		);
	}

}
