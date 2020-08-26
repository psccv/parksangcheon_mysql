package kr.or.test;

import java.util.function.Function;
import java.util.function.IntSupplier;

public class LambdaExample {

	public static void main(String[] args) {
		System.out.println(method(3,5));

	}
	public static int method(int x, int y) {
		
		/*IntSupplier supplier = () -> {
			x *= 10; //매개변수 x,y는 상수
			int result = x + y;
			int result = x*10 + y;
			return result;
		};*/
		IntSupplier supplier = new IntSupplier() {	
			@Override
			public int getAsInt() {
				int result = x + y;
				return result;
			}
		};
		int result = supplier.getAsInt();
		return result;
	}
}
