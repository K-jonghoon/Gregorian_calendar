package com.min.test;

public class Operation {
	
	public void op() {
		int n =0;
		// 값이 아니고 값을 반환하는 것도 가능
		boolean isc1 = (n==0)?a():b();
		// c()의 반환타입이 다르기 때문에
//		boolean isc2 = (n==0)?a():c(); // 
//		String str = (n==0)?a():c();
//		Object str1 = (n==0)?a():c();
//		
		boolean isc3 = (n==0)?a():v(); // syntax 오류
	}
	public void v() {
		
	}
	
	public boolean a() {
		return true;
	}
	
	public boolean b() {
		return false;
	}
	
	public String c() {
		return "a";
	}

}
