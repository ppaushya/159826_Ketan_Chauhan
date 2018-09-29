package exercise3interface;

public class Calculator implements Operations{

	public Calculator() {
		
	}
	
	@Override
	public float division(float number1, float number2) {
		return number1 / number2;
	}

	@Override
	public int modulo(int divident, int divisor) {
		return divident % divisor;
	}

}
