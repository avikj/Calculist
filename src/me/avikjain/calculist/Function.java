package me.avikjain.calculist;

import java.util.Arrays;

public abstract class Function {
	// TODO determine best way to implement simplification (method called in constructor, public method, class, etc.S
	protected Function[] arguments;
	
	public Function(Function... arguments){
		this.arguments = arguments;
	}
	public abstract double evaluate();
	public abstract Function derivative(Variable indVar);
	public abstract Function copy();
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
	
	@Override
	public boolean equals(Object other){
		// check that 'other' is a function of the same type as this
		if(this.getClass().equals(other.getClass())){
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
	
	public final Function simplify(){
		Function result = this.copy();
		// if the function consists only of constants,
		// represent it as a constant
		
		if(!result.containsVar() && !result.isConstant()){
			result = new Constant(result.evaluate());
		}
		for(int i = 0; i < result.arguments.length; i++){			
			result.arguments[i] = result.arguments[i].simplify();
		}
		
		return result.implementSimplify();
	}
	
	protected Function implementSimplify(){
		return this;
	}
	
	@Override
	public Object clone(){
		return this.copy();
	}
	
	@Override
	public String toString(){
		return String.format("%s(%s)", this.getClass().getSimpleName().toLowerCase(),
				Arrays.toString(arguments).substring(1, Arrays.toString(arguments).length()-1));
	}
}
