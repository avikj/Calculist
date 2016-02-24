package me.avikjain.calculist;

public class Division extends Multiplication {
	public Division(Function a, Function b){
		super(a, new Power(b, new Constant(-1)));
	}
	
	@Override
	public String toString(){
		return String.format("(%s / %s)", arguments[0], arguments[1]);
	}
}
