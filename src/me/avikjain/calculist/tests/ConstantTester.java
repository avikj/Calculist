package me.avikjain.calculist.tests;

import me.avikjain.calculist.Constant;


public class ConstantTester {
	public static void main(String[] args){
		Constant fourteen = new Constant(14.0);
		System.out.println(fourteen);
		
		Constant negativeSeven = new Constant(-7.0);
		System.out.println(negativeSeven);
		
		Constant pi = new Constant(Math.PI);
		System.out.println(pi);
		
	}
}
