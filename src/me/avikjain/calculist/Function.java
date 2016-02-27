package me.avikjain.calculist;

import java.util.Arrays;

public abstract class Function {
	protected Function[] arguments;
	/**
	 * Creates a new Function with the arguments passed in.
	 * @param arguments arguments for this function
	 */
	public Function(Function... arguments){
		this.arguments = arguments;
	}
	public abstract double evaluate();
	public abstract Function derivative(Variable indVar);
	public abstract Function copy();
	public boolean isConstant(){
		return this instanceof Constant;
	}
	
	/**
	 * Recursively checks if this <code>Function</code> object's value is dependent on any Variables
	 * @return true if this is Function's value depends on any Variables, false otherwise.
	 */
	public boolean containsVar(){
		if(this instanceof Variable)
			return true;
		for(Function child : arguments)
			if(child.containsVar())
				return true;
		return false;
	}
	
	/**
	 * Recursively checks if this <code>Function</code> is dependent on a specific Variable
	 * @param var	Independent Variable to check
	 * @return	true if this <code>Function</code> object's value depends on <code>var</code>, false otherwise
	 */
	public boolean containsVar(Variable var){
		if(this.equals(var))
			return true;
		for(Function child : arguments)
			if(child.containsVar(var))
				return true;
		return false;
	}
	
	/**
	 * Compares this <code>Function</code> with the specified object.
	 * Recursively checks if this <code>Function</code> is of the same class and
	 * has equal arguments to the parameter.
	 */
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
	/**
	 * Computes a simplified form, if possible, of this <code>Function</code>.
	 * @return A simplified form of this <code>Function</code>, if possible. If not, returns a copy of this <code>Function</code>.
	 */
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
	
	/**
	 * Returns a copy of this <code>Function</code> object's arguments.
	 * @return a copy of this <code>Function</code> object's arguments.
	 */
	public final Function[] getArguments(){
		Function[] copy = new Function[arguments.length];
		for(int i = 0; i < arguments.length; i++)
			copy[i] = arguments[i].copy();
		return copy;
	}
}
