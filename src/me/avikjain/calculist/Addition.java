package me.avikjain.calculist;

import java.util.ArrayList;

public class Addition extends Function {
	public Addition(Function... addends){
		super(addends);
	}
	
	@Override
	public double evaluate() {
		double result = 0;
		for(Function arg : arguments)
			result += arg.evaluate();
		return result;
	}

	@Override
	public Function derivative(Variable indVar) {
		Function[] derivs = new Function[arguments.length];
		for(int i = 0; i < derivs.length; i++)
			derivs[i] = arguments[i].derivative(indVar);
		return new Addition(derivs);
	}
	@Override
	public Function copy(){
		Function[] copies = new Function[arguments.length];
		for(int i = 0; i < copies.length; i++)
			copies[i] = arguments[i].copy();
		return new Addition(copies);
	}
	
	@Override
	protected Function implementSimplify(){
		Function[] args = this.copy().arguments;
		
		// simplify arguments
		for(int i= 0; i < args.length; i++)
			args[i] = args[i].simplify();
		
		// take out internal additions and remove zeroes simultaneously
		ArrayList<Function> newArgs = new ArrayList<Function>();
		int j = 0;
		for(Function arg : args){
			if(arg instanceof Addition){
				Function additionArg = (Addition)arg;
				for(Function subArg : additionArg.arguments)
					if(!subArg.equals(Constant.ZERO))
						newArgs.add(subArg);
			}else if(!arg.equals(Constant.ZERO)){
				newArgs.add(arg);
			}
		}
		
		return new Addition(newArgs.toArray(new Function[newArgs.size()]));
	}
	
	private Function removeZeros(){
		Function[] copies = this.copy().arguments;
		for(int i = 0; i < copies.length; i++)
			copies[i] = copies[i].simplify();
		Function[] zerosRemoved = new Function[copies.length-countZeros(copies)];
		
		int j = 0;
		for(Function f : copies)
			if(!f.equals(Constant.ZERO))
				zerosRemoved[j++] = f;
		return new Addition(zerosRemoved);
	}
	
	private int countZeros(Function[] fs){
		int count = 0;
		for(Function f : fs)
			if(f.equals(Constant.ZERO))
				count++;
		return count;
	}

	
	@Override
	public String toString(){
		if(arguments.length == 0)
			return "";
		String result = "";
		for(Function arg : arguments)
			result+="+"+arg;
		return "("+result.substring(1)+")";
	}
}
