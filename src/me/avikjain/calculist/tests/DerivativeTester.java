package me.avikjain.calculist.tests;

import me.avikjain.calculist.*;

public class DerivativeTester {
	public static void main(String[] args){
		Variable x = new Variable("x");
		Function f = new Ln(new Power(new Addition(x, Constant.ONE), new Constant(2)));
		System.out.printf("d/dx %s \n=%s",f, f.derivative(x).simplify());
	}
}
