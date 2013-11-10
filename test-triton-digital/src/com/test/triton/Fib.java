package com.test.triton;

public class Fib {
	
	public static void main(String args[ ]) { 
		
		printNumbersOfFibonacciSequence(10); 
				
	}

	private static void printNumbersOfFibonacciSequence(Integer numberOfIterations) {
		int i, a = 1, b = 1, sum = 0; 
		
		System.out.print(a); 
		System.out.print(" " + b); 
		
		for(i=0; i<numberOfIterations-2; i++) { 
			sum = a + b; 
			a = b; 
			b = sum; 
			
			System.out.print(" " + sum); 
		
		}
	} 
	
	// 1# Less memory consumed because the application don't need to wait the method stop call itself to release the memory.

	// 2# And, often the method non recursive has a better performance than recursive method.
}
