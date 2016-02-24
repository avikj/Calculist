package me.avikjain.calculist.tests;

import me.avikjain.calculist.*;

public class DerivativeTester {
	public static void main(String[] args){
		Variable x = new Variable("x");
		Function f = new Power(new Addition(x, Constant.ONE), Constant.NEGATIVE_ONE); // (x+1)^(-1)
		System.out.println(f.derivative(x));
	}
}
