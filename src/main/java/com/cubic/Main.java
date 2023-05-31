package com.cubic;


public class Main {

	public static void main(String[] args) {
		double result=Math.sqrt(37);
		System.out.println(result);
	}
	
	
	private boolean checkPrime(int num) {
		 // Corner case
	    if (num <= 1)
	        return false;
	 
	    // Check from 2 to square root of n
	    for (int i = 2; i <= Math.sqrt(num); i++)
	        if (num % i == 0)
	            return false;
	 
	    return true;
	}
	
	
}
