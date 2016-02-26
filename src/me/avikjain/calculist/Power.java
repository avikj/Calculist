package me.avikjain.calculist;

public class Power extends BinaryOperator {
	
	public Power(Function base, Function exponent){
		super(base, exponent);
	}
	
	@Override
	public double evaluate() {
		return Math.pow(arguments[0].evaluate(), arguments[1].evaluate());
	}

	@Override
	public Function derivative(Variable indVar) {	//	arg1 * arg0^(arg1 - 1) * d/dx(arg0)
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
	public Function copy(){
		return new Power(arguments[0].copy(), arguments[1].copy());
	}
	
	@Override
	protected String getSymbol() {
		return "^";
	}
	

	@Override
	protected Function implementSimplify(){
		if(arguments[1].equals(Constant.ONE))		
			return arguments[0].simplify();
		if(arguments[1].equals(Constant.ZERO))
			return Constant.ONE;
		if(arguments[0].equals(Constant.ONE))
			return Constant.ONE;
		if(arguments[0].equals(Constant.ZERO))
			return Constant.ZERO;
		return this;
	}

}
