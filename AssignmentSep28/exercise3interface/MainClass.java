package exercise3interface;

public class MainClass {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
		float n1=5,n2=4;
		float a1 = calculator.division(n1, n2);
		System.out.println("Division: "+n1+"/"+n2+" = "+a1);
		
		int num1=5,num2=4;
		int a2 = calculator.modulo(num1, num2);
		System.out.println("Modulo: "+num1+"%"+num2+" = "+a2);

	}

}
