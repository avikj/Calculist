package me.avikjain.calculist.tests;

import me.avikjain.calculist.*;

public class DerivativeTester {
	public static void main(String[] args){
		Variable x = new Variable("x");
		Function f = new Ln(new Power(new Addition(x, Constant.ONE), new Constant(2)));
		System.out.printf("d/dx %s \n=%s\n\n",f, f.derivative(x).simplify());
		
		Addition manyZeros = new Addition(Constant.ZERO, Constant.ZERO, new Sin(x), new Cos(x));
		System.out.printf("%s = %s", manyZeros, manyZeros.simplify());
	}
}
