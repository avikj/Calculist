package me.avikjain.calculist;

public abstract class Function {
	// TODO determine best way to implement simplification (method called in constructor, public method, class, etc.S
	protected Function[] arguments;
	
	public Function(Function... arguments){
		this.arguments = arguments;
		simplify();
	}
	public abstract double evaluate();
	public abstract Function derivative(Variable indVar);
	
	public boolean isConstant(){
		return this instanceof Constant;
	}
	
	public boolean containsVar(){
		if(this instanceof Variable)
			return true;
		for(Function child : arguments)
			if(child.containsVar())
				return true;
		return false;
	}
	
	public boolean containsVar(Variable var){
		if(this.equals(var))
			return true;
		for(Function child : arguments)
			if(child.containsVar(var))
				return true;
		return false;
	}
	
	public boolean equals(Object other){
		// check that 'other' is a function
		if(other instanceof Function){
			Function otherFunction = (Function)other;
			
			// check that 'other' has the same number of arguments as this
			if(otherFunction.arguments.length != arguments.length)
				return false;
			
			// check that the arguments in 'other' and this are the same
			for(int i = 0; i < arguments.length; i++)
				if(!otherFunction.arguments[i].equals(arguments[i]))
					return false;
			return true;
		}
		return false;
	}
	
	private void simplify(){
		for(int i = 0; i < arguments.length; i++){
			
			// if the argument consists only of constants,
			// represent it as a constant
			if(!arguments[i].containsVar()){
				arguments[i] = new Constant(arguments[i].evaluate());
			}
		}
	}
}
