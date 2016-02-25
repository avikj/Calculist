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
	public Function derivative(Variable indVar) {
		return new Addition(
			arguments[0].derivative(indVar), 
			arguments[1].derivative(indVar)
		);
	}
	@Override
	public Function copy(){
		return new Addition(arguments[0].copy(), arguments[1].copy());
	}
	@Override
	public String toString(){
		return String.format("(%s + %s)", arguments[0], arguments[1]);
	}
	
	@Override
	protected Function implementSimplify(){
		if(arguments[0].simplify().equals(Constant.ZERO))
			return arguments[1].simplify();
		if(arguments[1].simplify().equals(Constant.ZERO))
			return arguments[0].simplify();
		return this.copy();
	}

}
